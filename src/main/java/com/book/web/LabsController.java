package com.book.web;

import com.book.domain.Labs;
import com.book.service.LabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class LabsController {
    private  LabsService labsService;

    @Autowired
    public void setLabsService(LabsService labsService) {
        this.labsService = labsService;
    }

    @RequestMapping("/querylab.html")
    public ModelAndView queryLabDo(HttpServletRequest request, String searchWord){
        boolean exist=labsService.matchLab(searchWord);
        if (exist){
            ArrayList<Labs> labs = labsService.queryLab(searchWord);
            ModelAndView modelAndView = new ModelAndView("admin_labs");
            modelAndView.addObject("labs",labs);
            return modelAndView;
        }
        else{
            return new ModelAndView("admin_labs","error","没有匹配的实验室");
        }
    }

    @RequestMapping("/alllabs.html")
    public ModelAndView allLab(){
        ArrayList<Labs> labs=labsService.getAllLab();
        ModelAndView modelAndView=new ModelAndView("admin_labs");
        modelAndView.addObject("labs",labs);
        return modelAndView;
    }

    @RequestMapping("/deletelab.html")
    public String deleteLab(HttpServletRequest request,RedirectAttributes redirectAttributes){
        int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
        int res=labsService.deleteLab(departmentID,id);

        if (res==1){
            redirectAttributes.addFlashAttribute("succ", "实验室删除成功！");
            return "redirect:/alllabs.html";
        }else {
            redirectAttributes.addFlashAttribute("error", "实验室删除失败！");
            return "redirect:/alllabs.html";
        }
    }

    @RequestMapping("/labs_add.html")
    public ModelAndView addLab(HttpServletRequest request){

        return new ModelAndView("admin_lab_add");

    }

    @RequestMapping("/labs_add_do.html")
    public String addLabDo(Labs labs,RedirectAttributes redirectAttributes){
        Labs lab=new Labs();
        lab.setDepartmentID(labs.getDepartmentID());
        lab.setName(labs.getName());


        boolean succ=labsService.addLab(lab);
        if (succ){
            redirectAttributes.addFlashAttribute("succ", "实验室添加成功！");
            return "redirect:/alllabs.html";
        }
        else {
            redirectAttributes.addFlashAttribute("succ", "实验室添加失败！");
            return "redirect:/alllabs.html";
        }
    }

    @RequestMapping("/updatelab.html")
    public ModelAndView labEdit(HttpServletRequest request){
        int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
        Labs lab=labsService.getLab(departmentID,id);
        ModelAndView modelAndView=new ModelAndView("admin_lab_edit");
        modelAndView.addObject("detail",lab);
        return modelAndView;
    }

    @RequestMapping("/lab_edit_do.html")
    public String labEditDo(HttpServletRequest request,Labs labs,RedirectAttributes redirectAttributes){
        //int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int id =Integer.parseInt(request.getParameter("id"));
        Labs lab=new Labs();
        lab.setDepartmentID(labs.getDepartmentID());
        lab.setName(labs.getName());
        lab.setId(id);


        boolean succ=labsService.editLab(lab);
        if (succ){
            redirectAttributes.addFlashAttribute("succ", "实验室修改成功！");
            return "redirect:/alllabs.html";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "实验室修改失败！");
            return "redirect:/alllabs.html";
        }
    }


    @RequestMapping("/labdetail.html")
    public ModelAndView labDetail(HttpServletRequest request){
        int departmentID=Integer.parseInt(request.getParameter("departmentID"));
        int id=Integer.parseInt(request.getParameter("id"));
        Labs lab = labsService.getLab(departmentID,id);
        ModelAndView modelAndView=new ModelAndView("admin_lab_detail");
        modelAndView.addObject("detail",lab);
        return modelAndView;
    }

}
