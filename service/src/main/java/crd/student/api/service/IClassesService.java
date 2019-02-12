package crd.student.api.service;

import crd.student.api.model.Classes;
import crd.student.api.reponse.Result;
import crd.student.api.reponse.UpClasses;

import java.util.List;

public interface IClassesService{

    public List<Classes> getClassesList(Integer id);

    public Result addClasses(Classes classes,Integer id);

    public Result upClasses(UpClasses upClasses,Integer id);
}
