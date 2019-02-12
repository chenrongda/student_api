package crd.student.api.service.impl;

import crd.student.api.common.DefaultValue;
import crd.student.api.dao.ScoreDao;
import crd.student.api.dao.StudentDao;
import crd.student.api.model.Classes;
import crd.student.api.model.Exam;
import crd.student.api.model.Student;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.StudentExam;
import crd.student.api.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crd.student.api.service.IStudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private IExamService iExamService;

    @Override
    public List<Student> getStudentList(Classes classes) {
        HashMap hashMap = new HashMap();
        hashMap.put("grade", classes.getGrade());
        hashMap.put("classId", classes.getId());
        return studentDao.getStudentList(hashMap);
    }

    @Override
    public Result addStudent(Student student) {
        try {
            if (student.getId() != null) {
                //编辑
                studentDao.updateByPrimaryKeySelective(student);
            } else {
                //新增
                studentDao.insertSelective(student);
            }
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE, "操作成功");
        } catch (Exception e) {
            return new Result(DefaultValue.REPONSE_FAIL_CODE, e.getMessage());
        }
    }

    @Override
    public Result delStudent(Student student, Integer grade) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("grade", grade);
            hashMap.put("studentId", student.getId());
            studentDao.deleteByGrade(hashMap);
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE, "删除成功");
        } catch (Exception e) {
            return new Result(DefaultValue.REPONSE_FAIL_CODE, "删除失败");
        }

    }

    /**
     * 查询单个学生的个人信息
     *
     * @param student
     * @return
     */
    @Override
    public Student findStudent(Student student) {
        return studentDao.findStudent(student);
    }

    /**
     * 获取某个学生的考试记录
     *
     * @param student
     * @return
     */
    @Override
    public List<StudentExam> getExamList(Student student) {
        List<StudentExam> studentExamList = new ArrayList<>();
        if (student.getGrade1Id() != null) {
            StudentExam studentExam = new StudentExam();
            studentExam.setGradeName("一年级");
            List<Exam> examList = iExamService.getExamList(student.getGrade1Id());
            studentExam.setExamList(examList);
            studentExamList.add(studentExam);
        }

        if (student.getGrade2Id() != null) {
            StudentExam studentExam = new StudentExam();
            studentExam.setGradeName("二年级");
            List<Exam> examList = iExamService.getExamList(student.getGrade2Id());
            studentExam.setExamList(examList);
            studentExamList.add(studentExam);
        }

        if (student.getGrade3Id() != null) {
            StudentExam studentExam = new StudentExam();
            studentExam.setGradeName("三年级");
            List<Exam> examList = iExamService.getExamList(student.getGrade3Id());
            studentExam.setExamList(examList);
            studentExamList.add(studentExam);
        }

        if (student.getGrade4Id() != null) {
            StudentExam studentExam = new StudentExam();
            studentExam.setGradeName("四年级");
            List<Exam> examList = iExamService.getExamList(student.getGrade4Id());
            studentExam.setExamList(examList);
            studentExamList.add(studentExam);
        }

        if (student.getGrade5Id() != null) {
            StudentExam studentExam = new StudentExam();
            studentExam.setGradeName("五年级");
            List<Exam> examList = iExamService.getExamList(student.getGrade5Id());
            studentExam.setExamList(examList);
            studentExamList.add(studentExam);
        }

        if (student.getGrade6Id() != null) {
            StudentExam studentExam = new StudentExam();
            studentExam.setGradeName("六年级");
            List<Exam> examList = iExamService.getExamList(student.getGrade6Id());
            studentExam.setExamList(examList);
            studentExamList.add(studentExam);
        }
        return studentExamList;
    }
}
