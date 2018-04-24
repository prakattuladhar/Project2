package context;

import state.RefridgeratorDoorClosedState;

public class FridgeContext extends AbstractRefridgeratorContext {

    private static FridgeContext instance;
	/**
	 * Supports Singleton pattern
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
	 * 
	 * @return
	 */
	public static FridgeContext instance() {
		if (instance == null) {
			instance = new FridgeContext();
		}
		return instance;
	}

}
