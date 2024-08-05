// 1. Write a program to create a Room class, the attributes of this class is room no, room type, and
// room area. Implement the methods called setData and displayData to manipulate the data

package WS05;

public class WS05_PS01 {
    public static void main(String[] args) {
        Room room = new Room(1, Room.RoomType.EXECUTIVE, 500.75F);
        System.out.println("Details: " + room);

        room.setData(1, Room.RoomType.PRESIDENTIAL, 600.75F);
        System.out.println(room.displayData());

        return;
    }
}

class Room {

    enum RoomType {
        EXECUTIVE,
        PRESIDENTIAL,
        SUITE,
        DELUXE,
        SINGLE,
        DOUBLE
    }

    private int roomNo;
    private RoomType roomType;
    private float roomArea;

    public Room(int roomNo, RoomType roomType, float roomArea) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomArea = roomArea;
    }

    public Room(int roomNo, RoomType roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public float getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(float roomArea) {
        this.roomArea = roomArea;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", roomType=" + roomType +
                ", roomArea=" + roomArea +
                '}';
    }

    public void setData(int roomNo, RoomType roomType, float roomArea) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomArea = roomArea;
    }

    public String displayData() {
        return "Room {" +
                "roomNo=" + roomNo +
                ", roomType=" + roomType +
                ", roomArea=" + roomArea +
                '}';
    }
}








