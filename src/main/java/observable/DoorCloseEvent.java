package observable;

import java.util.EventObject;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class DoorCloseEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	public DoorCloseEvent(Object source) {
		super(source);
	}
}
