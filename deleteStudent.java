import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class deleteStudent extends delete implements ActionListener  {
    
    public deleteStudent(){
        super();
        username= new JLabel("Username: ");
        username.setBounds(30, 50, 70, 30);
        add(username);
        setTitle("Delete Student");
        backButton.addActionListener(this);
        submitButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new Admin();
        } 
        else if (e.getSource() == submitButton) {
            adminoperations ao=new adminoperations();
            ao.deleteStudent(tfusername.getText());
            dispose();
            new deleteStudent();
        }

    }
}
    

