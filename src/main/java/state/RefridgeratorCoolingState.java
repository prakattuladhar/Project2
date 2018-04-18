package state;

import context.Common;
import context.RefridgeratorContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorCoolingState extends AbstractRefridgeratorState {

	private static RefridgeratorCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private RefridgeratorCoolingState() {
		super(RefridgeratorContext.instance(), Common.getFridgeCoolRate()*-1);
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

	public void initObervers(){

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
				context.getDesiredTemparature().getValue() - Common.getFridgeCompressorStartDiff()) {
			
			context.changeCurrentState(RefridgeratorDoorClosedState.instance());
			
		}		
	}
	
}
