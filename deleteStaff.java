import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class deleteStaff extends delete implements ActionListener  {
    
    public deleteStaff(){
        super();
        setTitle("Delete Staff");
        username=new JLabel("Name: ");
        username.setBounds(30, 50, 70, 30);
        add(username);
        backButton.addActionListener(this);
        submitButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new Admin();
        } else if (e.getSource() == submitButton) {
            adminoperations ao=new adminoperations();
            ao.deleteStaff(tfusername.getText());
            dispose();
            new deleteStaff();
        }
    }
    
}

