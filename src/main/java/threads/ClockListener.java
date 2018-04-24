package threads;

import java.util.EventListener;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * Implementing classes can register with ClockListenerList
 * to receive ClockTickEvents
 *
 */
public interface ClockListener extends EventListener {
	public void onClockTick();
}
