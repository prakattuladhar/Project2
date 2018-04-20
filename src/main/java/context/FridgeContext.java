package context;

import io.reactivex.subjects.BehaviorSubject;

public class FridgeContext extends AbstractRefridgeratorContext {

    private static FridgeContext instance;
	/**
	 * Supports Singleton pattern
	 */
	private FridgeContext() {
		instance = this;    
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
