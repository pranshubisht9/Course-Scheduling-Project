package com.example.geektrust.ServiceImpl;

import com.example.geektrust.exception.CourseException;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.service.CommandExecutor;
import java.util.Map;
import java.util.TreeMap;
import static com.example.geektrust.utility.FixedConstants.ACCEPTED;
import static com.example.geektrust.utility.FixedConstants.REJECTED;

public class RegisterCourseImpl implements CommandExecutor {


    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException, CourseException {
        String courseID = command.getCommandParams().get(1);
        Employee employee = ConstructEmployeeObject(command);
        if(courses.containsKey(courseID)){
            Course course = courses.get(courseID);
            if(!courses.get(courseID).isAllotted() || courses.get(courseID).isCancelled()){
                if(course.getRegisterEmployees().size()==course.getMaxCapacity()){
                    throw new CourseException("COURSE_FULL_ERROR");
                }else{
                    registerEmployeeToCourse(employee , course ,registrationIdCourseMap);
                }
            }else{
                System.out.println("REG-COURSE-"+employee.getName()+"-"+courses.get(courseID).getCourseName()+" "+REJECTED);
            }
        }else{
            System.out.println("INPUT_DATA_ERROR");
        }
    }
    private void registerEmployeeToCourse(Employee employee, Course course, Map<String, Course> registrationIdCourseMap) {
        String regID = course.addEmployee(employee);
        registrationIdCourseMap.put(regID , course);
        System.out.println(regID+" "+ACCEPTED);
    }
    private Employee ConstructEmployeeObject(Command command) throws InvalidInputException {
        return new Employee(command.getCommandParams().get(0));
    }
}
