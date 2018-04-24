package observable;

import java.util.EventObject;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * Event for door opening
 *
 */
public class DoorOpenEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	public DoorOpenEvent(Object source) {
		super(source);
	}
}
