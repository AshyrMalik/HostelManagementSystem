
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 550;
    private JLabel username,password,name,address,phoneno,id,Seaters;
    protected JTextField tfusername,tfpassword,tfname,tfaddress,tfphoneno,tfid;
    protected JCheckBox messBox, laundryBox,inverterBox;
	protected JRadioButton Type1 , Type2, Type3;
    protected JButton back,Submit;
    protected ButtonGroup types;


    public Signup(){
        setSize(WIDTH, HEIGHT);
        setTitle("User Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        name=new JLabel("Name: ");
        
        address=new JLabel("Address: ");
        id=new JLabel("ID: ");
        phoneno=new JLabel("Phone : ");
        Seaters=new JLabel("RoomType: ");
        username=new JLabel("User name: ");
        password=new JLabel("Password: ");
      
        
        name.setBounds(50,40,100,30);
		address.setBounds(50,80,100,30);
		phoneno.setBounds(50,120,100,30);
		id.setBounds(50,160,100,30);
        Seaters.setBounds(50,200,100,30);
        username.setBounds(50,240,100,30);
		password.setBounds(50,280,100,30);
        
        add(name);add(address);add(phoneno);add(id);add(Seaters);add(username);add(password);
        
        tfname=new JTextField();
        tfaddress=new JTextField();
        tfid=new JTextField();
        tfphoneno=new JTextField();
        tfusername=new JTextField();
        tfpassword=new JTextField( );
        tfname.setBounds(150, 40, 100, 30);
        tfaddress.setBounds(150,80,100,30);
		tfphoneno.setBounds(150,120,100,30);
		tfid.setBounds(150,160,100,30);
        tfusername.setBounds(150,240,100,30);
		tfpassword.setBounds(150,280,100,30);
        add(tfname);add(tfaddress);add(tfphoneno);add(tfid);add(tfusername);add(tfpassword);

        types=new ButtonGroup();
        Type1 = new JRadioButton("1");
		Type2 = new JRadioButton("2");
		Type3 = new JRadioButton("3");
        Type1.setBounds(148,200,40,30);
		Type2.setBounds(187,200,40,30);
		Type3.setBounds(224,200,40,30);
        types.add(Type1);
        types.add(Type2);
        types.add(Type3);

        add(Type1);add(Type2);add(Type3);

        messBox = new JCheckBox("Mess");
		laundryBox = new JCheckBox("Laundry");
        inverterBox = new JCheckBox("Inverter");

        messBox.setBounds(50,320,100,30);
        laundryBox.setBounds(50,360,100,30);
        inverterBox.setBounds(50,400,100,30);
        add(messBox);add(laundryBox);add(inverterBox);



        back=new JButton("Back");
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        back.setBounds(50,450,70,30);
        Submit=new JButton("Submit");
        Submit.setBackground(Color.LIGHT_GRAY);
        Submit.addActionListener(this);
        Submit.setBounds(140,450,100,30);
        add(back);add(Submit);

        setVisible(true);       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==back){
            dispose();
            new Userlogin();
        }   
        
        if(e.getSource()==Submit){
            
            adminoperations aao=new adminoperations();
            if(tfusername.getText().equals("")||tfpassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
            else{
            String roomType;
			if (Type1.isSelected()) {
				roomType = "1 Seater";
			}
			else if (Type2.isSelected()) {
				roomType = "2 Seater";
			}
			else{
				roomType = "3 Seater";
			}
            adminoperations ao=new adminoperations();
            Rooms room= ao.bookroom(roomType);
            if(room!=null){

            
            long phoneNumber = Long.parseLong(tfphoneno.getText());
            long id= Long.parseLong(tfid.getText());
			Boolean mess = false;
			Boolean laundry = false;
            Boolean inverter = false;
            

            if (messBox.isSelected()) {
                mess = true;
            }
            if (laundryBox.isSelected()) {
                laundry= true;
            }
            if (inverterBox.isSelected()) {
                inverter = true;
            }

                
            if(aao.UsernameCheck(tfusername.getName())){
                Student stu=new Student(tfusername.getText(),tfpassword.getText(),tfname.getText(),tfaddress.getText(),phoneNumber,id,mess,laundry,inverter,room);
                aao.addStudent(stu);
                dispose();
                new Userlogin();
            
            }
            else{
                System.out.println("Username not available");
                tfusername.setText("");

            }

            }
            }
        }
        
    
    
    }
    
}
