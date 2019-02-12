package crd.student.api.service.impl;

import crd.student.api.dao.AdminDao;
import crd.student.api.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crd.student.api.service.IAdminService;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findAdmin(String userName) {
        return adminDao.findAdminByUserName(userName);
    }
}
