package context;

import io.reactivex.subjects.BehaviorSubject;

public class FridgeContext extends AbstractRefridgeratorContext {
    private static FridgeContext ourInstance = new FridgeContext();

    public static FridgeContext getInstance() {
        return ourInstance;
    }

    private FridgeContext(){


    }

}
