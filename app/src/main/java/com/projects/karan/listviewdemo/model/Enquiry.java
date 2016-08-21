package com.projects.karan.listviewdemo.model;

/**
 * Created by ADMIN on 8/21/2016.
 */
public class Enquiry {

    private static int enquiryCount;
    private int enquiryId;
    private String enquirerName;
    private String courseName;
    private String contactNumber;
    private String description;

    public Enquiry(String contactNumber, String courseName, String description, String enquirerName) {
        this.contactNumber = contactNumber;
        this.courseName = courseName;
        this.description = description;
        this.enquirerName = enquirerName;
        enquiryId = ++enquiryCount;
    }



    public static void setEnquiryCount(int enquiryCount) {
        Enquiry.enquiryCount = enquiryCount;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getEnquirerName() {
        return enquirerName;
    }

    public static int getEnquiryCount() {
        return enquiryCount;
    }

    public int getEnquiryId() {
        return enquiryId;
    }
}
