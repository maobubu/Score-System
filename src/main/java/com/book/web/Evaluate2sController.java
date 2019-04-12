package com.book.web;

import com.book.domain.Evaluate2s;
import com.book.domain.Admin;
import com.book.service.LoginService;
import com.book.service.Evaluate2sService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class Evaluate2sController {
    private  Evaluate2sService evaluate2sService;
    private LoginService loginService;

    @Autowired
    public void setEvaluate2sService(Evaluate2sService evaluate2sService) {
        this.evaluate2sService = evaluate2sService;
    }
    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/queryevaluate2.html")
    public ModelAndView queryEvaluate2Do(HttpServletRequest request, String searchWord){
        boolean exist=evaluate2sService.matchEvaluate2(searchWord);
        if (exist){
            ArrayList<Evaluate2s> evaluate2s = evaluate2sService.queryEvaluate2(searchWord);
            ModelAndView modelAndView = new ModelAndView("admin_evaluate2s");
            modelAndView.addObject("evaluate2s",evaluate2s);
            return modelAndView;
        }
        else{
            return new ModelAndView("admin_evaluate2s","error","没有匹配的权重");
        }
    }

    @RequestMapping("/allevaluate2s.html")
    public ModelAndView allEvaluate2(){
        ArrayList<Evaluate2s> evaluate2s=evaluate2sService.getAllEvaluate2();
        ModelAndView modelAndView=new ModelAndView("admin_evaluate2s");
        modelAndView.addObject("evaluate2s",evaluate2s);
        return modelAndView;
    }

    @RequestMapping("/editweight.html")
    public String editweight(HttpServletRequest request,RedirectAttributes redirectAttributes){
        Admin admin  = (Admin)request.getSession().getAttribute("admin");
        int adminID=admin.getAdminId();
        int weight =Integer.parseInt(request.getParameter("weight"));
        boolean res=loginService.admineditWeight(adminID,weight);
        admin.setWeight(weight);
        request.getSession().setAttribute("weights",weight);

        if (res){
            redirectAttributes.addFlashAttribute("succ", "权重设定成功！");
            return "redirect:/allevaluate2s.html";
        }else {
            redirectAttributes.addFlashAttribute("error", "权重设定失败！");
            return "redirect:/allevaluate2s.html";
        }
    }

    @RequestMapping("/deleteevaluate2.html")
    public String deleteEvaluate2(HttpServletRequest request,RedirectAttributes redirectAttributes){
        int id =Integer.parseInt(request.getParameter("id"));
        int res=evaluate2sService.deleteEvaluate2(id);

        if (res==1){
            redirectAttributes.addFlashAttribute("succ", "权重删除成功！");
            return "redirect:/allevaluate2s.html";
        }else {
            redirectAttributes.addFlashAttribute("error", "权重删除失败！");
            return "redirect:/allevaluate2s.html";
        }
    }

    @RequestMapping("/evaluate2_add.html")
    public ModelAndView addEvaluate2(HttpServletRequest request){
        return new ModelAndView("admin_evaluate2_add");

    }

    @RequestMapping("/evaluate2_add_do.html")
    public String addEvaluate2Do(Evaluate2s evaluate2s,RedirectAttributes redirectAttributes){
        Evaluate2s evaluate2=new Evaluate2s();
        evaluate2.setCamOpeExperiment(evaluate2s.getCamOpeExperiment());
        evaluate2.setOffCamOpeExperiment(evaluate2s.getOffCamOpeExperiment());
        evaluate2.setTeaEfficiency(evaluate2s.getTeaEfficiency());
        evaluate2.setExpTeaProject(evaluate2s.getExpTeaProject());
        evaluate2.setTeaPaper(evaluate2s.getTeaPaper());
        evaluate2.setExpTeaMaterials(evaluate2s.getExpTeaMaterials());
        evaluate2.setStuAward(evaluate2s.getStuAward());
        evaluate2.setSciResProject(evaluate2s.getSciResProject());
        evaluate2.setResPapers(evaluate2s.getResPapers());
        evaluate2.setSocServices(evaluate2s.getSocServices());
        evaluate2.setUpdOfEquipment(evaluate2s.getUpdOfEquipment());
        evaluate2.setValEquipment(evaluate2s.getValEquipment());
        evaluate2.setStuAveArea(evaluate2s.getStuAveArea());
        evaluate2.setStuAveFund(evaluate2s.getStuAveFund());
        evaluate2.setStuAveTeaExpMatFund(evaluate2s.getStuAveTeaExpMatFund());
        evaluate2.setPerStructure(evaluate2s.getPerStructure());
        evaluate2.setNumOfParWorkers(evaluate2s.getNumOfParWorkers());
        evaluate2.setProAchievements(evaluate2s.getProAchievements());


        boolean succ=evaluate2sService.addEvaluate2(evaluate2);
        if (succ){
            redirectAttributes.addFlashAttribute("succ", "权重添加成功！");
            return "redirect:/allevaluate2s.html";
        }
        else {
            redirectAttributes.addFlashAttribute("succ", "权重添加失败！");
            return "redirect:/allevaluate2s.html";
        }
    }

    @RequestMapping("/updateevaluate2.html")
    public ModelAndView evaluate2Edit(HttpServletRequest request){
        int id =Integer.parseInt(request.getParameter("id"));
        Evaluate2s evaluate2=evaluate2sService.getEvaluate2(id);
        ModelAndView modelAndView=new ModelAndView("admin_evaluate2_edit");
        modelAndView.addObject("detail",evaluate2);
        return modelAndView;
    }

    @RequestMapping("/evaluate2_edit_do.html")
    public String evaluate2EditDo(HttpServletRequest request,Evaluate2s evaluate2s,RedirectAttributes redirectAttributes){
        //int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
        Evaluate2s evaluate2=new Evaluate2s();
        evaluate2.setId(id);
        evaluate2.setCamOpeExperiment(evaluate2s.getCamOpeExperiment());
        evaluate2.setOffCamOpeExperiment(evaluate2s.getOffCamOpeExperiment());
        evaluate2.setTeaEfficiency(evaluate2s.getTeaEfficiency());
        evaluate2.setExpTeaProject(evaluate2s.getExpTeaProject());
        evaluate2.setTeaPaper(evaluate2s.getTeaPaper());
        evaluate2.setExpTeaMaterials(evaluate2s.getExpTeaMaterials());
        evaluate2.setStuAward(evaluate2s.getStuAward());
        evaluate2.setSciResProject(evaluate2s.getSciResProject());
        evaluate2.setResPapers(evaluate2s.getResPapers());
        evaluate2.setSocServices(evaluate2s.getSocServices());
        evaluate2.setUpdOfEquipment(evaluate2s.getUpdOfEquipment());
        evaluate2.setValEquipment(evaluate2s.getValEquipment());
        evaluate2.setStuAveArea(evaluate2s.getStuAveArea());
        evaluate2.setStuAveFund(evaluate2s.getStuAveFund());
        evaluate2.setStuAveTeaExpMatFund(evaluate2s.getStuAveTeaExpMatFund());
        evaluate2.setPerStructure(evaluate2s.getPerStructure());
        evaluate2.setNumOfParWorkers(evaluate2s.getNumOfParWorkers());
        evaluate2.setProAchievements(evaluate2s.getProAchievements());


        boolean succ=evaluate2sService.editEvaluate2(evaluate2);
        if (succ){
            redirectAttributes.addFlashAttribute("succ", "权重修改成功！");
            return "redirect:/allevaluate2s.html";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "权重修改失败！");
            return "redirect:/allevaluate2s.html";
        }
    }


    @RequestMapping("/evaluate2detail.html")
    public ModelAndView evaluate2Detail(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        Evaluate2s evaluate2 = evaluate2sService.getEvaluate2(id);
        ModelAndView modelAndView=new ModelAndView("admin_evaluate2_detail");
        modelAndView.addObject("detail",evaluate2);
        return modelAndView;
    }

}
