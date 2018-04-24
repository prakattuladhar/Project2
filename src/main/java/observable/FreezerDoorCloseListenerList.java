package observable;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class maintains a list of listeners to the DoorCloseEvent for the freezer
 *
 */
public class FreezerDoorCloseListenerList extends DoorCloseListenerList {
	private static FreezerDoorCloseListenerList instance;
	/**
	 * Constructor for singleton
	 */
	private FreezerDoorCloseListenerList() {
	}
	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance FreezerDoorCloseListnerList
	 */
	public static FreezerDoorCloseListenerList instance() {
		if (instance == null) {
			instance = new FreezerDoorCloseListenerList();
		}
		return instance;
	}
}
