import java.io.Serializable;

public class qualifications implements Serializable{
    protected String Username;
    private String Password;

    public qualifications() {
    }

    public qualifications(String username, String password) {
        Username = username;
        Password = password;
    }
   
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "\nUsername=" + Username + ",\n Password=" + Password ;
    }
    
    

    
}
