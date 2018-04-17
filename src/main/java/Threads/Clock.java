package Threads;

import context.FreezerContext;
import context.RefridgeratorContext;
import context.RoomContext;
import io.reactivex.subjects.BehaviorSubject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Clock extends Object {
    private RefridgeratorContext fridgeContext=RefridgeratorContext.instance();
    private BehaviorSubject<Integer> clock;
    private int rateLoss;

    public Clock() {
        clock=BehaviorSubject.create();
        clock.onNext(0);
        rateLoss=5;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                updateClock();
            }
        };
        Thread t=new Thread(r);
        t.start();
    }

    public BehaviorSubject getClockEvent(){
        return clock;
    }
    public void updateClock() {
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
