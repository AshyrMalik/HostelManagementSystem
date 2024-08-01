import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Admin extends JFrame implements ActionListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    private JButton studAdd, studDelete, studDisplay, calculateBill, stafAdd, stafDelete, stafDisplay, update,
            feedDisplay, roomAdd, roomDelete,availableroom,DisplayRooms,logout;

    public Admin() {
        setSize(WIDTH, HEIGHT);
        setTitle("Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 3));

        studAdd = new JButton("Add Student");
        studAdd.setBackground(Color.LIGHT_GRAY);
        studDelete = new JButton("Delete Student");
        studDelete.setBackground(Color.LIGHT_GRAY);
        studDisplay = new JButton("Display Students");
        studDisplay.setBackground(Color.LIGHT_GRAY);
        calculateBill = new JButton("Calculate Bill");
        calculateBill.setBackground(Color.LIGHT_GRAY);
        stafAdd = new JButton("Add Staff");
        stafAdd.setBackground(Color.LIGHT_GRAY);
        stafDelete = new JButton("Delete Staff");
        stafDelete.setBackground(Color.LIGHT_GRAY);
        stafDisplay = new JButton("Display Staff");
        stafDisplay.setBackground(Color.LIGHT_GRAY);
        update = new JButton("Update Credentials");
        update.setBackground(Color.LIGHT_GRAY);
        feedDisplay = new JButton("Display Feedback");
        feedDisplay.setBackground(Color.LIGHT_GRAY);
        roomAdd = new JButton("Add Room");
        roomAdd.setBackground(Color.LIGHT_GRAY);
        roomDelete = new JButton("Room Maintenance");
        roomDelete.setBackground(Color.LIGHT_GRAY);
        availableroom=new JButton("Room available");
        availableroom.setBackground(Color.LIGHT_GRAY);
        DisplayRooms=new JButton("Display Room");
        DisplayRooms.setBackground(Color.LIGHT_GRAY);
        logout = new JButton("Logout");
        logout.setBackground(Color.LIGHT_GRAY);
        
        studAdd.addActionListener(this);
        studDelete.addActionListener(this);
        studDisplay.addActionListener(this);
        calculateBill.addActionListener(this);
        stafAdd.addActionListener(this);
        stafDelete.addActionListener(this);
        stafDisplay.addActionListener(this);
        update.addActionListener(this);
        feedDisplay.addActionListener(this);
        roomAdd.addActionListener(this);
        roomDelete.addActionListener(this);
        availableroom.addActionListener(this);
        DisplayRooms.addActionListener(this);
        logout.addActionListener(this);
      
        add(studAdd);
        add(studDelete);
        add(studDisplay);
        add(calculateBill);
        add(stafAdd);
        add(stafDelete);
        add(stafDisplay);
        add(update);
        add(feedDisplay);
        add(roomAdd);
        add(roomDelete);
        add(availableroom );
        add(DisplayRooms);
        add(logout);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == studAdd) {
           
            dispose();
            new addingStudent();
            
        }
        else if (e.getSource() == studDelete) {
            
            dispose();
            new deleteStudent();

        }
        else if (e.getSource() == studDisplay) {
            adminoperations ao=new adminoperations();
            ao.displayStudent();
            
        }
        else if (e.getSource() == calculateBill) {
            
            dispose();
            new calculatebillFrame();

        }
        else if (e.getSource() == stafAdd) {
            
            dispose();    
            new Staffadd();
        
        } 
        else if (e.getSource() == stafDelete) {
            
            dispose();
            new deleteStaff();
        
        } 
        else if (e.getSource() == stafDisplay) {
            adminoperations ao=new adminoperations();
            ao.displayStaff();
            
        } else if (e.getSource() == update) {
            dispose();
            new UpdatingAdminProfile();

        } else if (e.getSource() == feedDisplay) {
            adminoperations ao=new adminoperations();
            ao.DisplayFeed();
           
        } else if (e.getSource() == roomAdd) {
            
            dispose();
            new AddRoom();
        } else if (e.getSource() == roomDelete) {
            
            dispose();
            new roomDelete();
        }
        else if (e.getSource() == availableroom) {
            
            dispose();
            new AvailRoom();

        }
        else if (e.getSource() == DisplayRooms) {
            adminoperations ao=new adminoperations();
            ao.DisplayRooms();
           
        }
        

        else if(e.getSource() == logout){
            dispose();
            new adminLogin();
        }
    }

   
}
