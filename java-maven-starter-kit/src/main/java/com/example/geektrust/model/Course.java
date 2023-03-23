package com.example.geektrust.model;

import java.util.*;

public class Course implements Comparable<Course>{
    private final String courseID;
    private final String courseName;
    private final String instructor;
    private final int minCap;
    private final int maxCap;
    private final Date date;
    private boolean isAllot;
    private boolean isCancel;

    private final Map<String , Employee> registerEmployees;


    public Course(String courseID, String courseName, String instructor, Date date, int minCapacity, int maxCapacity, boolean isAllotted, boolean isCancelled) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minCap = minCapacity;
        this.maxCap = maxCapacity;
        this.isAllot = isAllotted;
        this.isCancel = isCancelled;
        registerEmployees = new TreeMap<>();
    }
    public String getCourseID() {
        return courseID;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getInstructor() {
        return instructor;
    }
    public Date getDate() {
        return date;
    }
    public int getMinCapacity() {
        return minCap;
    }
    public int getMaxCapacity() {
        return maxCap;
    }
    public boolean isAllotted() {
        return isAllot;
    }
    public boolean isCancelled() {
        return isCancel;
    }
    public void setAllotted(boolean allotted) {
        isAllot = allotted;
    }
    public void setCancelled(boolean cancelled) {
        isCancel = cancelled;
    }
    public Map<String, Employee> getRegisterEmployees() {
        return registerEmployees;
    }
    public String addEmployee(Employee e){
        String registrationID = "REG-COURSE-"+e.getName()+"-"+this.courseName;
        this.registerEmployees.put(registrationID , e);
        return registrationID;
    }
    @Override
    public int compareTo(Course o) {
        return this.courseName.compareTo(o.courseName);
    }
}