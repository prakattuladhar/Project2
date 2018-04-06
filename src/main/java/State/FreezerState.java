package State;

import io.reactivex.subjects.BehaviorSubject;

public class FreezerState extends RefrigiratorState{
    private static FreezerState ourInstance = new FreezerState();

    public static FreezerState getInstance() {
        return ourInstance;
    }

    private FreezerState() {
        light=false;
        temparature=RoomState.getInstance().getRoomTemp();

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
