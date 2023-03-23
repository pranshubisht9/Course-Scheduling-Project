package com.example.geektrust.model;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Course implements Comparable<Course>{
    private final String courseId;
    private final String courseName;
    private final String instructor;
    private final Date date;
    private final int minCapacity;
    private final int maxCapacity;
    private boolean isAllotted;
    private boolean isCancel;

    private final Map<String , Employee> registerEmployees;


    public Course(String courseID, String courseName, String instructor, Date date, int minCapacity, int maxCapacity, boolean isAllotted, boolean isCancelled) {
        this.courseId = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.isAllotted = isAllotted;
        this.isCancel = isCancelled;
        registerEmployees = new TreeMap<>();
    }

    public String getCourseID() {
        return courseId;
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
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isAllotted() {
        return isAllotted;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public void setAllotted(boolean allotted) {
        isAllotted = allotted;
    }

    public void setCancel(boolean cancelled) {
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
