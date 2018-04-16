package context;

public class RoomContext {

    private int roomTemparature;
    private static RoomContext ourInstance = new RoomContext();

    public static RoomContext getInstance() {
        return ourInstance;
    }

    private RoomContext() {
        roomTemparature=70;
    }

    public int getRoomTemparature(){
        return roomTemparature;
    }
}
