package crd.student.api.controller;

import crd.student.api.model.Exam;
import crd.student.api.reponse.PassingNum;
import crd.student.api.reponse.Result;
import crd.student.api.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "exam")
public class ExamController {

    @Autowired
    private IExamService iExamService;

    @RequestMapping(value = "/getExamList")
    @ResponseBody
    public List<Exam> getExamList(@RequestParam(value = "classesId",defaultValue = "0")Integer classesId ){
       return iExamService.getExamList(classesId);
    }

    @RequestMapping(value = "/addExam",method = RequestMethod.POST)
    @ResponseBody
    public Result addExam(@RequestBody Exam exam){
        return iExamService.addExam(exam);
    }


    @RequestMapping(value = "/getPassingNumber",method = RequestMethod.GET)
    @ResponseBody
    public List<PassingNum> getPassingNumber(@RequestParam(value = "classesId",defaultValue = "0")Integer classesId ){
        return iExamService.getPassingNumber(classesId);
    }
}
