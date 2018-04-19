package state;

import context.*;
import observable.*;


/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorDoorClosedState extends AbstractRefridgeratorState
	implements DoorOpenListener {

	private static RefridgeratorDoorClosedState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorClosedState() {	
		super(FridgeContext.instance(), Common.getFridgeRateLossDoorClosed());
	}
	/**
	 * 
	 * @return
	 */
	public static RefridgeratorDoorClosedState instance() {
		if (instance == null) {
			instance = new RefridgeratorDoorClosedState();
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		FridgeDoorOpenListenerList.instance().addListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		FridgeDoorOpenListenerList.instance().removeListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( RefridgeratorDoorOpenState.instance() );
	}
	@Override
	public void tempReached() {
		if(context.getSubjectTemperature().getValue()> 
			context.getDesiredTemparature().getValue() + Common.getFridgeCompressorStartDiff()) 
		{
			context.changeCurrentState(RefridgeratorCoolingState.instance());
		}
	}
	
}
