package state;

import context.AbstractRefridgeratorContext;
import context.Common;
import threads.*;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 */
public abstract class AbstractRefridgeratorState implements ClockListener {
	protected AbstractRefridgeratorContext context;
	protected int counter;
	
	/**
	 * 
	 * @param context
	 * @param rate
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
