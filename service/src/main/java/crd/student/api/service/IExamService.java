package crd.student.api.service;

import crd.student.api.model.Exam;
import crd.student.api.reponse.PassingNum;
import crd.student.api.reponse.Result;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface IExamService{

    List<Exam> getExamList(Integer classesId);

    Result addExam(Exam exam);

    void updateAvgScore(Integer examId);

    List<PassingNum> getPassingNumber(Integer classesId );
}
