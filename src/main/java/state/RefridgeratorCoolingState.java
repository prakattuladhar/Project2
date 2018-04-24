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
public class RefridgeratorCoolingState extends AbstractCoolingState
	implements DoorOpenListener, ClockListener {

	private static RefridgeratorCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private RefridgeratorCoolingState() {
	}
	/**
	 * 
	 * @return
	 */
	public static RefridgeratorCoolingState instance() {
		if (instance == null) {
			instance = new RefridgeratorCoolingState();
			instance.initialize( FridgeContext.instance() );
		}
		return instance;
	}
	
	@Override
	public void run() {
		// Subscribe to Events
		ClockListenerList.instance().addListener(instance);
		FridgeDoorOpenListenerList.instance().addListener(instance);
		
		// Change context variables
		context.setIsCooling(true);
		
		//DEBUG
		System.out.println("Run Fridge Cooling");
	}
	
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FridgeDoorOpenListenerList.instance().removeListener(instance);
		
		// Change context variables
		context.setIsCooling(false);
		
		//DEBUG
		System.out.println("Leave Fridge Cooling");
	}
	
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( RefridgeratorDoorOpenState.instance() );
	}
	
	public void onClockTick() {
		boolean changeState = changeTemperature();
		
		// DEBUG
		System.out.println( "Fridge: " + String.valueOf( context.getSubjectTemperature().getValue() ) );
		if (changeState) {
			context.changeCurrentState( RefridgeratorDoorClosedState.instance() );
		}
	}
	
}
