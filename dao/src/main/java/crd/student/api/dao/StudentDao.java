package crd.student.api.dao;

import crd.student.api.mapper.StudentMapper;
import crd.student.api.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StudentDao extends StudentMapper {

    List<Student> getStudentList(HashMap hashMap);

    void deleteByGrade(HashMap hashMap);

    void upGrade(HashMap hashMap);

    Student findStudent(@Param(value="student")Student student);
}
