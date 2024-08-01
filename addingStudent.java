import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class addingStudent extends Signup {
    public addingStudent(){
        super();
        setTitle("Adding Student");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==back){
            dispose();
            new Admin();
        }   
        
        if(e.getSource()==Submit){
            if(tfusername.getText().equals("")||tfpassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Invalid Input");
            }
            else{
            adminoperations aao=new adminoperations();

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
                new addingStudent();
            
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