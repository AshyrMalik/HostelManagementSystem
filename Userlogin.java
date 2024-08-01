import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Userlogin extends JFrame implements ActionListener {
    
    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;
    private JLabel username,password,sign;
    private JTextField tfusername;
    private JPasswordField  tfpassword;
    JButton back,login,signup;
    public Userlogin(){

        setSize(WIDTH, HEIGHT);
        setTitle("User Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        username = new JLabel("Username");
        username.setBounds(30, 50, 70, 30);
        password = new JLabel("Password");
        password.setBounds(30, 90, 70, 30);
        sign=new JLabel("New user? SignUp ");
        sign.setBounds(80,190,150,30);
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
        signup=new JButton("Signup");
        signup.setBounds(80,230,90,20);
        signup.setBackground(Color.LIGHT_GRAY);
        
        back.addActionListener(this);
        login.addActionListener(this);
        signup.addActionListener(this);
        
        add(username);add(password);add(sign);add(tfusername); add(tfpassword);
        add(login);add(back);add(signup);
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

            StudentActivites str=new StudentActivites();
            if(str.checkPassword(Username, Password)){
                dispose();
                new StudentProfile(Username);
                
            }   
            else{
                tfusername.setText("");
                tfpassword.setText("");
                
            }
            


        }
        else if(e.getSource()==signup){
            dispose();
            new Signup();
        }
        
    
    }
   



}
