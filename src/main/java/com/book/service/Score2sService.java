package com.book.service;

import com.book.dao.Score2sDao;
import com.book.domain.Score2s;
import com.book.domain.Sysqks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class Score2sService {
    private Score2sDao score2sDao;

    @Autowired
    public void setScore2sDao(Score2sDao score2sDao) {
        this.score2sDao = score2sDao;
    }

    public ArrayList<Score2s> queryScore2(String searchWord){
        return  score2sDao.queryScore2(searchWord);
    }

    public ArrayList<Score2s> getAllScore2(){
        return score2sDao.getAllScore2();
    }

    public int deleteScore2(int id){
        return score2sDao.deleteScore2(id);
    }

    public boolean matchScore2(String searchWord){
        return score2sDao.matchScore2(searchWord)>0;
    }

    public boolean addScore2(){
        score2sDao.addScore2(); // doesn't have return value
        return true;// return true for default
    }

    public Score2s getScore2(int id){
        Score2s score2 =score2sDao.getScore2(id);
        return score2;
    }
    public boolean editScore2(Sysqks sysqks){
        return score2sDao.editScore2(sysqks)>0;
    }

}
