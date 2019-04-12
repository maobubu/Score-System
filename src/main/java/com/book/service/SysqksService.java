package com.book.service;

import com.book.dao.SysqksDao;
import com.book.domain.Sysqks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class SysqksService {
    private SysqksDao sysqksDao;

    @Autowired
    public void setSysqksDao(SysqksDao sysqksDao) {
        this.sysqksDao = sysqksDao;
    }

    public ArrayList<Sysqks> querySysqk(String searchWord){
        return  sysqksDao.querySysqk(searchWord);
    }

    public ArrayList<Sysqks> getAllSysqk(){
        return sysqksDao.getAllSysqk();
    }

    public int deleteSysqk(int id){

        return sysqksDao.deleteSysqk(id);
    }

    public boolean matchSysqk(String searchWord){
        return sysqksDao.matchSysqk(searchWord)>0;
    }

    public boolean addSysqk(Sysqks sysqk){
        return sysqksDao.addSysqk(sysqk)>0;
    }

    public Sysqks getSysqk(int id){

        Sysqks sysqk=sysqksDao.getSysqk(id);

        return sysqk;
    }
    public boolean editSysqk(Sysqks sysqk){
        return sysqksDao.editSysqk(sysqk)>0;
    }

}

