package state;

import context.*;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorCoolingState extends AbstractRefridgeratorState
	implements DoorOpenListener {

	private static RefridgeratorCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private RefridgeratorCoolingState() {
		super(FridgeContext.instance(), Common.getFridgeCoolRate()*-1);
	}
	/**
	 * 
	 * @return
	 */
	public static RefridgeratorCoolingState instance() {
		if (instance == null) {
			instance = new RefridgeratorCoolingState();
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		super.run();
		FridgeDoorOpenListenerList.instance().addListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		super.leave();
		FridgeDoorOpenListenerList.instance().removeListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( RefridgeratorDoorOpenState.instance() );
	}
	@Override
	public void tempReached() {
		if(context.getSubjectTemperature().getValue()<
				context.getDesiredTemparature().getValue() - Common.getFridgeCompressorStartDiff()) {
			
			context.changeCurrentState(RefridgeratorDoorClosedState.instance());
			
		}		
	}
	
}
