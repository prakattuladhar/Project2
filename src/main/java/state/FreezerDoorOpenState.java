package state;

import context.Common;
import context.FreezerContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerDoorOpenState extends AbstractRefridgeratorState {

	private static FreezerDoorOpenState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorOpenState() {
		super(FreezerContext.instance(), Common.getFreezerRateLossDoorOpen());
	}
	/**
	 * 
	 * @return
	 */
	public FreezerDoorOpenState instance() {
		if (instance == null) {
			instance = new FreezerDoorOpenState();
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
		//Do Nothing!!!		
	}
	
}
