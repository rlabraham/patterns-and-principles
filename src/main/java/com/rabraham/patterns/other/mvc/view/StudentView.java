package com.rabraham.patterns.other.mvc.view;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo){
        log.info("Student: ");
        log.info("Name: {}", studentName);
        log.info("Roll No: {}", studentRollNo);
    }
}
