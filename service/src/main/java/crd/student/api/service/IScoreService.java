package crd.student.api.service;

import crd.student.api.model.Score;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.StudentScore;

import java.util.List;

public interface IScoreService{

    List<StudentScore> getScoreList(Integer classesId, Integer examId,Integer grade);

    Result addScore(List<StudentScore> studentScoreList);

    Score getStudentScore(Integer examId, Integer studentId);
}
