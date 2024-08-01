import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class adminoperations implements Bill  {
    
    ArrayList<Student> students=new ArrayList<Student>();
    ArrayList<Staff> staff=new ArrayList<Staff>();
    ArrayList<Feedback> feedback=new ArrayList<Feedback>();
    ArrayList<Rooms> rooms=new ArrayList<Rooms>();

    File admin=new File("Admin.txt"); 
    File stud=new File("Students.txt");
    File sta=new File("Staff.txt");
    File feed=new File("Feedback.txt");
    File room=new File("Rooms.txt");

    ObjectOutputStream oos=null;
    ObjectInputStream ois=null;
    qualifications Admin=new qualifications("admin","1234");

    public adminoperations() {
        try {
            if (admin.isFile()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(admin))) {
                    Admin = (qualifications) ois.readObject();
                    ois.close();
                }
            }
    
            if (stud.isFile()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(stud))) {
                    students = (ArrayList<Student>) ois.readObject();
                    
                }
            }
    
            if (sta.isFile()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sta))) {
                    staff = (ArrayList<Staff>) ois.readObject();
                   
                }
            }
    
            if (feed.isFile()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(feed))) {
                    feedback = (ArrayList<Feedback>) ois.readObject();
                   
                }
            }
    
            if (room.isFile()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(room))) {
                    rooms = (ArrayList<Rooms>) ois.readObject();
                   
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while finding or reading a file");
            e.printStackTrace();
        }
    }
    
    public void updateAdminUsername(String username){
        try {
            Admin.setUsername(username);
            oos = new ObjectOutputStream(new FileOutputStream(admin));
            oos.writeObject(Admin);
            oos.close();
            JOptionPane.showMessageDialog(null, "UserName updated");
    
        } catch (Exception e) {
            }
        
    }
    public boolean Passcheck(String oldPass){
        if(Admin.getPassword().equals(oldPass)){
            return true;
        }
        return false;
    }
    public void updatepass(String pass) {
        try {
         
        Admin.setUsername(pass);
        oos = new ObjectOutputStream(new FileOutputStream(admin));
        oos.writeObject(Admin);
        JOptionPane.showMessageDialog(null, "Password updated");

        oos.close();
   
        } catch (Exception e) {
             
        }
    }
    public qualifications getAdmin(){
        
        return Admin;

    }
    public boolean RoomCheck(int RoomNo){
        if (rooms.isEmpty()) {
			
            return true;
        }
		else{
			
			for (int i = 0 ;i<rooms.size() ;i++ ) {
				if (rooms.get(i).getRoomNO()==(RoomNo)) {
					return false;
				}
			}
            return true;
			
		}

    }
    public void addRooms(Rooms R){
        try {
            rooms.add(R);
            oos = new ObjectOutputStream(new FileOutputStream(room));
            oos.writeObject(rooms);
            oos.close();       
            JOptionPane.showMessageDialog(null, "Room added");
        } catch (Exception e) {
            System.out.println("There was some error in finding Room file");    
        
        }
        
    }
    public void RoomMaintainence(int roomNO){
        try {
            if (rooms.isEmpty()){
                JOptionPane.showMessageDialog(null, "There are no rooms");
                return;
            }
            for(int i=0;i<rooms.size();i++){
                if(rooms.get(i).getRoomNO()==roomNO){
                    if(rooms.get(i).isAvailability()==true){
                        rooms.get(i).setAvailability(false);
                        oos = new ObjectOutputStream(new FileOutputStream(room));
                        oos.writeObject(rooms);
                        JOptionPane.showMessageDialog(null, "Room is under maintainence");
                        oos.close();    
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Room is under occupancy , can not be maintained");
                        return;
                    }
                       
                }   
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in room file");    
        
           }

    }
    public void AvailRoom(int roomNO){
        try {
            if (rooms.isEmpty()){
                JOptionPane.showMessageDialog(null, "There are no rooms");
                return;
            }
            for(int i=0;i<rooms.size();i++){
                if(rooms.get(i).getRoomNO()==roomNO){
                    if(rooms.get(i).isAvailability()==false){
                        rooms.get(i).setAvailability(true);
                        oos = new ObjectOutputStream(new FileOutputStream(room));
                        oos.writeObject(rooms);
                        JOptionPane.showMessageDialog(null, "Room is available now");
                        oos.close();    
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Room is already available");
                        return;
                    }
                       
                }   
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in room file");    
        
           }

    }


    public Rooms bookroom(String type){
        try {
            

            for(int i=0;i<rooms.size();i++){
                Rooms r= rooms.get(i);
                if((r.getRoomtype().equals(type))&&(r.isAvailability())){
                    
                    int bed= r.getNO_of_bed();
                    r.setNO_of_bed(bed-1);
                    if(rooms.get(i).getNO_of_bed()<1){
                        r.setAvailability(false);
                    }

                    oos = new ObjectOutputStream(new FileOutputStream(room));
                    oos.writeObject(rooms);
                    String str="Your Room no is : " + rooms.get(i).getRoomNO();
                    JOptionPane.showMessageDialog(null, str );
                    oos.close();
                    return rooms.get(i);    
                    
                }   
            }   
            System.out.println("Room not avaiable"); 
            return null;
            
        }
         catch (Exception e) {
            System.out.println("There was some error in room file");    
            return null;
           }
        
    }

    public void freeroom(Rooms R){
        
        try {
            R.setNO_of_bed((R.getNO_of_bed() + 1));
            R.setAvailability(true);
            rooms.add(R);
            oos = new ObjectOutputStream(new FileOutputStream(room));
            oos.writeObject(rooms);
            oos.close();       
            JOptionPane.showMessageDialog(null, "Room added");
        } catch (Exception e) {
            System.out.println("There was some error in finding Room file");    
        
        }
 

    }
    public void DisplayRooms(){
        try {
            if (rooms.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Rooms");
                return;
            }
            
            for(int i=0;i<rooms.size();i++){
                JOptionPane.showMessageDialog(null, rooms.get(i).display());
            
            }
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Room file");    
        
           }
    }


    public void Feedback(Feedback x){
        try {
    
            feedback.add(x);
            oos = new ObjectOutputStream(new FileOutputStream(feed));
			oos.writeObject(feedback);
			oos.close();
            JOptionPane.showMessageDialog(null, "Thanks For Your Feedback");       
            
            
        } 
        catch (Exception e) {
            System.out.println("There was some error in finding feedback file");    
        
        }
    }
    public void DisplayFeed(){
        try {
            if (feedback.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Feedbacks");
                return;
            }
            else{
                for(int i=0;i<feedback.size();i++){
                JOptionPane.showMessageDialog(null, feedback.get(i).toString());
                
                }    
            }
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Staff file");    
        
           }

    }

    public void addStaff(Staff s){
        try {
            staff.add(s);
            oos = new ObjectOutputStream(new FileOutputStream(sta));
            oos.writeObject(staff);
            oos.close();   
            JOptionPane.showMessageDialog(null, "Staff added");    
        
        } catch (Exception e) {
            System.out.println("There was some error in finding Staff file");    
        
        }


    }
    
    
    public void deleteStaff(String name){
        try {

            for(int i=0;i<staff.size();i++){
                if( staff.get(i).getName().equals(name)){
                    staff.remove(i);
                    oos = new ObjectOutputStream(new FileOutputStream(sta));
                    oos.writeObject(staff);
                    oos.close();     
                    JOptionPane.showMessageDialog(null, "Staff Deleted");  
                }   
                else{
                    System.out.println("Staff Dont exist");
                } 
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Staff file");    
        
           }
        
    }

    public void displayStaff(){
        try {
            if(staff.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Staff");
                return;
            }

            for(int i=0;i<staff.size();i++){
                
                JOptionPane.showMessageDialog(null, staff.get(i).toString());
                

            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Staff file");    
        
           }

    }
    
    public void displayStudent(){
        try {

            for(int i=0;i<students.size();i++){
                JOptionPane.showMessageDialog(null, students.get(i).toString());

            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file3");    
        
           }

    }



    public void addStudent(Student s){
        try {
            students.add(s);
            oos = new ObjectOutputStream(new FileOutputStream(stud));
            oos.writeObject(students);
            oos.close();  
            JOptionPane.showMessageDialog(null, "Student Added ");     
            
        
        } catch (Exception e) {
            System.out.println("There was some error in finding Student file 1");
            e.printStackTrace();
        }

    }

    public void deleteStudent(String name){
        try {

            for(int i=0;i<students.size();i++){
                if(students.get(i).getUsername().equals(name)){
                    freeroom(students.get(i).getRooms());
                    students.remove(i);
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close();
                    JOptionPane.showMessageDialog(null, "Student Deleted");
                    break;
                }   
                
                 
            }   
            JOptionPane.showMessageDialog(null,"Student Dont exist");
                 
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file 2");
                
            e.printStackTrace();
           }


    }

    public void usernameupdateS(String name,String newUserName){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setUsername(newUserName);
                    JOptionPane.showMessageDialog(null,"User name Updated");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close();   
                    return;    
                }   
               
            }   
            JOptionPane.showMessageDialog(null,"Student Not Found"); 
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }

    }

    
    public void passwordupdateS(String name,String newpassword){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setPassword(newpassword);
                    JOptionPane.showMessageDialog(null,"Password Updated");
                    
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close(); 

                }   
                else{
                    System.out.println("Student dont exist");
                } 
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }

    public void nameupdateS(String name,String newname){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setName(newname);
                    JOptionPane.showMessageDialog(null,"Name Updated");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close();
                    return;       
                }   
            }  
            
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }

    public void AddressupdateS(String name,String address){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setAddress(address);
                    System.out.println("");
                    JOptionPane.showMessageDialog(null,"Address Updated");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close(); 
                    return;      
                }   
                
                
            }   
            JOptionPane.showMessageDialog(null,"Login SuccessFull");
                 
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }

    public void phonenoupdateS(String name,long newphoneno){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setPhonenumber(newphoneno);
                    System.out.println("");
                    JOptionPane.showMessageDialog(null,"PhoneNo Updated");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close(); 
                    return;      
                }   
            }   
            JOptionPane.showMessageDialog(null,"Student dont exist");
                 
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }
    public void idupdateS(String name,long id){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setPhonenumber(id);
                    System.out.println("");
                    JOptionPane.showMessageDialog(null,"Id Updated");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close(); 
                    return;      
                }   
            }   
            JOptionPane.showMessageDialog(null,"Student dont exist");
                 
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }
    


    public void messupdateS(String name,Boolean mess){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setMess(mess);
                    System.out.println("Mess Updated");
                    JOptionPane.showMessageDialog(null,"Login SuccessFull");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close();       
                }   
                else{
                    System.out.println("Student dont exist");
                } 
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }
    
    public void laundryupdateS(String name,Boolean laundry){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setLaundry(laundry);
                    System.out.println("Laundry Updated");
                    JOptionPane.showMessageDialog(null,"Login SuccessFull");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close();       
                }   
                else{
                    System.out.println("Student dont exist");
                } 
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }

    
    public void inverterupdateS(String name,Boolean invert ){
        try {

            for(int i=0;i<students.size();i++){
                
                if(students.get(i).getUsername().equals(name)){
                    students.get(i).setInverter(invert);
                    System.out.println("Mess Updated");
                    JOptionPane.showMessageDialog(null,"Login SuccessFull");
                    oos = new ObjectOutputStream(new FileOutputStream(stud));
                    oos.writeObject(students);
                    oos.close();       
                }   
                else{
                    System.out.println("Student dont exist");
                } 
            }    
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");    
        
           }
           
    }
    public boolean UsernameCheck(String name){
        try {
            
            for(int i=0;i<students.size();i++){
                String username = students.get(i).getUsername();
                if(username != null &&username.equals(name)){
                    return false;
                }   
                
            }    
            return true;
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");   
            e.printStackTrace(); 
            return true;
           }
    }
    public boolean finduser(String name){
        try {

            for(int i=0;i<students.size();i++){
                String username = students.get(i).getUsername();
                if(username != null &&username.equals(name)){
                    return true;
                }   
                
            }    
            return false;
        }
         catch (Exception e) {
            System.out.println("There was some error in finding Student file");   
            e.printStackTrace(); 
            return true;
           }
        
    }

    public void updateroom(){
        

    }
    public void updateroomtype(){

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
		System.out.println("ALL ok from the Calculate Bill Side");
        return bill;
        

        
	}
    public Student searchStudent(String username){
		if (students.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Student doesnot exist.");
            return null;
        }
		else{
			
			for (int i = 0 ;i<students.size() ;i++ ) {
				if (students.get(i).getUsername().equals(username)) {
					
					return students.get(i);
				}
			}
            return null;
			
		}

	}

    

}



    

    
