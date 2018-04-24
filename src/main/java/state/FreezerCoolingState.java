package state;

import context.*;
import observable.*;
import threads.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerCoolingState extends AbstractCoolingState
	implements DoorOpenListener, ClockListener {

	private static FreezerCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerCoolingState() {
	}
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FreezerCoolingState
	 */
	public static FreezerCoolingState instance() {
		if (instance == null) {
			instance = new FreezerCoolingState();
			instance.initialize( FreezerContext.instance() );
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		ClockListenerList.instance().addListener(instance);
		FreezerDoorOpenListenerList.instance().addListener(instance);
		
		// Change context variables
		context.setIsCooling(true);
		
		//DEBUG
		System.out.println("Run Freezer Cooling");
	}
	
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FreezerDoorOpenListenerList.instance().removeListener(instance);
		
		// Change context variables
		context.setIsCooling(false);
		
		// DEBUG
		System.out.println("Leave Freezer Cooling");
	}
	
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( FreezerDoorOpenState.instance() );
	}
	
	@Override
	public void onClockTick() {
		boolean changeState = changeTemperature();
		
		// DEBUG
		System.out.println( "Freezer: " + String.valueOf( context.getSubjectTemperature().getValue() ) );
		if (changeState) {
			context.changeCurrentState( FreezerDoorClosedState.instance() );
		}
	}
}
