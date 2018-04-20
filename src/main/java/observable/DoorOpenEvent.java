package observable;

import java.util.EventObject;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class DoorOpenEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	public DoorOpenEvent(Object source) {
		super(source);
	}
}
