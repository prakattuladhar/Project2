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
public class RefridgeratorDoorOpenState extends AbstractDoorOpenState 
	implements DoorCloseListener {

	private static RefridgeratorDoorOpenState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorOpenState() {	
	}
	/**
	 * 
	 * @return
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
		
		//DEBUG
		System.out.println("Run Fridge Open");
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FridgeDoorCloseListenerList.instance().removeListener(instance);
		
		//DEBUG
		System.out.println("Leave Fridge Open");
	}
	@Override
	public void onDoorClose(DoorCloseEvent event) {
		context.changeCurrentState( RefridgeratorDoorClosedState.instance() );
	}
	
}
