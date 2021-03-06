package state;

import context.*;
import observable.*;
import threads.*;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class represents a the state of a freezer with the door open
 * and compressor off.  The freezer will cool until room temperature is reached
 *
 */

public class FreezerDoorOpenState extends AbstractDoorOpenState
	implements DoorCloseListener {

	private static FreezerDoorOpenState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorOpenState() {
	}
	/**
	 * Gets only instance of this object  and passes super class the correct context
	 * 
	 * @return only instance of FreezerDoorOpenState
	 */
	public static FreezerDoorOpenState instance() {
		if (instance == null) {
			instance = new FreezerDoorOpenState();
			instance.initialize( FreezerContext.instance() );
		}
		return instance;
	}

	@Override
	public void run() {
		// Subscribe to Events
		ClockListenerList.instance().addListener(instance);
		FreezerDoorCloseListenerList.instance().addListener(instance);
		
		// DEBUG
		// System.out.println("Run Freezer Open");
	}
	
	@Override
	public void leave() {
		// Unsubscribe from Events
		ClockListenerList.instance().removeListener(instance);
		FreezerDoorCloseListenerList.instance().removeListener(instance);
		
		// DEBUG
		// System.out.println("Leave Freezer Closed");
	}
	@Override
	public void onDoorClose(DoorCloseEvent event) {
		context.changeCurrentState( FreezerDoorClosedState.instance() );
	}
}
