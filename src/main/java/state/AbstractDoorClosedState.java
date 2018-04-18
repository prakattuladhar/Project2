package State;

import context.AbstractRefridgeratorContext;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public abstract class AbstractDoorClosedState extends state.AbstractRefridgeratorState {

	public AbstractDoorClosedState(AbstractRefridgeratorContext context, int rate, int diff) {
		super(context, rate, diff);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
