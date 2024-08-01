import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class calculatebillFrame extends delete implements ActionListener {
    public calculatebillFrame(){
        username=new JLabel("User name: ");
        username.setBounds(30, 50, 70, 30);
        add(username);
        setTitle("BILL");
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
            String name=tfusername.getText();
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
				disp += "Inverter: "+ 5000 +"/-Rs\n";
			}
			else{
				disp += "Inverter: "+ 0 +"/-Rs\n";
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
            
            tfusername.setText(" ");
            
        }
    
    }
}