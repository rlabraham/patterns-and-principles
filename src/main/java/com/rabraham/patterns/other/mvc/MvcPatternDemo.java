package com.rabraham.patterns.other.mvc;

import com.rabraham.patterns.other.mvc.controller.StudentController;
import com.rabraham.patterns.other.mvc.model.Student;
import com.rabraham.patterns.other.mvc.view.StudentView;

public class MvcPatternDemo {
    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Student model  = retrieveStudentFromDatabase();

        //Create a view : to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        //update model data
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
