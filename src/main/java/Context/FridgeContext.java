package Context;

import io.reactivex.subjects.BehaviorSubject;

public class FridgeContext extends RefrigiratorContext {
    private static FridgeContext ourInstance = new FridgeContext();

    public static FridgeContext getInstance() {
        return ourInstance;
    }

    private FridgeContext(){
        light=false;
        subjectLight=BehaviorSubject.create();
        subjectTemparature=BehaviorSubject.create();

    }

    @Override
    public void setLight(boolean light) {
        this.light=light;
        subjectLight.onNext(this.light);
    }

    @Override
    public BehaviorSubject<Boolean> getSubjectLight(){
        return subjectLight;
    }

    @Override
    public BehaviorSubject<Integer> getSubjectTemparature(){
        return subjectTemparature;
    }

    @Override
    public void setTemparature(int temp) {
        temparature=temp;
        subjectTemparature.onNext(temp);
    }


}
