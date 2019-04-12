package com.book.web;

import com.book.domain.Departments;
import com.book.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class DepartmentsController {
    private  DepartmentsService departmentsService;

    @Autowired
    public void setDepartmentsService(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @RequestMapping("/querydepartment.html")
    public ModelAndView queryDepartmentDo(HttpServletRequest request, String searchWord){
        boolean exist=departmentsService.matchDepartment(searchWord);
        if (exist){
            ArrayList<Departments> departments = departmentsService.queryDepartment(searchWord);
            ModelAndView modelAndView = new ModelAndView("admin_departments");
            modelAndView.addObject("departments",departments);
            return modelAndView;
        }
        else{
            return new ModelAndView("admin_departments","error","没有匹配的实验室");
        }
    }

    @RequestMapping("/alldepartments.html")
    public ModelAndView allDepartment(){
        ArrayList<Departments> departments=departmentsService.getAllDepartment();
        ModelAndView modelAndView=new ModelAndView("admin_departments");
        modelAndView.addObject("departments",departments);
        return modelAndView;
    }

    @RequestMapping("/deletedepartment.html")
    public String deleteDepartment(HttpServletRequest request,RedirectAttributes redirectAttributes){
        int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        int res=departmentsService.deleteDepartment(departmentID);

        if (res==1){
            redirectAttributes.addFlashAttribute("succ", "院系删除成功！");
            return "redirect:/alldepartments.html";
        }else {
            redirectAttributes.addFlashAttribute("error", "院系删除失败！");
            return "redirect:/alldepartments.html";
        }
    }

    @RequestMapping("/departments_add.html")
    public ModelAndView addDepartment(HttpServletRequest request){

        return new ModelAndView("admin_department_add");

    }

    @RequestMapping("/departments_add_do.html")
    public String addDepartmentDo(Departments departments,RedirectAttributes redirectAttributes){
        Departments department=new Departments();
        department.setDepartmentID(departments.getDepartmentID());
        department.setName(departments.getName());


        boolean succ=departmentsService.addDepartment(department);
        if (succ){
            redirectAttributes.addFlashAttribute("succ", "院系添加成功！");
            return "redirect:/alldepartments.html";
        }
        else {
            redirectAttributes.addFlashAttribute("succ", "院系添加失败,重复添加！");
            return "redirect:/alldepartments.html";
        }
    }

    @RequestMapping("/updatedepartment.html")
    public ModelAndView departmentEdit(HttpServletRequest request){
        int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        Departments department=departmentsService.getDepartment(departmentID);
        ModelAndView modelAndView=new ModelAndView("admin_department_edit");
        modelAndView.addObject("detail",department);
        return modelAndView;
    }

    @RequestMapping("/department_edit_do.html")
    public String departmentEditDo(HttpServletRequest request,Departments departments,RedirectAttributes redirectAttributes){
        int departmentID =Integer.parseInt(request.getParameter("departmentID"));
        Departments department=new Departments();
        department.setDepartmentID(departments.getDepartmentID());
        department.setName(departments.getName());


        boolean succ=departmentsService.editDepartment(department);
        if (succ){
            redirectAttributes.addFlashAttribute("succ", "院系修改成功！");
            return "redirect:/alldepartments.html";
        }
        else {
            redirectAttributes.addFlashAttribute("error", "院系修改失败,为防止系号重复只能修改系名称！");
            return "redirect:/alldepartments.html";
        }
    }


    @RequestMapping("/departmentdetail.html")
    public ModelAndView departmentDetail(HttpServletRequest request){
        int departmentID=Integer.parseInt(request.getParameter("departmentID"));
        Departments department = departmentsService.getDepartment(departmentID);
        ModelAndView modelAndView=new ModelAndView("admin_department_detail");
        modelAndView.addObject("detail",department);
        return modelAndView;
    }

}
