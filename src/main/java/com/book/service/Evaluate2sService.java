package com.book.service;

import com.book.dao.Evaluate2sDao;
import com.book.domain.Evaluate2s;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Evaluate2sService {
    private Evaluate2sDao evaluate2sDao;

    @Autowired
    public void setEvaluate2sDao(Evaluate2sDao evaluate2sDao) {
        this.evaluate2sDao = evaluate2sDao;
    }

    public ArrayList<Evaluate2s> queryEvaluate2(String searchWord){
        return  evaluate2sDao.queryEvaluate2(searchWord);
    }

    public ArrayList<Evaluate2s> getAllEvaluate2(){
        return evaluate2sDao.getAllEvaluate2();
    }

    public int deleteEvaluate2(int id){
        return evaluate2sDao.deleteEvaluate2(id);
    }

    public boolean matchEvaluate2(String searchWord){
        return evaluate2sDao.matchEvaluate2(searchWord)>0;
    }

    public boolean addEvaluate2(Evaluate2s evaluate){
        return evaluate2sDao.addEvaluate2(evaluate)>0;
    }

    public Evaluate2s getEvaluate2(int id){
        Evaluate2s evaluate=evaluate2sDao.getEvaluate2(id);
        return evaluate;
    }
    public boolean editEvaluate2(Evaluate2s evaluate){
        return evaluate2sDao.editEvaluate2(evaluate)>0;
    }

}
