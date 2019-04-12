package com.book.web;

import com.book.domain.Score2s;
import com.book.domain.Sysqks;
import com.book.service.SysqksService;
import com.book.service.Score2sService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class SysqksController {
    private  SysqksService sysqksService;
    private  Score2sService score2sService;

    @Autowired
    public void setSysqksService(SysqksService sysqksService) {
        this.sysqksService = sysqksService;
    }

    @Autowired
    public void setScore2sService(Score2sService score2sService) {
        this.score2sService = score2sService;
    }

    @RequestMapping("/querysysqk.html")
    public ModelAndView querySysqkDo(HttpServletRequest request, String searchWord){
        boolean exist=sysqksService.matchSysqk(searchWord);
        if (exist){
            ArrayList<Sysqks> sysqks = sysqksService.querySysqk(searchWord);
            ModelAndView modelAndView = new ModelAndView("admin_sysqks");
            modelAndView.addObject("sysqks",sysqks);
            return modelAndView;
        }
        else{
            return new ModelAndView("admin_sysqks","error","没有匹配的实验室");
        }
    }

    @RequestMapping("/allsysqks.html")
    public ModelAndView allSysqk(){
        ArrayList<Sysqks> sysqks=sysqksService.getAllSysqk();
        ModelAndView modelAndView=new ModelAndView("admin_sysqks");
        modelAndView.addObject("sysqks",sysqks);
        return modelAndView;
    }

    @RequestMapping("/deletesysqk.html")
    public String deleteSysqk(HttpServletRequest request,RedirectAttributes redirectAttributes){
        //int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
                System.out.println("id :"+id);

        int res=sysqksService.deleteSysqk(id);
        int res_score2 = score2sService.deleteScore2(id);

        if (res==1){
            redirectAttributes.addFlashAttribute("succ", "实验室情况删除成功！");
            return "redirect:/allsysqks.html";
        }else {
            redirectAttributes.addFlashAttribute("error", "实验室情况删除失败！");
            return "redirect:/allsysqks.html";
        }
    }

    @RequestMapping("/sysqks_add.html")
    public ModelAndView addSysqk(HttpServletRequest request){

        return new ModelAndView("admin_sysqk_add");

    }

    @RequestMapping("/sysqks_add_do.html")
    public String addSysqkDo(Sysqks sysqks,RedirectAttributes redirectAttributes){
        Sysqks sysqk=new Sysqks();
        sysqk.setLab_id(sysqks.getLab_id());
        sysqk.setVal_equipment(sysqks.getVal_equipment());
        sysqk.setPaper_textbook(sysqks.getPaper_textbook());
        sysqk.setOpen_experient_hour_campus(sysqks.getOpen_experient_hour_campus());
        sysqk.setNew_equipment(sysqks.getNew_equipment());
        sysqk.setScientific_research_paper_3retrieval(sysqks.getScientific_research_paper_3retrieval());
        sysqk.setOpen_experient_number_campus(sysqks.getOpen_experient_number_campus());
        sysqk.setOpen_experient_number_Outcampus(sysqks.getOpen_experient_number_Outcampus());
        sysqk.setAward_fullTime(sysqks.getAward_fullTime());
        sysqk.setOpen_experient_hour_Outcampus(sysqks.getOpen_experient_hour_Outcampus());
        sysqk.setResearch_project_other(sysqks.getResearch_project_other());
        sysqk.setResearch_project_provincial(sysqks.getResearch_project_provincial());
        sysqk.setScientific_research_paper_core_journal(sysqks.getScientific_research_paper_core_journal());
        sysqk.setScientific_research_project_other(sysqks.getScientific_research_project_other());
        sysqk.setScientific_research_project_provincial(sysqks.getScientific_research_project_provincial());
        sysqk.setSocial_service_num(sysqks.getSocial_service_num());
        sysqk.setStudent_award(sysqks.getStudent_award());
        sysqk.setTeacher_award_nation(sysqks.getTeacher_award_nation());
        sysqk.setTeacher_award_patent(sysqks.getTeacher_award_patent());
        sysqk.setTeacher_award_provincial(sysqks.getTeacher_award_provincial());
        sysqk.setTeaching_paper_3retrieval(sysqks.getTeaching_paper_3retrieval());
        sysqk.setTeaching_experiment_project(sysqks.getTeaching_experiment_project());
        sysqk.setPersonal_structure(sysqks.getPersonal_structure());
        sysqk.setTeaching_paper_core_journal(sysqks.getTeaching_paper_core_journal());
        sysqk.setTeaching_utilization(sysqks.getTeaching_utilization());
        sysqk.setExper_teaching_found(sysqks.getExper_teaching_found());
        sysqk.setRate_partTime(sysqks.getRate_partTime());
        sysqk.setTerm_year(sysqks.getTerm_year());
        sysqk.setUsing_area(sysqks.getUsing_area());
        sysqk.setTeaching_exper_found(sysqks.getTeaching_exper_found());


        boolean succ=sysqksService.addSysqk(sysqk);
        boolean succ_score2 = score2sService.addScore2();
        if (succ&&succ_score2){
            redirectAttributes.addFlashAttribute("succ", "实验室情况添加成功！");
            return "redirect:/allsysqks.html";
        }
        else {
            redirectAttributes.addFlashAttribute("succ", "实验室情况添加失败！");
            return "redirect:/allsysqks.html";
        }
    }

    @RequestMapping("/updatesysqk.html")
    public ModelAndView sysqkEdit(HttpServletRequest request){
        //int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
                System.out.println("id :"+id);

        Sysqks sysqk=sysqksService.getSysqk(id);
        ModelAndView modelAndView=new ModelAndView("admin_sysqk_edit");
        modelAndView.addObject("detail",sysqk);
        return modelAndView;
    }

    @RequestMapping("/sysqk_edit_do.html")
    public String sysqkEditDo(HttpServletRequest request,Sysqks sysqks,RedirectAttributes redirectAttributes){
        //int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
        Sysqks sysqk=new Sysqks();
        sysqk.setId(id);
        sysqk.setLab_id(sysqks.getLab_id());
        sysqk.setVal_equipment(sysqks.getVal_equipment());
        sysqk.setPaper_textbook(sysqks.getPaper_textbook());
        sysqk.setOpen_experient_hour_campus(sysqks.getOpen_experient_hour_campus());
        sysqk.setNew_equipment(sysqks.getNew_equipment());
        sysqk.setScientific_research_paper_3retrieval(sysqks.getScientific_research_paper_3retrieval());
        sysqk.setOpen_experient_number_campus(sysqks.getOpen_experient_number_campus());
        sysqk.setOpen_experient_number_Outcampus(sysqks.getOpen_experient_number_Outcampus());
        sysqk.setAward_fullTime(sysqks.getAward_fullTime());
        sysqk.setOpen_experient_hour_Outcampus(sysqks.getOpen_experient_hour_Outcampus());
        sysqk.setResearch_project_other(sysqks.getResearch_project_other());
        sysqk.setResearch_project_provincial(sysqks.getResearch_project_provincial());
        sysqk.setScientific_research_paper_core_journal(sysqks.getScientific_research_paper_core_journal());
        sysqk.setScientific_research_project_other(sysqks.getScientific_research_project_other());
        sysqk.setScientific_research_project_provincial(sysqks.getScientific_research_project_provincial());
        sysqk.setSocial_service_num(sysqks.getSocial_service_num());
        sysqk.setStudent_award(sysqks.getStudent_award());
        sysqk.setTeacher_award_nation(sysqks.getTeacher_award_nation());
        sysqk.setTeacher_award_patent(sysqks.getTeacher_award_patent());
        sysqk.setTeacher_award_provincial(sysqks.getTeacher_award_provincial());
        sysqk.setTeaching_paper_3retrieval(sysqks.getTeaching_paper_3retrieval());
        sysqk.setTeaching_experiment_project(sysqks.getTeaching_experiment_project());
        sysqk.setPersonal_structure(sysqks.getPersonal_structure());
        sysqk.setTeaching_paper_core_journal(sysqks.getTeaching_paper_core_journal());
        sysqk.setTeaching_utilization(sysqks.getTeaching_utilization());
        sysqk.setExper_teaching_found(sysqks.getExper_teaching_found());
        sysqk.setRate_partTime(sysqks.getRate_partTime());
        sysqk.setTerm_year(sysqks.getTerm_year());
        sysqk.setUsing_area(sysqks.getUsing_area());
        sysqk.setTeaching_exper_found(sysqks.getTeaching_exper_found());


        boolean succ=sysqksService.editSysqk(sysqk);
        boolean succ_score2 = score2sService.editScore2(sysqk);

        if (succ && succ_score2){
            redirectAttributes.addFlashAttribute("succ", "实验室情况修改成功！");
            return "redirect:/allsysqks.html";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "实验室情况修改失败！");
            return "redirect:/allsysqks.html";
        }
    }


    @RequestMapping("/sysqkdetail.html")
    public ModelAndView sysqkDetail(HttpServletRequest request){
        //int departmentID = Integer.parseInt(request.getParameter("departmentID"));
        int id=Integer.parseInt(request.getParameter("id"));
        Sysqks sysqk = sysqksService.getSysqk(id);
        System.out.println("id :"+id);
        ModelAndView modelAndView=new ModelAndView("admin_sysqk_detail");
        modelAndView.addObject("detail",sysqk);
        return modelAndView;
    }

}
