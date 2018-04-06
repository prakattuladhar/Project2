package State;

import io.reactivex.subjects.BehaviorSubject;

public class FridgeState extends RefrigiratorState{
    private static FridgeState ourInstance = new FridgeState();

    public static FridgeState getInstance() {
        return ourInstance;
    }

    private FridgeState(){
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
