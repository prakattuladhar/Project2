package state;

import context.*;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerCoolingState extends AbstractRefridgeratorState
	implements DoorOpenListener {

	private static FreezerCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerCoolingState() {
		super(FreezerContext.instance(), Common.getFreezerCoolRate() * -1);
	}
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FreezerCoolingState
	 */
	public static FreezerCoolingState instance() {
		if (instance == null) {
			instance = new FreezerCoolingState();
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		FreezerDoorOpenListenerList.instance().addListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		FreezerDoorOpenListenerList.instance().removeListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( FreezerDoorOpenState.instance() );
	}
	@Override
	public void tempReached() {
		if(context.getSubjectTemperature().getValue()<
				context.getDesiredTemparature().getValue() - Common.getFreezerCompressorStartDiff()) {
			
			context.changeCurrentState(FreezerDoorClosedState.instance());
			
		}
	}
}
