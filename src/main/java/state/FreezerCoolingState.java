package state;

import context.AbstractRefridgeratorContext;
import context.Common;
import context.FreezerContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerCoolingState extends AbstractRefridgeratorState{

	private static FreezerCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerCoolingState() {
		super(FreezerContext.instance(), Common.getFreezerCoolRate() * -1);
	}
	/**
	 * 
	 * @return
	 */
	public static FreezerCoolingState instance() {
		if (instance == null) {
			instance = new FreezerCoolingState();
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
		if(context.getSubjectTemperature().getValue()<
				context.getDesiredTemparature().getValue() - Common.getFreezerCompressorStartDiff()) {
			
			context.changeCurrentState(FreezerDoorClosedState.instance());
			
		}
	}
	
}
