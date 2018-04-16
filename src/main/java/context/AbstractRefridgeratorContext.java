package context;

import io.reactivex.subjects.BehaviorSubject;
import state.AbstractRefridgeratorState;

/**
 * 
 * @author Colin Quinn
 * @version 0.1
 *
 */
public abstract class AbstractRefridgeratorContext {
	
	protected AbstractRefridgeratorState currentState;
	
	protected int temperature;
    protected boolean light;

    protected BehaviorSubject<Boolean> subjectLight; //this is the observable
    protected BehaviorSubject<Integer> subjectTemperature; //this is the observable
    
    /**
	 * Called from the states to change the current state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentState(AbstractRefridgeratorState nextState) {
		currentState.leave();
		currentState = nextState;
		nextState.run();
	}
	
	/**
	 * 
	 * @param light
	 */
	public void setLight(boolean light) {
		this.light = light;
		subjectLight.onNext(light);
	}
	/**
	 * 
	 * @return
	 */
    public BehaviorSubject<Boolean> getSubjectLight() {;
    	return subjectLight;
    }
    /**
     * 
     * @param temperature
     */
    public void setTemperature(int temperature) {
    	this.temperature = temperature;
    	subjectTemperature.onNext(temperature);
    };
    /**
     * 
     * @return
     */
    public BehaviorSubject<Integer> getSubjectTemperature() {
    	return subjectTemperature;
    };
    
}
