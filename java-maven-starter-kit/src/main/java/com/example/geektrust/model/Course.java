package com.example.geektrust.model;

import java.util.Date;
import java.util.Map;

public class Course implements Comparable<Course>{
    private final String courseId;
    private final String courseName;
    private final String instructor;
    private final long minCap;
    private final long maxCap;

    private boolean isCancel;
    private boolean isAlotted;

    private final Map<String , Employee> registerEmployee;

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public long getMinCap() {
        return minCap;
    }

    public long getMaxCap() {
        return maxCap;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setCancel(boolean cancel) {
        isCancel = cancel;
    }

    public boolean isAlotted() {
        return isAlotted;
    }

    public void setAlotted(boolean alotted) {
        isAlotted = alotted;
    }

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Employee> getRegisterEmployee() {
        return registerEmployee;
    }

    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.courseName;
        this.registerEmployee.put(registrationID , e);
        return registrationID;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseName.compareTo(o.courseName);
    }
    public Course(String courseId, String courseName, String instructor, long minCap, long maxCap, Map<String, Employee> registerEmployee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.minCap = minCap;
        this.maxCap = maxCap;
        this.registerEmployee = registerEmployee;
    }

    public Course(String courseId, String courseName, String instructor, long minCap, long maxCap, boolean isCancel, boolean isAlotted, Map<String, Employee> registerEmployee, Date date) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.minCap = minCap;
        this.maxCap = maxCap;
        this.isCancel = isCancel;
        this.isAlotted = isAlotted;
        this.registerEmployee = registerEmployee;
        this.date = date;
    }
}
