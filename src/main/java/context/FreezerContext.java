package context;

import state.FreezerDoorClosedState;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class holds the model for a freezer.  It can take on
 * different states which are responsible for changing variables in the context.
 * A GUI can subscribe to BehaviorSubject type variables in the context to be
 * notified when they change.
 *
 */
public class FreezerContext extends AbstractRefridgeratorContext {

	private static FreezerContext instance;
	/**
	 * Supports Singleton pattern and sets initial values from config file
	 */
	private FreezerContext() {
		instance = this;
		initialize(
			FreezerDoorClosedState.instance(),
			Common.getFreezerHigh(),
			Common.getFreezerHigh(),
			Common.getFreezerLow(),
			Common.getFreezerRateLossDoorClosed(),
			Common.getFreezerRateLossDoorOpen(),
			Common.getFreezerCoolRate(),
			Common.getFreezerCompressorStartDiff()
		);
	}
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FreezerContext
	 */
	public static FreezerContext instance() {
		if (instance == null) {
			instance = new FreezerContext();
		}
		return instance;
	}
	
}
