package threads;

import java.util.EventObject;

/**
 * 
 * @author Colin Quinn
 *
 */
public class ClockTickEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	public ClockTickEvent(Object source) {
		super(source);
	}
}
