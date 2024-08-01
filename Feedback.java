import java.io.Serializable;

public class Feedback implements Serializable{
    
    private String Feedback;

    public Feedback() {
    }
    public Feedback(String feedback) {
        Feedback = feedback;
    }
    public String getFeedback() {
        return Feedback;
    }
    public void setFeedback(String feedback) {
        Feedback = feedback;
    }
    @Override
    public String toString() {
        return "Feedback: " + Feedback;
    }

    

}
