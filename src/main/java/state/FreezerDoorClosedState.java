package state;

import context.*;
import observable.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerDoorClosedState extends AbstractRefridgeratorState
	implements DoorOpenListener {

	private static FreezerDoorClosedState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorClosedState() {
		super(FreezerContext.instance(), Common.getFreezerRateLossDoorClosed());
	}
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FreezerDoorClosedState
	 */
	public static FreezerDoorClosedState instance() {
		if (instance == null) {
			instance = new FreezerDoorClosedState();
		}
		return instance;
	}
	@Override
	public void run() {
		// Subscribe to Events
		super.run();
		FreezerDoorOpenListenerList.instance().addListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void leave() {
		// Unsubscribe from Events
		super.leave();
		FreezerDoorOpenListenerList.instance().removeListener(instance);
		
		// TODO: Change context variables
	}
	@Override
	public void onDoorOpen(DoorOpenEvent event) {
		context.changeCurrentState( FreezerDoorOpenState.instance() );
	}
	@Override
	public void tempReached() {
		if(context.getSubjectTemperature().getValue()> 
				context.getDesiredTemparature().getValue() + Common.getFreezerCompressorStartDiff()) 
		{
			context.changeCurrentState( FreezerCoolingState.instance() );
		}
	}
}
