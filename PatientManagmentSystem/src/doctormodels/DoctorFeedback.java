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
public class DoctorFeedback {
    private int ratingID;
    private String doctorID;
    private int rating;
    private String feedbackNotes;

    public DoctorFeedback(String doctorID, int rating, String feedbackNotes,int ratingID) {
        this.doctorID = doctorID;
        this.rating = rating;
        this.feedbackNotes = feedbackNotes;
        this.ratingID = ratingID;
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

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }
    
    
    
}
