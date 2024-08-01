
public class Staff extends Person  {
    private double pay;
    private String rank;
    
    public Staff() {
        super();
        }
    
    public Staff(String name, String address, long phonenumber, long id, double pay, String rank) {
        super(name, address, phonenumber, id);
        this.pay = pay;
        this.rank = rank;
    }
    public double getPay() {
        return pay;
    }
    public void setPay(double pay) {
        this.pay = pay;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "\nname:" + name + "\naddress:" + address + "\nphonenumber:" + phonenumber + "\nid:" + id  +"\npay:" + pay + "\nrank: " + rank ;
    }

}
