package state;

import context.AbstractRefridgeratorContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 */
public abstract class AbstractRefridgeratorState {
	protected AbstractRefridgeratorContext context;
	protected int rate, diff;
	public AbstractRefridgeratorState(AbstractRefridgeratorContext context, int rate, int diff) {
		this.context=context;
		this.rate=rate;
		this.diff=diff;
	}
	protected int rateLoss;//in 30 secs or 2

    public AbstractRefridgeratorState() {

    }

	/**
	 * Initialize and add subscriptions to observables
	 */
	public abstract void run();
	/**
	 * Remove subscriptions to observables
	 */
	public abstract void leave();
	public void clockTick() {
		tempChange();
	}
	private void tempChange() {
		
	}
}
