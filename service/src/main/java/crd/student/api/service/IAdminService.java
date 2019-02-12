package crd.student.api.service;

import crd.student.api.model.Admin;

public interface IAdminService{

    Admin findAdmin(String userName);
}
