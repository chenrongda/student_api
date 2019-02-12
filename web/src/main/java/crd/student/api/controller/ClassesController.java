package crd.student.api.controller;

import crd.student.api.common.DefaultValue;
import crd.student.api.model.Admin;
import crd.student.api.model.Classes;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.UpClasses;
import crd.student.api.service.IClassesService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "classes")
public class ClassesController {

    @Autowired
    private IClassesService iClassesService;


    /**
     * 查询班级列表
     *
     * @return
     */
    @RequestMapping(value = "/getClassesList")
    @ResponseBody
    public List<Classes> getClassesList() {
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        return iClassesService.getClassesList(admin.getId());
    }

    /**
     * 新增/更新班级信息
     * @param classes
     * @return
     */
    @RequestMapping(value = "/addClasses",method = RequestMethod.POST)
    @ResponseBody
    public Result addClasses(@RequestBody Classes classes) {
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        if (classes.getClassName() != null && classes.getGrade() != null ) {
            return iClassesService.addClasses(classes, admin.getId());
        } else {
            return new Result(DefaultValue.REPONSE_FAIL_CODE, "请填写班级名称");
        }
    }

    /**
     * 班级升年级
     * @param upClasses
     * @return
     */
    @RequestMapping(value = "/upClasses",method = RequestMethod.POST)
    @ResponseBody
    public Result upClasses(@RequestBody UpClasses upClasses){
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        return iClassesService.upClasses(upClasses,admin.getId());
    }

}
