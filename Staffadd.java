import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Staffadd extends JFrame implements ActionListener {
    private JLabel nameLabel, addressLabel, idLabel, phoneNoLabel, payLabel, rankLabel;
    private JTextField nameField, addressField, idField, phoneNoField, payField, rankField;
    private JButton backButton, submitButton;

    public Staffadd() {
        setSize(300, 400);
        setTitle("Add Staff");
        setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 40, 100, 30);
        add(nameLabel);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 80, 100, 30);
        add(addressLabel);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 120, 100, 30);
        add(idLabel);

        phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(50, 160, 100, 30);
        add(phoneNoLabel);

        payLabel = new JLabel("Pay:");
        payLabel.setBounds(50, 200, 100, 30);
        add(payLabel);

        rankLabel = new JLabel("Rank:");
        rankLabel.setBounds(50, 240, 100, 30);
        add(rankLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 40, 100, 30);
        add(nameField);

        addressField = new JTextField();
        addressField.setBounds(150, 80, 100, 30);
        add(addressField);

        idField = new JTextField();
        idField.setBounds(150, 120, 100, 30);
        add(idField);

        phoneNoField = new JTextField();
        phoneNoField.setBounds(150, 160, 100, 30);
        add(phoneNoField);

        payField = new JTextField();
        payField.setBounds(150, 200, 100, 30);
        add(payField);

        rankField = new JTextField();
        rankField.setBounds(150, 240, 100, 30);
        add(rankField);

        backButton = new JButton("Back");
        backButton.setBounds(50, 280, 70, 30);
        backButton.addActionListener(this);
        add(backButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(140, 280, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new Admin();
            dispose();
           
        } else if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String address = addressField.getText();
            long id = Long.parseLong(idField.getText());
            long phoneNo = Long.parseLong(phoneNoField.getText());
            double pay = Double.parseDouble(payField.getText());
            String rank = rankField.getText();
            Staff s=new Staff(name, address,phoneNo,id ,pay , rank);
            adminoperations ao=new adminoperations();
            ao.addStaff(s);
            dispose();
            new Staffadd();
        }
    }

}
