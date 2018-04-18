package state;

import context.AbstractRefridgeratorContext;
import context.Common;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 */
public abstract class AbstractRefridgeratorState {
	protected AbstractRefridgeratorContext context;
	protected int rate;
	public AbstractRefridgeratorState(AbstractRefridgeratorContext context, int rate) {
		this.context=context;
		this.rate=rate;
	}
	protected int rateLoss;//in 30 secs or 2
	
	/**
	 * Initialize and add subscriptions to observables
	 */
	public abstract void run();
	/**
	 * Remove subscriptions to observables
	 */
	public abstract void leave();
	/**
	 * What happens when it reaches desired Temperature
	 */
	public abstract void tempReached();
	/**
	 * What happens on each ClockTick Event
	 */
	public void clockTick() {
		tempChange();
	}
	/**
	 * Changing the temperatures
	 */
	private void tempChange() {
		context.setTemperature(context.getSubjectTemperature().getValue() + rate);
		if(context.getSubjectTemperature().getValue() > Common.getRoomTemp()) {
			context.setTemperature(Common.getRoomTemp());
		}
		tempReached();
	}
	
}
