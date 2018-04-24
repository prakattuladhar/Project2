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
public class RefridgeratorDoorClosedState extends AbstractDoorClosedState
	implements DoorOpenListener, ClockListener {

	private static RefridgeratorDoorClosedState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorClosedState() {	
	}
	/**
	 * 
	 * @return
	 */
	public static RefridgeratorDoorClosedState instance() {
		if (instance == null) {
			instance = new RefridgeratorDoorClosedState();
			instance.initialize( FridgeContext.instance() );
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		ClockListenerList.instance().addListener(instance);
		FridgeDoorOpenListenerList.instance().addListener(instance);
		
		//DEBUG
		System.out.println("Run Fridge Closed");
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FridgeDoorOpenListenerList.instance().removeListener(instance);
		
		//DEBUG
		System.out.println("Leave Fridge Closed");
	}
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( RefridgeratorDoorOpenState.instance() );
	}
	@Override
	public void onClockTick() {
		boolean changeState = changeTemperature();
		if (changeState) {
			context.changeCurrentState( RefridgeratorCoolingState.instance() );
		}
	}
	
}
