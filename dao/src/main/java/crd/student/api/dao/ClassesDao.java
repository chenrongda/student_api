package crd.student.api.dao;

import crd.student.api.mapper.ClassesMapper;
import crd.student.api.model.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassesDao extends ClassesMapper {
    List<Classes> getClassesList(@Param(value = "id") Integer id);
}
