import java.io.Serializable;

public class Rooms implements Serializable {
    
   
    private int RoomNO;
    private String Roomtype;
    private int NO_of_bed;
    private boolean availability;

    public Rooms(int roomNO, String roomtype, int nO_of_bed) {
        RoomNO = roomNO;
        Roomtype = roomtype;
        NO_of_bed = nO_of_bed;
        availability=true;
    }



    public Rooms() {
    }

    public int getRoomNO() {
        return RoomNO;
    }
    public void setRoomNO(int roomNO) {
        RoomNO = roomNO;
    }
    public String getRoomtype() {
        return Roomtype;
    }
    public void setRoomtype(String roomtype) {
        Roomtype = roomtype;
    }

    public int getNO_of_bed() {
        return NO_of_bed;
    }

    public void setNO_of_bed(int nO_of_bed) {
        NO_of_bed = nO_of_bed;
    }

        
    public boolean isAvailability() {
        return availability;
    }



    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    @Override
    public String toString() {
        
        return "\nRoomNo: "+RoomNO+"\nRoomType: "+Roomtype;

    }
    public String display() {
        
        return "\nRoomNo: "+RoomNO+"\nRoomType: "+Roomtype+"\nNumber of Beds: "+NO_of_bed+"\nAvailability: "+ availability;

    }
    
    


}
