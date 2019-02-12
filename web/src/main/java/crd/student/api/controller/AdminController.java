package crd.student.api.controller;

import crd.student.api.model.Admin;
import crd.student.api.service.IAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;

    @RequestMapping(value = "/getAdminInfo")
    @ResponseBody
    public Admin getAdminInfo() {
        Admin admin =(Admin) SecurityUtils.getSubject().getPrincipal();
        admin.setPassWord("");
        return admin;
    }

}
