package state;

import context.AbstractRefridgeratorContext;
import threads.*;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * Represents the internal state of a refidgeration unit.
 */
public abstract class AbstractRefridgeratorState implements ClockListener {
	protected AbstractRefridgeratorContext context;
	protected int counter;
	
	/**
	 * Allows an instantiated subclass to be passed the right context
	 * 
	 * @param context: the context the state will operate on
	 */
	public void initialize(AbstractRefridgeratorContext context) {
		this.context = context;
		counter = 0;
	}

	/**
	 * Initialize and add subscriptions to observables
	 */
	public abstract void run();
	
	/**
	 * Remove subscriptions to observables
	 */
	public abstract void leave();
	
	/**
	 * What happens on each ClockTick Event
	 */
	public abstract void onClockTick();
	
}
