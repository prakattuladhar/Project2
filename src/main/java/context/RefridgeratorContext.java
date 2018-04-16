package context;

import io.reactivex.subjects.BehaviorSubject;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public class RefridgeratorContext extends AbstractRefridgeratorContext {

	private static RefridgeratorContext instance;
	/**
	 * Supports Singleton pattern
	 */
	private RefridgeratorContext() {
		instance = this;
		subjectLight = BehaviorSubject.create();
        subjectTemperature = BehaviorSubject.create();
		
	}
	/**
	 * 
	 * @return
	 */
	public static RefridgeratorContext instance() {
		if (instance == null) {
			instance = new RefridgeratorContext();
		}
		return instance;
	}
	
	
}
