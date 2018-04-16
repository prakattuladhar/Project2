package State;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorDoorOpenState extends state.AbstractDoorOpenState {

	private static RefridgeratorDoorOpenState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorOpenState() {		
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
	
}
