package State;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerDoorClosedState extends state.AbstractDoorClosedState {

	private static FreezerDoorClosedState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerDoorClosedState() {		
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
	
}
