package state;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorDoorClosedState extends state.AbstractDoorClosedState {

	private static RefridgeratorDoorClosedState instance;
	/**
	 * Supports Singleton patter
	 */
	private RefridgeratorDoorClosedState() {		
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
	
}
