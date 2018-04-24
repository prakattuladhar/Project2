package observable;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class maintains a list of listeners to the DoorOpenEvent for the freezer
 *
 */
public class FreezerDoorOpenListenerList extends DoorOpenListenerList {
	private static FreezerDoorOpenListenerList instance;
	/**
	 * Constructor for singleton
	 */
	private FreezerDoorOpenListenerList() {
	}
	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance FreezerDoorOpenListnerList
	 */
	public static FreezerDoorOpenListenerList instance() {
		if (instance == null) {
			instance = new FreezerDoorOpenListenerList();
		}
		return instance;
	}
}