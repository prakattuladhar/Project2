package State;

public class RoomState {
    private static RoomState ourInstance = new RoomState();


    private int roomTemp;
    public static RoomState getInstance() {
        return ourInstance;
    }

    private RoomState() {
        roomTemp=65;
    }

    public int getRoomTemp() {
        return roomTemp;
    }

    public void setRoomTemp(int roomTemp) {
        this.roomTemp = roomTemp;
    }

}
