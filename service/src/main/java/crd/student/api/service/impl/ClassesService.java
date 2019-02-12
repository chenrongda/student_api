package crd.student.api.service.impl;

import crd.student.api.common.DefaultValue;
import crd.student.api.dao.ClassesDao;
import crd.student.api.dao.StudentDao;
import crd.student.api.model.Classes;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.UpClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crd.student.api.service.IClassesService;

import java.util.HashMap;
import java.util.List;

@Service
public class ClassesService implements IClassesService{

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private StudentDao studentDao;

    /**
     * 查询获取班级列表
     * @return
     */
    @Override
    public List<Classes> getClassesList(Integer id) {

        return classesDao.getClassesList(id);
    }

    @Override
    public Result addClasses(Classes classes, Integer id) {
        try{
            if(classes.getId() != null){
                //编辑
                classesDao.updateByPrimaryKeySelective(classes);
            }else{
                //新增
                classes.setAdminId(id);
                classesDao.insertSelective(classes);
            }
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"操作成功");
        }catch (Exception e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"操作失败");
        }
    }

    @Override
    public Result upClasses(UpClasses upClasses,Integer id) {
        //先新增班级
        Classes newClasses = upClasses.getUpClasses();
        Classes oldClasses = upClasses.getOldUpClasses();
        if(newClasses.getGrade() == null || newClasses.getClassName() == null){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"请填写年级或班级");
        }
        try {
            newClasses.setAdminId(id);
            classesDao.insertSelective(newClasses);
            HashMap hashMap = new HashMap();
            hashMap.put("newGrade",newClasses.getGrade());
            hashMap.put("newClassesId",newClasses.getId());
            hashMap.put("oldGrade",oldClasses.getGrade());
            hashMap.put("oldClassesId",oldClasses.getId());
            studentDao.upGrade(hashMap);
            return new Result(DefaultValue.REPONSE_SUCCESS_CODE,"操作成功");
        }catch (Exception e){
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"操作失败");
        }
    }
}
