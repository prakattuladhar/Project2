package context;

import io.reactivex.subjects.BehaviorSubject;

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
		subjectLight = BehaviorSubject.create();
        subjectTemperature = BehaviorSubject.create();
		
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
