package observable;

import javax.swing.event.EventListenerList;

/**
 * 
 * @author Colin Quinn
 *
 */
public abstract class DoorCloseListenerList {
	private EventListenerList listenerList = new EventListenerList();
	/**
	 * Subscribes a listener
	 * 
	 * @param listener: listener object to be added
	 */
	public void addListener(DoorCloseListener listener) {
		listenerList.add(DoorCloseListener.class, listener);
	}
	/**
	 * Unsubscribes a listener
	 * 
	 * @param listener: listener object to be removed
	 */
	public void removeListener(DoorCloseListener listener) {
		listenerList.remove(DoorCloseListener.class, listener);
	}
	/**
	 * Notifies listeners that door opened
	 * 
	 * @param event 
	 */
	public void notifyListeners(DoorCloseEvent event) {
		DoorCloseListener[] listeners = listenerList.getListeners(DoorCloseListener.class);
		for (int i = 0; i < listeners.length; i++) {
			listeners[i].onDoorClose(event);
		}	
	}
}
