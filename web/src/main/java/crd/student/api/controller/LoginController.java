package crd.student.api.controller;

import crd.student.api.common.DefaultValue;
import crd.student.api.reponse.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestParam(name = "name")String name,@RequestParam(name = "pwd")String pwd){
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
            //login方法提交认证，会执行CustomerShiroRealm中的doGetAuthenticationInfo认证方法
            SecurityUtils.getSubject().login(token);
            //认证通过
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"登陆成功");
        }catch (AuthenticationException e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"用户名或者密码错误");
        }catch (Exception e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,e.getMessage());
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Result login(){
        try{
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            //退出
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"退出成功");
        }catch (AuthenticationException e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"系统错误");
        }catch (Exception e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,e.getMessage());
        }
    }




}
