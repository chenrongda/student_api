package crd.student.api.dao;

import crd.student.api.mapper.ScoreMapper;
import crd.student.api.model.Score;
import crd.student.api.reponse.StudentScore;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ScoreDao extends ScoreMapper {

    List<StudentScore> getListScore(HashMap hashMap);

    Score getStudentScore(HashMap hashMap);
}
