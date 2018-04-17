package State;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerDoorOpenState extends state.AbstractDoorOpenState {

	private static FreezerDoorOpenState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorOpenState() {		
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
	
}