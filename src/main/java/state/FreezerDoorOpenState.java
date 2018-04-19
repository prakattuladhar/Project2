package state;

import context.*;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */

public class FreezerDoorOpenState extends AbstractRefridgeratorState
	implements DoorCloseListener {

	private static FreezerDoorOpenState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorOpenState() {

		super(FreezerContext.instance(), Common.getFreezerRateLossDoorOpen());
	}
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FreezerDoorOpenState
	 */
	public static FreezerDoorOpenState instance() {
		if (instance == null) {
			instance = new FreezerDoorOpenState();
		}
		return instance;
	}

	@Override
	public void run() {
		// Subscribe to Events
		FreezerDoorCloseListenerList.instance().addListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		FreezerDoorCloseListenerList.instance().removeListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void onDoorClose(DoorCloseEvent event) {
		context.changeCurrentState( FreezerDoorClosedState.instance() );
	}
	@Override
	public void tempReached() {
		//Do Nothing!!!		
	}
}
