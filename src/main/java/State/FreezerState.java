package State;

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
