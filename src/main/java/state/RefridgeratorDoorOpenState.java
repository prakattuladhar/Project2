package state;

import context.*;
import observable.*;
import threads.*;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class represents a the state of a refrigerator with the door open
 * and compressor off.  The refrigerator will cool until room temperature is reached
 *
 */
public class RefridgeratorDoorOpenState extends AbstractDoorOpenState 
	implements DoorCloseListener {

	private static RefridgeratorDoorOpenState instance;
	/**
	 * Supports Singleton pattern
	 */
	private RefridgeratorDoorOpenState() {	
	}
	/**
	 * Gets only instance of this object and passes super class the correct context
	 * 
	 * @return only instance of RefridgeratorDoorOpenState
	 */
	public static RefridgeratorDoorOpenState instance() {
		if (instance == null) {
			instance = new RefridgeratorDoorOpenState();
			instance.initialize( FridgeContext.instance() );
		}
		return instance;
	}
	
	@Override
	public void run() {
		// Subscribe to Events
		ClockListenerList.instance().addListener(instance);
		FridgeDoorCloseListenerList.instance().addListener(instance);
		
		// DEBUG
		// System.out.println("Run Fridge Open");
	}
	
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FridgeDoorCloseListenerList.instance().removeListener(instance);
		
		// DEBUG
		// System.out.println("Leave Fridge Open");
	}
	
	@Override
	public void onDoorClose(DoorCloseEvent event) {
		context.changeCurrentState( RefridgeratorDoorClosedState.instance() );
	}
	
}
