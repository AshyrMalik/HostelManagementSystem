import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StudentActivites implements Bill 
{
    File stud =new File("Students.txt");
    File feed =new File("Feedback.txt");
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    ArrayList<Student> students=new ArrayList<Student>();
       
    public StudentActivites(){

        try
		{
			if (stud.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(stud));
			students = (ArrayList<Student>)ois.readObject();
			ois.close();
		}
		}
		catch(Exception e){
			System.out.println(e);
		}

    }

    public void DisplayProfile(String name){
        for(int i=0;i<students.size();i++){
                
            if(students.get(i).getUsername().equals(name)){
                JOptionPane.showMessageDialog(null, students.get(i).toString());;
            
            }
            
        }
    
    }

    public Boolean checkPassword(String name,String password){
       
        if(students.size()==0){
            System.out.println("Invalid Username or Password");
            return false;
       }

       else{
            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)&& students.get(i).getPassword().equals(password)){
                    JOptionPane.showMessageDialog(null,"Login SuccessFull");
                    return true;
                }
                
            }
            JOptionPane.showMessageDialog(null,"Invalid Username or Password");
            
            return false;
            
       }
      

    } 

    
    @Override
    public double calculateBill(String username){
		Student s = null;
		for (int i = 0 ;i<students.size() ;i++ ) {
			if (students.get(i).getUsername().equals(username)) {
				s = students.get(i);
				break;
			}
		}
        if(s==null){
            return 0;
        }

		double bill = 0;
		Rooms r = s.getRooms();


		if (r.getRoomtype().equals("1 Seater")) {
			bill+=18000;
		}
		else if (r.getRoomtype().equals("2 Seater")) {
			bill+=15000;
		}
		else{
			bill+=12000;
		}

        if(s.isMess()){
           bill+= 5000 ;

        }
        if(s.isInverter()){
            bill+= 5000;
        }
        if(s.isLaundry()){
            bill += 5000 ;
        }
		return bill;
	}



}
