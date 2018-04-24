package threads;

import java.util.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class Clock extends Observable implements Runnable{
    private static Clock instance;
    private Thread thread = new Thread(this);
    
    public enum Events {
		CLOCK_TICKED_EVENT
	}

    public static Clock instance() {
		if (instance == null) {
			instance = new Clock();
		}
		return instance;
	}

    private Clock() {
       thread.start();
    }

    @Override
    public void run() {
    	
    	while (true) {
    		try {
                Thread.sleep(1000);
                setChanged();
    			notifyObservers();
    			//DEBUG
    			System.out.println("tick");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    	}
    }
}
