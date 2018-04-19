package observable;

/**
 * 
 * @author Colin Quinn
 *
 */
public class FridgeDoorCloseListenerList extends DoorCloseListenerList {
	private static FridgeDoorCloseListenerList instance;
	/**
	 * Constructor for singleton
	 */
	private FridgeDoorCloseListenerList() {
	}
	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance FridgeDoorCloseListenerList
	 */
	public static FridgeDoorCloseListenerList instance() {
		if (instance == null) {
			instance = new FridgeDoorCloseListenerList();
		}
		return instance;
	}
}
