package State;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorCoolingState extends state.AbstractCoolingState {

	private static RefridgeratorCoolingState instance;
	/**
	 * Supports Singleton pattern
	 */
	private RefridgeratorCoolingState() {		
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
	
}
