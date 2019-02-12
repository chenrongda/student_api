package crd.student.api.controller;

import crd.student.api.common.DefaultValue;
import crd.student.api.model.Score;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.StudentScore;
import crd.student.api.service.IExamService;
import crd.student.api.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "score")
public class ScoreController {

    @Autowired
    private IScoreService iScoreService;

    @Autowired
    private IExamService iExamService;


    /**
     * 查询某个班级某次考试的成绩
     * @return
     */
    @RequestMapping(value = "/getScoreList")
    @ResponseBody
    public List<StudentScore> getScoreList(@RequestParam(value = "classesId",defaultValue = "0")Integer classesId,
                                           @RequestParam(value = "grade",defaultValue = "0")Integer grade,
                                           @RequestParam(value = "examId",defaultValue = "0")Integer examId){
        if(grade > 0){
            return iScoreService.getScoreList(classesId,examId,grade);
        }else{
            return null;
        }
    }

    /**
     * 添加学生分数
     * @return
     */
    @RequestMapping(value = "/addScore",method = RequestMethod.POST)
    @ResponseBody
    public Result addScore(@RequestBody List<StudentScore> studentScoreList){
        Result res = null;
        if(studentScoreList.size() > 0){
            res = iScoreService.addScore(studentScoreList);
            iExamService.updateAvgScore(studentScoreList.get(0).getExamId());
        }else{
            res = new Result(DefaultValue.REPONSE_FAIL_CODE,"上报数据为空");
        }
        return res;
    }
}
