package state;

import context.Common;
import context.FridgeContext;
import context.RefridgeratorContext;


/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorDoorClosedState extends AbstractRefridgeratorState {

	private static RefridgeratorDoorClosedState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorClosedState() {	
		super(RefridgeratorContext.instance(), Common.getFridgeRateLossDoorClosed());
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
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
