package observable;

public class FridgeDoorOpenListenerList extends DoorOpenListenerList {
	private static FridgeDoorOpenListenerList instance;
	/**
	 * Constructor for singleton
	 */
	private FridgeDoorOpenListenerList() {
	}
	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance FridgeDoorOpenListenerList
	 */
	public static FridgeDoorOpenListenerList instance() {
		if (instance == null) {
			instance = new FridgeDoorOpenListenerList();
		}
		return instance;
	}
}
