package state;

import Threads.Clock;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class StateManager {


    private String currentState_fridge;
    private String currentState_freezer;
    private int fridgeRateLoss;
    private int freezerRateLoss;


    private static StateManager ourInstance = new StateManager();

    public static StateManager getInstance() {
        return ourInstance;
    }

    private StateManager() {

    }

    private void initObersers(){
        Observer<? super Integer> observerClock = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }
            @Override
            public void onNext(Integer integer) {
                //if fridge state= cooling
                //if freezer state cooling
            }

            @Override
            public void onError(Throwable throwable) {

            }
            @Override
            public void onComplete() {

            }
        };
        Clock.getInstance().getClockEvent().subscribe(observerClock);
    }
}
