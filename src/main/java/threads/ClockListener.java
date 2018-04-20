package threads;

import java.util.EventListener;

/**
 * 
 * @author Colin Quinn
 *
 */
public interface ClockListener extends EventListener {
	public void onClockTick();
}
