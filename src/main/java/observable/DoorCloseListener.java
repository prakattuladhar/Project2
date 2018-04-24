package observable;

import java.util.EventListener;
/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * Implementing classes can register with DoorCloseListenerList
 * to receive DoorCloseEvents
 *
 */
public interface DoorCloseListener extends EventListener {
	public void onDoorClose(DoorCloseEvent event);
}
