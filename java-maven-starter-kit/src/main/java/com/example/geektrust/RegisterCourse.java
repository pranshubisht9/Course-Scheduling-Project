package com.example.geektrust;

import java.util.List;

public class RegisterCourse {

    protected static  List<CourseDetails> courseList;
    protected static  List<RegisterEmployee> registerEmp;

    public static String registerCourse(String email, String course) {
        if (email == null || course == null || email.isEmpty() || course.isEmpty()) {
            return "INPUT_DATA_ERROR";
        }
        CourseDetails courseDetails = null;
        for (CourseDetails cd : courseList) {
            if (cd.getcId().equals(course)) {
                courseDetails = cd;
                break;
            }
        }
        if (courseDetails == null) {
            return "INPUT_DATA_ERROR";
        }
        String[] emailId = email.split("@");
        String name = emailId[0];
        RegisterEmployee addEmp = new RegisterEmployee(email, "REG-COURSE-" + name + "-" + courseDetails.getCourseName(), courseDetails.getcId(), true);
        if (registerEmp.size() < courseDetails.getMaxEmp()) {
            registerEmp.add(addEmp);
        } else {
            return "COURSE_FULL_ERROR";
        }
        return "REG-COURSE-" + name + "-" + courseDetails.getCourseName() + " ACCEPTED";
    }
}