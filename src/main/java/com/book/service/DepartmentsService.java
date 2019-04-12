package com.book.service;

import com.book.dao.DepartmentsDao;
import com.book.domain.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentsService {
    private DepartmentsDao departmentsDao;

    @Autowired
    public void setDepartmentsDao(DepartmentsDao departmentsDao) {
        this.departmentsDao = departmentsDao;
    }

    public ArrayList<Departments> queryDepartment(String searchWord){
        return  departmentsDao.queryDepartment(searchWord);
    }

    public ArrayList<Departments> getAllDepartment(){
        return departmentsDao.getAllDepartment();
    }

    public int deleteDepartment(int departmentID){
        return departmentsDao.deleteDepartment(departmentID);
    }

    public boolean matchDepartment(String searchWord){
        return departmentsDao.matchDepartment(searchWord)>0;
    }

    public boolean addDepartment(Departments department){
        if(departmentsDao.matchDepartment(Integer.toString(department.getDepartmentID()))>0){
            return false;
        }
        return departmentsDao.addDepartment(department)>0;
    }

    public Departments getDepartment(int departmentID){
        Departments department=departmentsDao.getDepartment(departmentID);
        return department;
    }
    public boolean editDepartment(Departments department){
        if(departmentsDao.matchDepartment(department.getName())>0){
            return false;
        }
        return departmentsDao.editDepartment(department)>0;
    }

}
