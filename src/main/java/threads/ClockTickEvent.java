package threads;

import java.util.EventObject;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This event is sent out this event each second
 *
 */
public class ClockTickEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	public ClockTickEvent(Object source) {
		super(source);
	}
}
