package com.example.geektrust;

public class CourseDetails {
    private String courseName;
    private String instructor;
    private String date;
    private int minEmp;
    private int maxEmp;
    private String cId;
    private long timestamp;
    private int id;
    private boolean status;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMinEmp() {
        return minEmp;
    }

    public void setMinEmp(int minEmp) {
        this.minEmp = minEmp;
    }

    public int getMaxEmp() {
        return maxEmp;
    }

    public void setMaxEmp(int maxEmp) {
        this.maxEmp = maxEmp;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
