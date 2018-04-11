package Context;

public class RoomContext {
    private static RoomContext ourInstance = new RoomContext();


    private int roomTemp;
    public static RoomContext getInstance() {
        return ourInstance;
    }

    private RoomContext() {
        roomTemp=65;
    }

    public int getRoomTemp() {
        return roomTemp;
    }

    public void setRoomTemp(int roomTemp) {
        this.roomTemp = roomTemp;
    }

}
