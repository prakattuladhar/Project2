package state;

import context.Common;
import context.FreezerContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerDoorClosedState extends AbstractRefridgeratorState {

	private static FreezerDoorClosedState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorClosedState() {
		super(FreezerContext.instance(), Common.getFreezerRateLossDoorClosed());
	}
	/**
	 * 
	 * @return
	 */
	public static FreezerDoorClosedState instance() {
		if (instance == null) {
			instance = new FreezerDoorClosedState();
		}
		return instance;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tempReached() {
		if(context.getSubjectTemperature().getValue()> 
				context.getDesiredTemparature().getValue() + Common.getFreezerCompressorStartDiff()) 
		{
			context.changeCurrentState(FreezerCoolingState.instance());
		}
	}
	
}
