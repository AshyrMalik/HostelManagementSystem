
public class Student extends Person {


    boolean mess,laundry,inverter;
    Rooms rooms =new Rooms();
    Feedback feedback =new Feedback();

   
    public Student() {
        super();
    }
    
    public Student(String name, String address, long phonenumber, long id, boolean mess, boolean laundry,
            boolean inverter, Rooms rooms) {
        super(name, address, phonenumber, id);
        this.mess = mess;
        this.laundry = laundry;
        this.inverter = inverter;
        this.rooms = rooms;
      
    }
    
    public Student(String username, String password, String name, String address, long phonenumber, long id,
            boolean mess, boolean laundry, boolean inverter, Rooms rooms) {
        super(username, password, name, address, phonenumber, id);
        this.mess = mess;
        this.laundry = laundry;
        this.inverter = inverter;
        this.rooms = rooms;
    }

    public boolean isMess() {
        return mess;
    }

    public void setMess(boolean mess) {
        this.mess = mess;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public boolean isInverter() {
        return inverter;
    }

    public void setInverter(boolean inverter) {
        this.inverter = inverter;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "\nname: " + name + ",\naddress: " + address + ",\nphonenumber: " + phonenumber + ",\nid:" + id +"\nmess: " + mess + ",\nlaundry: " + laundry + "\ninverter: " + inverter +  rooms.toString() +"\nUsername: " + Username  ;
    }
    

}
    
    




