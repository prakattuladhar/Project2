package State;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerCoolingState extends state.AbstractCoolingState {

	private static FreezerCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private FreezerCoolingState() {		
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
	
}
