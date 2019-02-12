package crd.student.api.service;

import crd.student.api.model.Classes;
import crd.student.api.model.Student;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.StudentExam;

import java.util.List;

public interface IStudentService{

    List<Student> getStudentList(Classes classes);

    Result addStudent(Student student);

    Result delStudent(Student student,Integer grade);

    Student findStudent(Student student);

    List<StudentExam> getExamList(Student student);
}
