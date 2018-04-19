package threads;

import java.util.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class Clock extends Observable implements Runnable{
    private static Clock instance;
    private BehaviorSubject<Integer> clock;
    
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
        clock=BehaviorSubject.create();
        clock.onNext(0);
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                updateClock();
//            }
//        };
//        Thread t=new Thread(r);
//        t.start();
    }

    public BehaviorSubject getClockEvent(){
        return clock;
    }
    private void updateClock() {

        while (true) {
            System.out.println(clock.getValue());
            clock.onNext(clock.getValue() + 1);


//            if(clock.getValue()%rateLoss==0){
//               try {
//                   if(fridgeContext.getSubjectTemperature().getValue()<RoomContext.getInstance().getRoomTemparature()) {
//                       System.out.println("Temparature raised");
//                       fridgeContext.setTemperature(fridgeContext.getSubjectTemperature().getValue() + 1);
//                       System.out.println(fridgeContext.getSubjectTemperature().getValue());
//                   }
//               }catch (Exception e){
//                   System.out.print(e.fillInStackTrace());
//               }
//            }
            try {
                Thread.sleep(1000);
                setChanged();
				notifyObservers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        clock=BehaviorSubject.create();
        clock.onNext(0);
        updateClock();
    }
}
