package State;

import io.reactivex.Observable;

public class FridgeState extends RefrigiratorState{
    private static FridgeState ourInstance = new FridgeState();

    public static FridgeState getInstance() {
        return ourInstance;
    }


    private FridgeState() {
            light=false;
            temparature=RoomState.getInstance().getRoomTemp();
    }

    @Override
    public void setLight(boolean light) {
        this.light=light;
    }

    @Override
    public boolean getLight() {
        return light;
    }

    @Override
    public void setTemparature(int temp) {
        temparature=temp;
    }

    @Override
    public int getTemparature() {
        return temparature;
    }
}
