package crd.student.api.controller;

import crd.student.api.common.DefaultValue;
import crd.student.api.model.Score;
import crd.student.api.model.Student;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.StudentExam;
import crd.student.api.service.IScoreService;
import crd.student.api.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "wxApi")
public class WxApiController {

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IScoreService iScoreService;

    @RequestMapping(value = "/wxLogin")
    @ResponseBody
    public Result wxLogin(String studentName,String phone) {
        if (studentName != "" && phone != "") {
            Student requestStudent = new Student();
            requestStudent.setName(studentName);
            requestStudent.setPhone(phone);
            Student student = iStudentService.findStudent(requestStudent);
            if (student != null) {
                return new Result(DefaultValue.REPONSE_SUCCESS_CODE, "验证通过", student);
            } else {
                return new Result(DefaultValue.REPONSE_FAIL_CODE, "信息不正确");
            }
        } else {
            return new Result(DefaultValue.REPONSE_FAIL_CODE, "学生姓名及电话不能为空");
        }
    }


    @RequestMapping(value = "/getExamList")
    @ResponseBody
    public Result getExamList(@RequestBody Student student) {
        if (student.getId() != null) {
            List<StudentExam> studentExamList = iStudentService.getExamList(student);
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"成功",studentExamList);
        } else {
            return new Result(DefaultValue.REPONSE_FAIL_CODE, "参数错误");
        }
    }


    @RequestMapping(value = "/getStudentScore")
    @ResponseBody
    public Result getStudentScore(Integer examId,Integer studentId){
        if(examId != null & studentId != null){
           Score score = iScoreService.getStudentScore(examId,studentId);
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"成功",score);
        }else{
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"参数错误");
        }
    }

}
