
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddRoom extends JFrame implements ActionListener {
    private JLabel RoomNO, Roomtype;
    private JTextField tfRoomNO;
    private JButton back, submit;
    private JRadioButton type1, type2, type3;
    private ButtonGroup group;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 290;

    public AddRoom() {
        setTitle("Add Rooms");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        RoomNO = new JLabel("Room Number:");
        RoomNO.setBounds(50, 40, 100, 30);
        add(RoomNO);
        tfRoomNO = new JTextField();
        tfRoomNO.setBounds(150, 40, 150, 30);
        add(tfRoomNO);

        Roomtype = new JLabel("Room Type:");
        Roomtype.setBounds(50, 80, 100, 30);
        add(Roomtype);
        type1 = new JRadioButton("1");
        type1.setBounds(150, 80, 45, 30);
        add(type1);
        type2 = new JRadioButton("2");
        type2.setBounds(200, 80, 45, 30);
        add(type2);
        type3 = new JRadioButton("3");
        type3.setBounds(250, 80, 45, 30);
        add(type3);

        group = new ButtonGroup();
        group.add(type1);
        group.add(type2);
        group.add(type3);

        back = new JButton("Back");
        back.setBounds(90, 170, 80, 30);
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        add(back);

        submit = new JButton("Submit");
        submit.setBounds(190, 170, 80, 30);
        submit.addActionListener(this);
        add(submit);
        submit.setBackground(Color.LIGHT_GRAY);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            new Admin();
        } else if (e.getSource() == submit) {
            adminoperations ao=new adminoperations();
            int roomNumber = Integer.parseInt(tfRoomNO.getText());
            if(ao.RoomCheck(roomNumber)){

            
            String roomType = "";
            int bed=0;
            if (type1.isSelected()) {
                roomType = "1 Seater";
                bed = 1;
            } else if (type2.isSelected()) {
                roomType = "2 Seater";
                bed =2;
            } else if (type3.isSelected()) {
                roomType = "3 Seater";
                bed = 3;
            }
            Rooms R=new Rooms(roomNumber, roomType, bed);
            
            ao.addRooms(R);
            dispose();
            new AddRoom();
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Room number already exists");
                tfRoomNO.setText("");
                
            }
        }
    }

}
