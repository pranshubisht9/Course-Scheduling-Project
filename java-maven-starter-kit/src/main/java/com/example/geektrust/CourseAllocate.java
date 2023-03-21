package com.example.geektrust;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.geektrust.RegisterCourse.courseList;
import static com.example.geektrust.RegisterCourse.registerEmp;


public class CourseAllocate {
    public static boolean courseAlloted(String course, int cnt) {
        CourseDetails courseDetails = null;
        for (CourseDetails c : courseList) {
            if (c.getcId().equals(course)) {
                courseDetails = c;
                break;
            }
        }
        List<RegisterEmployee> result = new ArrayList<>();
        for (RegisterEmployee r : registerEmp) {
            if (r.getCourseId().equals(course)) {
                result.add(r);
            }
        }
        if (cnt != 5) {
            Collections.reverse(result);
        }
        List<String> temp = new ArrayList<>();
        String courseStatus = "CONFIRMED";
        if (result.size() < courseDetails.getMinEmp()) {
            courseStatus = "COURSE_CANCELED";
        }
        for (RegisterEmployee r : result) {
            if (r.isStatus()) {
                String message = r.getCourse() + " " + r.getEmail() + " " + r.getCourseId() + " " +
                        courseDetails.getCourseName() + " " + courseDetails.getInstructor() +
                        " " + courseDetails.getDate() + " " + courseStatus;
                System.out.println(message);
                temp.add(message);
            }
        }
        return true;
    }

}
