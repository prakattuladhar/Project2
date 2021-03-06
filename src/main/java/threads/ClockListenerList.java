package threads;

import javax.swing.event.EventListenerList;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class maintains a list of listeners to the ClockTickEvent
 *
 */
public class ClockListenerList implements Observer {
	private static ClockListenerList instance;
	private EventListenerList listenerList = new EventListenerList();
	
	/**
	 * For singleton
	 */
	private ClockListenerList() {
		instance = this;
		Clock.instance().addObserver(instance);
	}

	/**
	 * For singleton pattern
	 * 
	 * @return the instance
	 */
	public static ClockListenerList instance() {
		if (instance == null) {
			instance = new ClockListenerList();
		}
		return instance;
	}
	/**
	 * Subscribes a listener
	 * 
	 * @param listener: listener object to be added
	 */
	public void addListener(ClockListener listener) {
		listenerList.add(ClockListener.class, listener);
	}
	/**
	 * Unsubscribes a listener
	 * 
	 * @param listener: listener object to be removed
	 */
	public void removeListener(ClockListener listener) {
		listenerList.remove(ClockListener.class, listener);
	}
	/**
	 * Notifies listeners that one second has elapsed
	 * 
	 * @param event 
	 */
	@Override
	public void update(Observable clock, Object object) {
		ClockListener[] listeners = listenerList.getListeners(ClockListener.class);
		for (int i = 0; i < listeners.length; i++) {
			listeners[i].onClockTick();
		}	
	}
}

