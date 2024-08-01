import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class adminLogin extends JFrame implements ActionListener{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 290;
    private JLabel username,password;
    private JTextField tfusername;
    private JPasswordField  tfpassword;
    JButton back,login;
    public adminLogin(){
        setSize(WIDTH, HEIGHT);
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        username = new JLabel("Username");
        username.setBounds(30, 50, 70, 30);
        password = new JLabel("Password");
        password.setBounds(30, 90, 70, 30);

        tfusername = new JTextField();
        tfusername.setBounds(120, 50, 90, 30);
		tfpassword= new JPasswordField();
        tfpassword.setBounds(120, 90, 90, 30);

        back=new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.setBounds(30, 140, 80, 30);
        login=new JButton("Login");
        login.setBounds(130, 140, 80, 30);
        login.setBackground(Color.LIGHT_GRAY);
        
        back.addActionListener(this);
        login.addActionListener(this);
       
        
        add(username);add(password);add(tfusername); add(tfpassword);
        add(login);add(back);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back) {
            dispose();
            new Startup();
            
        }
        else if (e.getSource()== login){
            String Username= tfusername.getText();
            String Password= tfpassword.getText();


            adminoperations ao=new adminoperations();
            qualifications admin=ao.getAdmin();

            if(admin.getUsername().equals(Username)&&admin.getPassword().equals(Password)){
                dispose();
                new Admin();

                
            }   
            else{
                System.out.print("Invalid Username or Password");
                tfusername.setText("");
                tfpassword.setText("");
                
                }
        }
    }
}