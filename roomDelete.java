import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class roomDelete extends delete implements ActionListener{
    public roomDelete(){
        setTitle("Room Maintainence");
        username=new JLabel("Room No: ");
        username.setBounds(30, 50, 70, 30);
        add(username);
        setVisible(true);
        backButton.addActionListener(this);
        submitButton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new Admin();
        } else if (e.getSource() == submitButton) {
            adminoperations ao=new adminoperations();
            int roomNumber = Integer.parseInt(tfusername.getText());
            ao.RoomMaintainence(roomNumber);
            dispose();
            new Admin();
        }
    }
    

    
}
