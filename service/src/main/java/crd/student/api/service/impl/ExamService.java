package crd.student.api.service.impl;

import crd.student.api.common.DefaultValue;
import crd.student.api.dao.ExamDao;
import crd.student.api.model.Exam;
import crd.student.api.reponse.PassingNum;
import crd.student.api.reponse.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import crd.student.api.service.IExamService;

import java.util.HashMap;
import java.util.List;

@Service
public class ExamService implements IExamService{

    @Autowired
    private ExamDao examDao;

    @Override
    public List<Exam> getExamList(Integer classesId) {
        HashMap hashMap = new HashMap();
        hashMap.put("classesId",classesId);
        return examDao.getExamList(hashMap);
    }

    @Override
    public Result addExam(Exam exam) {
        try{
            if(exam.getId() == null){
                examDao.insertSelective(exam);
            }else{
                examDao.updateByPrimaryKeySelective(exam);
            }
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"操作成功");
        }catch (Exception e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,e.getMessage());
        }
    }

    @Async
    @Override
    public void updateAvgScore(Integer examId) {
        //更新平均分
        examDao.updateAvgScore(examId);
    }

    @Override
    public List<PassingNum> getPassingNumber(Integer classesId) {
        return  examDao.getPassingNumber(classesId);
    }
}
