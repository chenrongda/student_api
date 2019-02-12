package crd.student.api.dao;

import crd.student.api.mapper.ExamMapper;
import crd.student.api.model.Exam;
import crd.student.api.reponse.PassingNum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ExamDao extends ExamMapper {

    List<Exam> getExamList(HashMap hashMap);

    void updateAvgScore(@Param(value = "examId") Integer examId);

    List<PassingNum> getPassingNumber(@Param(value = "classesId")Integer classesId);
}
