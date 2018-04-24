package observable;

import java.util.EventListener;
/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * Implementing classes can register with DoorOpenListenerList
 * to receive DoorOpenEvents
 *
 */
public interface DoorOpenListener extends EventListener {
	public void onDoorOpen(DoorOpenEvent event);
}
