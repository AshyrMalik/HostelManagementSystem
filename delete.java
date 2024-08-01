import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class delete extends JFrame  {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 230;
    protected JLabel username;
    protected JTextField tfusername;
    protected JButton backButton, submitButton;

    public delete() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

       
        username = new JLabel("");
        tfusername = new JTextField();
        backButton = new JButton("Back");
        backButton.setBackground(Color.LIGHT_GRAY);
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.LIGHT_GRAY);
       
        
        username.setBounds(30, 50, 70, 30);
        tfusername.setBounds(120, 50,110, 30);
        backButton.setBounds(30, 110, 80, 30);
        submitButton.setBounds(130, 110, 80, 30);

        

        
        add(username);
        add(tfusername);
        add(backButton);
        add(submitButton);

        }


    

    
}
