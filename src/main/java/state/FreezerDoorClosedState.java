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
public class FreezerDoorClosedState extends AbstractDoorClosedState
	implements DoorOpenListener, ClockListener {

	private static FreezerDoorClosedState instance;
	
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorClosedState() {
	}
	
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FreezerDoorClosedState
	 */
	public static FreezerDoorClosedState instance() {
		if (instance == null) {
			instance = new FreezerDoorClosedState();
			instance.initialize( FreezerContext.instance() );
		}
		return instance;
	}
	
	@Override
	public void run() {
		// Subscribe to Events
		ClockListenerList.instance().addListener(instance);
		FreezerDoorOpenListenerList.instance().addListener(instance);
		
		//DEBUG
		System.out.println("Run Freezer Closed");
	}
	
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FreezerDoorOpenListenerList.instance().removeListener(instance);
		
		// DEBUG
		System.out.println("Leave Freezer Closed");
	}
	
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( FreezerDoorOpenState.instance() );
	}
	
	@Override
	public void onClockTick() {
		boolean changeState = changeTemperature();
		if (changeState) {
			context.changeCurrentState( FreezerCoolingState.instance() );
		}
	}
}
