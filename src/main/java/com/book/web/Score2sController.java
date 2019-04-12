package com.book.web;

import com.book.domain.Score2s;
import com.book.domain.Evaluate2s;
import com.book.domain.Admin;
import com.book.service.Evaluate2sService;
import com.book.service.Score2sService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

@Controller
public class Score2sController {
    private  Score2sService score2sService;
    private Evaluate2sService evaluate2sService;

    @Autowired
    public void setScore2sService(Score2sService score2sService) {
        this.score2sService = score2sService;
    }

     @Autowired
    public void setEvaluate2sService(Evaluate2sService evaluate2sService) {
        this.evaluate2sService = evaluate2sService;
    }

    @RequestMapping("/queryscore2.html")
    public ModelAndView queryScore2Do(HttpServletRequest request, String searchWord){
        boolean exist=score2sService.matchScore2(searchWord);
        if (exist){
            ArrayList<Score2s> score2s = score2sService.queryScore2(searchWord);
            ModelAndView modelAndView = new ModelAndView("admin_main");
            modelAndView.addObject("score2s",score2s);
            return modelAndView;
        }
        else{
            return new ModelAndView("admin_main","error","没有匹配的权重");
        }
    }
    // This is used to calculate the score
    @RequestMapping("/admin_main.html")
    public ModelAndView allScore2(HttpServletRequest request){
        ArrayList<Score2s> score2s=score2sService.getAllScore2();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Evaluate2s evaluate2 = evaluate2sService.getEvaluate2(admin.getWeight());
        //get the weight based on the given id.
        //ArrayList<Float> totals = new ArrayList<>();
        for(Score2s a:score2s){
        float score= a.getCamOpeExperiment()*evaluate2.getCamOpeExperiment()+
        a.getOffCamOpeExperiment()*evaluate2.getOffCamOpeExperiment()+
        a.getTeaEfficiency()*evaluate2.getTeaEfficiency()+
        a.getExpTeaProject()*evaluate2.getExpTeaProject()+
        a.getTeaPaper()*evaluate2.getTeaPaper()+
        a.getExpTeaMaterials()*evaluate2.getExpTeaMaterials()+
        a.getStuAward()*evaluate2.getStuAward()+
        a.getSciResProject()*evaluate2.getSciResProject()+
        a.getSocServices()*evaluate2.getSocServices()+
        a.getResPapers()*evaluate2.getResPapers()+
        a.getUpdOfEquipment()*evaluate2.getUpdOfEquipment()+
        a.getValEquipment()*evaluate2.getValEquipment()+
        a.getStuAveArea()*evaluate2.getStuAveArea()+
        a.getStuAveFund()*evaluate2.getStuAveFund()+
        a.getStuAveTeaExpMatFund()*evaluate2.getStuAveTeaExpMatFund()+
        a.getPerStructure()*evaluate2.getPerStructure()+
        a.getNumOfParWorkers()*evaluate2.getNumOfParWorkers()+
        a.getProAchievements()*evaluate2.getProAchievements();
        a.setTotal(score);
        //totals.add(score);
        }
        ModelAndView modelAndView=new ModelAndView("admin_main");
        modelAndView.addObject("score2s",score2s);
        //modelAndView.addObject("totals",totals);
        return modelAndView;
    }


    @RequestMapping("/score2detail.html")
    public ModelAndView score2Detail(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        Score2s score2 = score2sService.getScore2(id);
        ModelAndView modelAndView=new ModelAndView("admin_score2_detail");
        modelAndView.addObject("detail",score2);
        return modelAndView;
    }

}
