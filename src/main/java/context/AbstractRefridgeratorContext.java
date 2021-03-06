package context;

import io.reactivex.subjects.BehaviorSubject;
import state.AbstractRefridgeratorState;

import java.util.function.BooleanSupplier;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * This class holds the model for a refridgeration unit.  It can take on
 * different states which are responsible for changing variables in the context.
 * A GUI can subscribe to BehaviorSubject type variables in the context to be
 * notified when they change.
 *
 */
public abstract class AbstractRefridgeratorContext {
	
	protected AbstractRefridgeratorState currentState;
	
	// Observable Values
    protected BehaviorSubject<Boolean> subjectLight;
    
    // Temperature values
    protected BehaviorSubject<Integer> subjectTemperature;
	protected BehaviorSubject<Integer> subjectDesiredTemperature;
	protected int subjectMaxTemperature;
	protected int subjectMinTemperature;
	
	// Temperature change rates
	protected int subjectRateDoorClosed;
	protected int subjectRateDoorOpen;
	protected int subjectCoolRate;
	
	// Compressor variables
	protected BehaviorSubject<Boolean> subjectIsCooling;
	protected int subjectStartDifferential;
	
	/**
	 * Sets initial values for the context
	 * Parameters are values that differ between fridge and freezer
	 * 
	 * @param state
	 * @param desiredTemperature
	 * @param maxTemperature
	 * @param minTemperature
	 * @param rateDoorClosed
	 * @param rateDoorOpen
	 * @param coolingRate
	 * @param startDifferential
	 */
	public void initialize(
			AbstractRefridgeratorState state,
			int desiredTemperature,
			int maxTemperature,
			int minTemperature,
			int rateDoorClosed,
			int rateDoorOpen,
			int coolingRate,
			int startDifferential
	) {
		this.currentState = state;
		
		subjectLight = BehaviorSubject.createDefault(false);
		
		subjectTemperature = BehaviorSubject.createDefault( Common.getRoomTemp() );
		subjectDesiredTemperature = BehaviorSubject.createDefault(desiredTemperature);
		subjectMaxTemperature = maxTemperature;
		subjectMinTemperature = minTemperature;
		
		subjectRateDoorClosed = rateDoorClosed;
		subjectRateDoorOpen = rateDoorOpen;
		subjectCoolRate = coolingRate;
		
		subjectIsCooling = BehaviorSubject.createDefault(false);
		subjectStartDifferential = startDifferential;
		
		currentState.run();
	}
	
    /**
	 * Called from the states to change the current state
	 * 
	 * @param nextState: the state that will be transitioned to
	 */
	public void changeCurrentState(AbstractRefridgeratorState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.run();
	}
	
	// Getters and Setters
	
	// LIGHT
	
	/**
	 * Change observable value of light
	 * 
	 * @param light: true for on, false for off
	 */
	public void setLight(boolean light) {
		subjectLight.onNext(light);
	}
	
	/**
	 * Gets observable light
	 * 
	 * @return: boolean observable
	 */
    public BehaviorSubject<Boolean> getSubjectLight() {;
    	return subjectLight;
    }
    
    // TEMPERATURE (Fahrenheit)
    
    /**
	 * Changes observable current temperature
	 * 
	 * @param temperature
	 */
    public void setTemperature(int temperature) {
    	subjectTemperature.onNext(temperature);
    }
    
    /**
     * Gets observable current temperature
     * 
     * @return: observable integer
     */
    public BehaviorSubject<Integer> getSubjectTemperature() {
    	return subjectTemperature;
    };
    
    /**
     * Sets observable desired temperature
     * 
     * @param: int temperature in fahrenheit
     */
    public void setSubjectDesiredTemperature(int temperature) {
    	subjectDesiredTemperature.onNext(temperature);
	}
    
    /**
     * Get observable desired temperature
     * 
     * @return: observable int (fahrenheit)
     */
	public BehaviorSubject<Integer> getDesiredTemperature() {
    	return subjectDesiredTemperature;
	}
	
	/**
	 * Get max temperature
	 * 
	 * @return
	 */
	public int getMaxTemperature() {
    	return subjectMaxTemperature;
	}
	
	/**
	 * Get min temperature
	 * 
	 * @return
	 */
	public int getMinTemperature() {
    	return subjectMinTemperature;
	}
	
	// RATES
	
	/**
	 * Get rate of temperature loss when door closed
	 * 
	 * @return rate of loss in seconds
	 */
	public int getDoorClosedLossRate() {
    	return subjectRateDoorClosed;
	}
	
	/**
	 * Get rate of temperature loss when door open
	 * 
	 * @return rate of loss in seconds
	 */
	public int getDoorOpenLossRate() {
    	return subjectRateDoorOpen;
	}
	
	/**
	 * Get rate at which compressor cools
	 * 
	 * @return rate of cooling in seconds
	 */
	public int getCompressorCoolingRate() {
    	return subjectCoolRate;
	}
	
	// COMPRESSOR
    
    /**
     * Change observable status of compressor
     * 
	 * @param: true for cooling, false for idle
     */
    public void setIsCooling(Boolean b) {
    	subjectIsCooling.onNext(b);
	}
    
    /**
     * Gets observable compressor status
     * 
     * @return: boolean observable
     */
	public BehaviorSubject<Boolean> getIsCooling() {
		return subjectIsCooling;
	}
	
	/**
	 * Get amount by which desired temperature must be exceeded to start
	 * compressor
	 * 
	 * @return differential in degrees
	 */
	public int getCompressorStartDifferential() {
		return subjectStartDifferential;
	}

}
