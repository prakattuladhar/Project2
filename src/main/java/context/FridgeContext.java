package context;

import state.RefridgeratorDoorClosedState;

/**
 * 
 * @author Colin Quinn
 * @versio 1.0
 * 
 * This class holds the model for a freezer.  It can take on
 * different states which are responsible for changing variables in the context.
 * A GUI can subscribe to BehaviorSubject type variables in the context to be
 * notified when they change.
 *
 */
public class FridgeContext extends AbstractRefridgeratorContext {

    private static FridgeContext instance;
	/**
	 * Supports Singleton pattern and sets initial values from config file
	 */
    private FridgeContext() {
		instance = this;
		initialize(
			RefridgeratorDoorClosedState.instance(),
			Common.getFridgeHigh(),
			Common.getFridgeHigh(),
			Common.getFridgeLow(),
			Common.getFridgeRateLossDoorClosed(),
			Common.getFridgeRateLossDoorOpen(),
			Common.getFridgeCoolRate(),
			Common.getFridgeCompressorStartDiff()
		);
	}
	/**
	 * Gets only instance of this object
	 * 
	 * @return only instance of FridgeContext
	 */
	public static FridgeContext instance() {
		if (instance == null) {
			instance = new FridgeContext();
		}
		return instance;
	}

}
