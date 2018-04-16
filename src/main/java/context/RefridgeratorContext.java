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
		this.setLight(false);
		setTemperature(RoomContext.getInstance().getRoomTemparature());
		
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
