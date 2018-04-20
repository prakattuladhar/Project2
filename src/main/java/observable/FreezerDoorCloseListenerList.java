package observable;

/**
 * 
 * @author Colin Quinn
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
