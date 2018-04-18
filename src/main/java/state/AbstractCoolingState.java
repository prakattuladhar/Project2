package State;

import context.AbstractRefridgeratorContext;

public abstract class AbstractCoolingState extends state.AbstractRefridgeratorState {

	public AbstractCoolingState(AbstractRefridgeratorContext context, int rate, int diff) {
		super(context, rate, diff);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
