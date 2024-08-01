import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentProfile extends JFrame implements ActionListener{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    String Username;
    JButton viewProfile,calculateBill,viewMenue,Feedback,UpdateProfile,Logout;    
    
    public StudentProfile(String Username){
        this.Username=Username;
        setSize(WIDTH, HEIGHT);
        setTitle("User Signup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,3));

        viewProfile=new JButton("View Profile");
        viewProfile.setBackground(Color.LIGHT_GRAY);
        viewMenue=new JButton("Menue");
        viewMenue.setBackground(Color.LIGHT_GRAY);
        calculateBill=new JButton("Calculate Bill");
        calculateBill.setBackground(Color.LIGHT_GRAY);
        Feedback=new JButton("Feedback");
        Feedback.setBackground(Color.LIGHT_GRAY);
        UpdateProfile=new JButton("Update Profile");
        UpdateProfile.setBackground(Color.LIGHT_GRAY);
        Logout=new JButton("Logout");
        Logout.setBackground(Color.LIGHT_GRAY);

        add(viewProfile);
		add(viewMenue);
		add(calculateBill);
		add(Feedback);
		add(UpdateProfile);
		add(Logout);
		viewProfile.addActionListener(this);
		viewMenue.addActionListener(this);
		calculateBill.addActionListener(this);
		Feedback.addActionListener(this);
		Logout.addActionListener(this);
		UpdateProfile.addActionListener(this);

        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== viewProfile) {
            StudentActivites st = new StudentActivites();
            st.DisplayProfile(Username);
        }
        else if (e.getSource()==viewMenue) {
            hostelMenue menu = new hostelMenue();
            menu.displayMenu();
        }

        else if (e.getSource()==calculateBill) {
            adminoperations ao=new adminoperations();
            String name=Username;
            double Bill = ao.calculateBill(name);
            Student s=ao.searchStudent(name);

            if (s==null){
                JOptionPane.showMessageDialog(null,"Student record not found");
                return;
            }
            
            String disp = "Room Type: "+s.getRooms().getRoomtype()+"\n";
			
            if (s.isLaundry()) {
				disp += "Laundry: "+ 5000 +"/-Rs\n";
			}
			else{
				disp += "Laundry: "+ 0 +"/-Rs\n";
			}
			if (s.isInverter()) {
				disp += "Mess: "+ 5000 +"/-Rs\n";
			}
			else{
				disp += "Mess: "+ 0 +"/-Rs\n";
			}
            if (s.isMess()) {
				disp += "Mess: "+ 5000 +"/-Rs\n";
			}
			else{
				disp += "Mess: "+ 0 +"/-Rs\n";
			}
            

			String bill = "Bill: "+Bill;
			disp+=bill;
            JOptionPane.showMessageDialog(null,disp);

            
            
            
        }
        else if (e.getSource()==Feedback) {
            dispose();
            new FeedbackFrame(Username);
            
        }
        else if (e.getSource()==UpdateProfile) {
            
            dispose();
            new Updateprofile(Username);
           
        }
        if (e.getSource()== Logout) {
            dispose();
            new Startup();
        }
       


    } 

   
   


}
