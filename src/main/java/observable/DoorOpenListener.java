package observable;

import java.util.EventListener;
/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public interface DoorOpenListener extends EventListener {
	public void onDoorOpen(DoorOpenEvent event);
}
