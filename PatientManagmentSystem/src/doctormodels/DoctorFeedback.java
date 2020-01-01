/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormodels;

import java.io.Serializable;

/**
 *
 * @author dan
 */
public class DoctorFeedback implements Serializable{
    private int ratingID;
    private String doctorID;
    private int rating;
    private String feedbackNotes;

    /**
     * Constructor to create doctor feedback
     * @param doctorID
     * @param rating
     * @param feedbackNotes
     * @param ratingID
     */
    public DoctorFeedback(String doctorID, int rating, String feedbackNotes,int ratingID) {
        this.doctorID = doctorID;
        this.rating = rating;
        this.feedbackNotes = feedbackNotes;
        this.ratingID = ratingID;
    }

    /**
     * gets the doctor ID
     * @return the doctor ID as a string
     */
    public String getDoctorID() {
        return doctorID;
    }

    /**
     *sets the doctorID
     * @param doctorID
     */
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    /**
     * gets the rating 
     * @return the rating as an integer
     */
    public int getRating() {
        return rating;
    }

    /**
     * sets the rating 
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *gets the feedback notes
     * @return gets feedback as a string
     */
    public String getFeedbackNotes() {
        return feedbackNotes;
    }

    /**
     *set feedback by passing in a string
     * @param feedbackNotes
     */
    public void setFeedbackNotes(String feedbackNotes) {
        this.feedbackNotes = feedbackNotes;
    }

    /**
     * gets the rating ID
     * @return ratingID as a integer
     */
    public int getRatingID() {
        return ratingID;
    }

    /**
     * sets the rating ID as a integer
     * @param ratingID
     */
    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }
    
    
    
}
