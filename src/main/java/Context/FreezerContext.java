package Context;

import io.reactivex.subjects.BehaviorSubject;

public class FreezerContext extends RefrigiratorContext {
    private static FreezerContext ourInstance = new FreezerContext();

    public static FreezerContext getInstance() {
        return ourInstance;
    }

    private FreezerContext() {
        light=false;
        temparature= RoomContext.getInstance().getRoomTemp();

    }


    @Override
    public void setLight(boolean light) {
        this.light=light;
    }

    @Override
    public BehaviorSubject<Boolean> getSubjectLight() {
        return null;
    }


    @Override
    public void setTemparature(int temp) {
            temparature=temp;
    }

    @Override
    public BehaviorSubject<Integer> getSubjectTemparature() {
        return null;
    }


}
