package observable;

import java.util.EventListener;
/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public interface DoorCloseListener extends EventListener {
	public void onDoorClose(DoorCloseEvent event);
}
