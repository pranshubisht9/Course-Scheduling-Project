package com.example.geektrust;

public class RegisterEmployee {
    private String email;
    private String course;
    private String courseId;
    private boolean status;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RegisterEmployee() {
    }

    public RegisterEmployee(String email, String course, String courseId, boolean status) {
        this.email = email;
        this.course = course;
        this.courseId = courseId;
        this.status = status;
    }
}
