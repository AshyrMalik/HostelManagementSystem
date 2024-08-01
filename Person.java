
public class Person extends qualifications  {
   
    protected String name,address;
    protected long phonenumber,id;
    
    
    public Person() {

    }
    public Person(String name, String address, long phonenumber, long id) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.id = id;
    }
    
    public Person(String username, String password, String name, String address, long phonenumber, long id) {
        super(username, password);
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "\nname=" + name + ",\naddress=" + address + ",\nphonenumber=" + phonenumber + ",\nid=" + id ;
    }

}
