import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startup extends JFrame implements ActionListener  {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    private JButton userButton,adminButton;

    public Startup() {
        setSize(WIDTH, HEIGHT);
        setTitle("MALIK HOSTEL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel Title=new JLabel("MALIK HOSTEL MANAGEMENT SYSTEM");
        Title.setBounds(70,30,250,20);
        userButton = new JButton("User");
        userButton.setBounds(120,100,120,60);
        userButton.setBackground(Color.LIGHT_GRAY);
        adminButton = new JButton("Admin");
        adminButton.setBounds(120,195,120,60);
        adminButton.setBackground(Color.LIGHT_GRAY);
        add(Title);
        add(userButton);
        add(adminButton);

        userButton.addActionListener(this);
        adminButton.addActionListener(this);
        setVisible(true);


    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==adminButton) {
            dispose();
            new adminLogin();
            
        }
        else if (e.getSource()== userButton) {
            dispose();
            new Userlogin();
            
        }
       
    }
    

    



}

