package context;

import io.reactivex.subjects.BehaviorSubject;

public abstract class RefrigiratorContext {
    protected int temparature;
    protected boolean light;

    protected BehaviorSubject<Boolean> subjectLight;//this is the observable
    protected BehaviorSubject<Integer> subjectTemparature;//this is the observable

    public abstract void setLight(boolean light);
    public abstract BehaviorSubject<Boolean> getSubjectLight();

    public abstract void setTemparature(int temp);
    public abstract BehaviorSubject<Integer> getSubjectTemparature();



}
