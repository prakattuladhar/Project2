package State;

import context.RefridgeratorContext;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class StateManager {

    private RefridgeratorContext fridgeContext;
    private static StateManager ourInstance = new StateManager();

    public static StateManager getInstance() {
        return ourInstance;
    }

    private StateManager() {
    }

    private void initObersers(){
        Observer<? super Integer> observerFridgeDesiredTemparature = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }
            @Override
            public void onNext(Integer integer) {
                //here
            }

            @Override
            public void onError(Throwable throwable) {

            }
            @Override
            public void onComplete() {

            }
        };
        fridgeContext.getDesiredTemparature().subscribe(observerFridgeDesiredTemparature);
    }
}
