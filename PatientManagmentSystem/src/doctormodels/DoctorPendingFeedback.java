/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormodels;

/**
 *
 * @author dan
 */
public class DoctorPendingFeedback {
    private String doctorID;
    private int rating;
    private String feedbackNotes;

    public DoctorPendingFeedback(String doctorID, int rating, String feedbackNotes) {
        this.doctorID = doctorID;
        this.rating = rating;
        this.feedbackNotes = feedbackNotes;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedbackNotes() {
        return feedbackNotes;
    }

    public void setFeedbackNotes(String feedbackNotes) {
        this.feedbackNotes = feedbackNotes;
    }
}
