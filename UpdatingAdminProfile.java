import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatingAdminProfile extends JFrame implements ActionListener {
    private JLabel usernameLabel,oldpasswordLabel, newPasswordLabel;
    private JTextField Tfusername, Tfoldpassword, TfnewPassword;
    private JButton usernameButton, passwordButton;
    private JButton back;

    public UpdatingAdminProfile() {
        setSize(450, 300);
        setTitle("Update Admin Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        oldpasswordLabel = new JLabel("Old Password:");
        add(oldpasswordLabel);
        newPasswordLabel = new JLabel("New Password:");
        add(newPasswordLabel);
        Tfusername = new JTextField();
        add(Tfusername);
        Tfoldpassword = new JTextField();
        add(Tfoldpassword);
        TfnewPassword = new JTextField();
        add(TfnewPassword);
        usernameButton = new JButton("Update");
        usernameButton.addActionListener(this);
        passwordButton = new JButton("Update");
        passwordButton.addActionListener(this);
        back = new JButton("Back");
       
        back.addActionListener(this);

        add(usernameButton); add(passwordButton); add(back);

        usernameLabel.setBounds(50, 40, 100, 30);
        oldpasswordLabel.setBounds(50, 80, 100, 30);
        newPasswordLabel.setBounds(50, 120, 120, 30);
        Tfusername.setBounds(150, 40, 100, 30);
        Tfoldpassword.setBounds(150, 80, 100, 30);
        TfnewPassword.setBounds(150, 120, 100, 30);
        usernameButton.setBounds(290, 40, 100, 30);
        passwordButton.setBounds(290, 120, 100, 30);
        back.setBounds(50, 180, 70, 30);
        setVisible(true);

       
        back.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        adminoperations ao=new adminoperations();
        if (e.getSource() == usernameButton) {
           
            ao.updateAdminUsername(Tfusername.getText());
            
            
        } else if (e.getSource() == passwordButton) {
            if (Tfoldpassword.getText().equals(ao.getAdmin().getPassword())){
                ao.updatepass(TfnewPassword.getText());
            }
            else{
                Tfoldpassword.setText("");
                JOptionPane.showMessageDialog(null, "Invalid Old password");

            }
           
        } else if (e.getSource() == back) {
            dispose();
            new Admin();
        }
    }

    
}

