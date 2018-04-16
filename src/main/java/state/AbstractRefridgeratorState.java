package state;

import context.AbstractRefridgeratorContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 */
public abstract class AbstractRefridgeratorState {
	
	protected AbstractRefridgeratorContext context;
	protected int rateLoss;//in 30 secs or 2
	
	/**
	 * Initialize and add subscriptions to observables
	 */
	public abstract void run();
	/**
	 * Remove subscriptions to observables
	 */
	public void leave() {
		// To be implemented
		return;
	}
}
