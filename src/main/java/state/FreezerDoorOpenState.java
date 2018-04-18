package State;

import context.Common;
import context.FreezerContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
<<<<<<< HEAD
public class FreezerDoorOpenState extends AbstractDoorOpenState {
=======
public class FreezerDoorOpenState extends AbstractRefridgeratorState {
>>>>>>> 8cb682e813f57814a33d405ec630c95f9f5a616f

	private static FreezerDoorOpenState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorOpenState() {
<<<<<<< HEAD
		super();
=======
		super(FreezerContext.instance(), Common.getFreezerRateLossDoorOpen());
>>>>>>> 8cb682e813f57814a33d405ec630c95f9f5a616f
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
<<<<<<< HEAD

	@Override
	public void leave() {

	}
=======
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
	
>>>>>>> 8cb682e813f57814a33d405ec630c95f9f5a616f
}
