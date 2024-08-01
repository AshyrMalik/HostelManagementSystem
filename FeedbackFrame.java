import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FeedbackFrame extends JFrame implements ActionListener{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 230;
    private String username;
    private JButton backButton, submitButton;
	private JTextField tffeed;
    private JLabel Feedback;
	    
    public FeedbackFrame(String name){
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        username=name;
        Feedback = new JLabel("Feedback:");
        tffeed = new JTextField();
        backButton = new JButton("Back");
        backButton.setBackground(Color.LIGHT_GRAY);
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.LIGHT_GRAY);
       
        // Set component bounds
        Feedback.setBounds(30, 50, 70, 30);
        tffeed.setBounds(120, 50,110, 50);
        backButton.setBounds(30, 110, 80, 30);
        submitButton.setBounds(130, 110, 80, 30);


        // Add components to the frame
        add(Feedback);
        add(tffeed);
        add(backButton);
        add(submitButton);
        backButton.addActionListener(this);
        submitButton.addActionListener(this);
        setVisible(true);



        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new StudentProfile(username);
        } else if (e.getSource() == submitButton) {
            Feedback f=new Feedback(tffeed.getText());
            adminoperations ao=new adminoperations();
            ao.Feedback(f);
            dispose();
            new StudentProfile(username);


            }

    }
}

    

