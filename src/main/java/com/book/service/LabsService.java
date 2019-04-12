package com.book.service;

import com.book.dao.LabsDao;
import com.book.domain.Labs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LabsService {
    private LabsDao labsDao;

    @Autowired
    public void setLabsDao(LabsDao labsDao) {
        this.labsDao = labsDao;
    }

    public ArrayList<Labs> queryLab(String searchWord){
        return  labsDao.queryLab(searchWord);
    }

    public ArrayList<Labs> getAllLab(){
        return labsDao.getAllLab();
    }

    public int deleteLab(int departmentID,int id){
        return labsDao.deleteLab(departmentID, id);
    }

    public boolean matchLab(String searchWord){
        return labsDao.matchLab(searchWord)>0;
    }

    public boolean addLab(Labs lab){
        return labsDao.addLab(lab)>0;
    }

    public Labs getLab(int departmentID, int id){
        Labs lab=labsDao.getLab(departmentID,id);
        return lab;
    }
    public boolean editLab(Labs lab){
        return labsDao.editLab(lab)>0;
    }

}
