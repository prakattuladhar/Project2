package threads;

import java.util.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * 
 * @author Colin Quinn
 * @version 1.0
 * 
 * 
 *
 */
public class Clock extends Observable implements Runnable{
    private static Clock instance;
    private Thread thread = new Thread(this);
    
    public enum Events {
		CLOCK_TICKED_EVENT
	}
    /**
     * Gets only instance of Clock
     * 
     * @return only instance of Clock
     */
    public static Clock instance() {
		if (instance == null) {
			instance = new Clock();
		}
		return instance;
	}
    /**
     * Supports singleton pattern/starts separate thread for clock
     */
    private Clock() {
       thread.start();
    }

    @Override
    public void run() {
    	// Notifies ClockTickListener list to send out event every second
    	while (true) {
    		try {
                Thread.sleep(1000);
                setChanged();
    			notifyObservers();
    			// DEBUG
    			// System.out.println("tick");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    }
}
