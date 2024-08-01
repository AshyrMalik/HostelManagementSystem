import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class Updateprofile extends JFrame implements ActionListener {
    public static final int WIDTH = 380;
    public static final int HEIGHT =450;
    private JLabel name,address,Phone,id,UserName,password;
    private JTextField tfname,tfaddress,tfPhone,tfid,tfUserName,tfpassword;
    private JButton nameButton,addressButton,PhoneButton,idButton,UserNameButton,passwordButton,Back;
    private String CurrUserName;

    public Updateprofile(String a){
        CurrUserName=a;
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Update Profile");

        name = new JLabel("Name:");
		address= new JLabel("Address:");
		Phone= new JLabel("Phone:");
        id = new JLabel("ID:");
		UserName= new JLabel("Username:");
		password= new JLabel("Password:");
		name.setBounds(50,40,80,30);
		address.setBounds(50,80,80,30);
		Phone.setBounds(50,120,80,30);
        id.setBounds(50,160,80,30);
		UserName.setBounds(50,200,80,30);
		password.setBounds(50,240,80,30);

        add(name);add(address);add(Phone);add(UserName);add(password);add(id);

        tfname = new JTextField();
		tfaddress = new JTextField();
		tfPhone= new JTextField();
        tfid= new JTextField();
		tfUserName = new JTextField();
		tfpassword = new JTextField();
		tfname.setBounds(120,40,100,30);
		tfaddress.setBounds(120,80,100,30);
		tfPhone.setBounds(120,120,100,30);
        tfid.setBounds(120,160,100,30);
		tfUserName.setBounds(120,200,100,30);
		tfpassword.setBounds(120,240,100,30);

        add(tfname);add(tfaddress);add(tfPhone);add(tfUserName);add(tfpassword);add(tfid);

        nameButton = new JButton("Enter");
        nameButton.setBackground(Color.LIGHT_GRAY);
        nameButton.addActionListener(this);
        addressButton = new JButton("Enter");
        addressButton.setBackground(Color.LIGHT_GRAY);
        addressButton.addActionListener(this);
        PhoneButton = new JButton("Enter");
        PhoneButton.setBackground(Color.LIGHT_GRAY);
        PhoneButton.addActionListener(this);
        idButton = new JButton("Enter");
        idButton.setBackground(Color.LIGHT_GRAY);
        idButton.addActionListener(this);
        UserNameButton = new JButton("Enter");
        UserNameButton.setBackground(Color.LIGHT_GRAY);
        UserNameButton.addActionListener(this);
        passwordButton = new JButton("Enter");
        passwordButton.setBackground(Color.LIGHT_GRAY);
        passwordButton.addActionListener(this);
        Back=new JButton("Back");
        Back.setBackground(Color.LIGHT_GRAY);
        Back.addActionListener(this);
        
        nameButton.setBounds(240,40,80,30);
		addressButton.setBounds(240,80,80,30);
		PhoneButton.setBounds(240,120,80,30);
        idButton.setBounds(240,160,80,30);
		UserNameButton.setBounds(240,200,80,30);
		passwordButton.setBounds(240,240,80,30);
        Back.setBounds(50,320,80,30);


        add(nameButton);add(addressButton);add(PhoneButton);add(idButton);add(UserNameButton);add(passwordButton);
        add(Back);
        
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
     adminoperations ao=new adminoperations();

    if (e.getSource() == nameButton) {
        String name = tfname.getText();
        ao.nameupdateS(CurrUserName, name);

       
    } else if (e.getSource() == addressButton) {
        String address = tfaddress.getText();
        ao.AddressupdateS(CurrUserName, address);

    } else if (e.getSource() == PhoneButton) {
        long phone = Long.parseLong(tfPhone.getText());
        ao.phonenoupdateS(CurrUserName, phone);

    } else if (e.getSource() == idButton) {
        long id = Long.parseLong(tfid.getText());
        ao.idupdateS(CurrUserName, id);
        
          
    } else if (e.getSource() == UserNameButton) {
        String username = tfUserName.getText();
        if(ao.UsernameCheck(username)){
            ao.usernameupdateS(CurrUserName, username);
            CurrUserName=username;
        }
        else{
            JOptionPane.showMessageDialog(null,"Select any other Username");
            tfUserName.setText("");
            
                    
        }
        

    } else if (e.getSource() == passwordButton) {
        String password = tfpassword.getText();
        ao.passwordupdateS(CurrUserName, password);    
    } else if (e.getSource() == Back) {
       dispose();
       new StudentProfile(CurrUserName);
    }
}
    
}
