package crd.student.api.service.impl;

import crd.student.api.common.DefaultValue;
import crd.student.api.dao.ScoreDao;
import crd.student.api.model.Score;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crd.student.api.service.IScoreService;

import java.util.HashMap;
import java.util.List;

@Service
public class ScoreService implements IScoreService{

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public List<StudentScore> getScoreList(Integer classesId, Integer examId,Integer grade) {
        HashMap hashMap = new HashMap();
        hashMap.put("classesId",classesId);
        hashMap.put("examId",examId);
        hashMap.put("grade",grade);
        return scoreDao.getListScore(hashMap);
    }

    @Override
    public Result addScore(List<StudentScore> studentScoreList) {
        try{
            for(StudentScore s:studentScoreList){
                if(s.getId() == null){
                    //新增
                    scoreDao.insertSelective(s);
                }else{
                    //更新
                    scoreDao.updateByPrimaryKeySelective(s);
                }
            }
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"操作成功");
        }catch (Exception e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,e.getMessage());
        }
    }

    @Override
    public Score getStudentScore(Integer examId, Integer studentId) {
        HashMap hashMap = new HashMap();
        hashMap.put("examId",examId);
        hashMap.put("studentId",studentId);
        return scoreDao.getStudentScore(hashMap);
    }
}
