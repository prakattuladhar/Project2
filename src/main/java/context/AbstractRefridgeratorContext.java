package context;

import io.reactivex.subjects.BehaviorSubject;
import state.AbstractRefridgeratorState;

import java.util.function.BooleanSupplier;

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
	protected BehaviorSubject<Boolean> subjectIsCooling=BehaviorSubject.create();
    
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
    public void setIsCooling(Boolean b){
    	subjectIsCooling.onNext(b);
	}
	public BehaviorSubject<Boolean> getIsCooling(){
		return subjectIsCooling;
	}
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
