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
	


    protected BehaviorSubject<Boolean> subjectLight= BehaviorSubject.create(); //this is the observable
    protected BehaviorSubject<Integer> subjectTemperature=BehaviorSubject.create(); //this is the observable
	protected BehaviorSubject<Integer> subjectDesiredTemperature=BehaviorSubject.create(); //this is the observable
    
    /**
	 * Called from the states to change the current state
	 * 
	 * @param nextState
	 *            the next state
	 */
	public void changeCurrentState(AbstractRefridgeratorState nextState) {
		currentState.leave();
		currentState = nextState;
//		subjectLight = BehaviorSubject.create();
//		subjectTemperature = BehaviorSubject.create();
		setLight(false);
		setTemperature(RoomContext.getInstance().getRoomTemparature());
		nextState.run();
	}
	
	/**
	 * 
	 * @param light:boolean
	 */
	public void setLight(boolean light) {
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
     * @param temperature:int
     */
    public void setTemperature(int temperature) {
    	subjectTemperature.onNext(temperature);
    };
    /**
     * 
     * @return
     */
    public BehaviorSubject<Integer> getSubjectTemperature() {
    	return subjectTemperature;
    };

    public void setSubjectDesiredTemperature(int temperature){
    	subjectDesiredTemperature.onNext(temperature);
	}

	public BehaviorSubject<Integer> getDesiredTemparature(){
    	return subjectDesiredTemperature;
	}
    
}
