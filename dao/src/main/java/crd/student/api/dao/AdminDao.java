package crd.student.api.dao;

import crd.student.api.mapper.AdminMapper;
import crd.student.api.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminDao extends AdminMapper {

    Admin findAdminByUserName(@Param(value = "userName")String userName);
}
