package State;

public abstract class RefrigiratorState {
    protected int temparature;
    protected boolean light;

    public abstract void setLight(boolean light);
    public abstract boolean getLight();

    public abstract void setTemparature(int temp);
    public abstract int getTemparature();



}
