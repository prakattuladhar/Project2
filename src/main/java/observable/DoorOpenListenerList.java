package observable;

import javax.swing.event.EventListenerList;

/**
 * 
 * @author Colin Quinn
 *
 */
public class DoorOpenListenerList {
	private EventListenerList listenerList = new EventListenerList();
	/**
	 * Subscribes a listener
	 * 
	 * @param listener: listener object to be added
	 */
	public void addListener(DoorOpenListener listener) {
		listenerList.add(DoorOpenListener.class, listener);
	}
	/**
	 * Unsubscribes a listener
	 * 
	 * @param listener: listener object to be removed
	 */
	public void removeListener(DoorOpenListener listener) {
		listenerList.remove(DoorOpenListener.class, listener);
	}
	/**
	 * Notifies listeners that door opened
	 * 
	 * @param event 
	 */
	public void notifyListeners(DoorOpenEvent event) {
		for ( DoorOpenListener listener : listenerList.getListeners(DoorOpenListener.class) ) {
			listener.onDoorOpen(event);
		}	
	}
}
