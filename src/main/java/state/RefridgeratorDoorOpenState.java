package state;

import context.*;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorDoorOpenState extends AbstractRefridgeratorState
	implements DoorCloseListener {

	private static RefridgeratorDoorOpenState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorOpenState() {	
		super(FridgeContext.instance(), Common.getFridgeRateLossDoorOpen());
	}
	/**
	 * 
	 * @return
	 */
	public static RefridgeratorDoorOpenState instance() {
		if (instance == null) {
			instance = new RefridgeratorDoorOpenState();
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		FridgeDoorCloseListenerList.instance().addListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		FridgeDoorCloseListenerList.instance().removeListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void onDoorClose(DoorCloseEvent event) {
		context.changeCurrentState( RefridgeratorDoorClosedState.instance() );
	}
	@Override
	public void tempReached() {
		// Do Nothing!!!		
	}
	
}
