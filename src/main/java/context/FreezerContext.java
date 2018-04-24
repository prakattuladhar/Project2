package context;

import state.FreezerDoorClosedState;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class FreezerContext extends AbstractRefridgeratorContext {

	private static FreezerContext instance;
	/**
	 * Supports Singleton pattern
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
	 * 
	 * @return
	 */
	public static FreezerContext instance() {
		if (instance == null) {
			instance = new FreezerContext();
		}
		return instance;
	}
	
}
