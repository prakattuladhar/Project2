package state;

import context.Common;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorDoorOpenState extends AbstractRefridgeratorState {

	private static RefridgeratorDoorOpenState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorOpenState() {	
		super(RefridgeratorContext.instance(), Common.getFridgeRateLossDoorOpen());
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void tempReached() {
		// Do Nothing!!!		
	}
	
}
