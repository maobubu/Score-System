package com.book.domain;

import java.io.Serializable;

public class Sysqks implements Serializable {
    private int id;
  private String term_year;
  private int lab_id;
  private float teacher_award_nation;
  private float teacher_award_provincial;
  private float teacher_award_patent;
  private float student_award;
  private float teaching_paper_3retrieval;
  private float scientific_research_paper_3retrieval;
  private float teaching_paper_core_journal;
  private float scientific_research_paper_core_journal;
  private int paper_textbook;
  private float scientific_research_project_provincial;
  private float scientific_research_project_other;
  private float social_service_num;
  private float research_project_provincial;
  private float research_project_other;
  private int open_experient_number_campus;
  private int open_experient_number_Outcampus;
  private int open_experient_hour_campus;
  private int open_experient_hour_Outcampus;
  private String using_area;
  private float teaching_utilization;
  private String teaching_experiment_project;
  private String new_equipment;
  private float val_equipment;
  private String personal_structure;
  private int award_fullTime;
  private float rate_partTime;
  private float exper_teaching_found;
  private float teaching_exper_found;

    // Setters
    public void setLab_id(int lab_id) {
        this.lab_id = lab_id;
    }

    public void setVal_equipment(float val_equipment) {
        this.val_equipment = val_equipment;
    }

    public void setPaper_textbook(int paper_textbook) {
        this.paper_textbook = paper_textbook;
    }

    public void setOpen_experient_hour_campus(int open_experient_hour_campus) {
        this.open_experient_hour_campus = open_experient_hour_campus;
    }

    public void setNew_equipment(String new_equipment) {
        this.new_equipment = new_equipment;
    }

    public void setScientific_research_paper_3retrieval(float scientific_research_paper_3retrieval) {
        this.scientific_research_paper_3retrieval = scientific_research_paper_3retrieval;
    }

    public void setOpen_experient_number_campus(int open_experient_number_campus) {
        this.open_experient_number_campus = open_experient_number_campus;
    }

    public void setOpen_experient_number_Outcampus(int open_experient_number_Outcampus) {
        this.open_experient_number_Outcampus = open_experient_number_Outcampus;
    }

    public void setAward_fullTime(int award_fullTime) {
        this.award_fullTime = award_fullTime;
    }

    public void setOpen_experient_hour_Outcampus(int open_experient_hour_Outcampus) {
        this.open_experient_hour_Outcampus = open_experient_hour_Outcampus;
    }

    public void setResearch_project_other(float research_project_other) {
        this.research_project_other = research_project_other;
    }

    public void setResearch_project_provincial(float research_project_provincial) {
        this.research_project_provincial = research_project_provincial;
    }

    public void setScientific_research_paper_core_journal(float scientific_research_paper_core_journal) {
        this.scientific_research_paper_core_journal = scientific_research_paper_core_journal;
    }

    public void setScientific_research_project_other(float scientific_research_project_other) {
        this.scientific_research_project_other = scientific_research_project_other;
    }

    public void setScientific_research_project_provincial(float scientific_research_project_provincial) {
        this.scientific_research_project_provincial = scientific_research_project_provincial;
    }

    public void setSocial_service_num(float social_service_num) {
        this.social_service_num = social_service_num;
    }

    public void setStudent_award(float student_award) {
        this.student_award = student_award;
    }

    public void setTeacher_award_nation(float teacher_award_nation) {
        this.teacher_award_nation = teacher_award_nation;
    }

    public void setTeacher_award_patent(float teacher_award_patent) {
        this.teacher_award_patent = teacher_award_patent;
    }

    public void setTeacher_award_provincial(float teacher_award_provincial) {
        this.teacher_award_provincial = teacher_award_provincial;
    }

    public void setTeaching_paper_3retrieval(float teaching_paper_3retrieval) {
        this.teaching_paper_3retrieval = teaching_paper_3retrieval;
    }

    public void setTeaching_experiment_project(String teaching_experiment_project) {
        this.teaching_experiment_project = teaching_experiment_project;
    }

    public void setPersonal_structure(String personal_structure) {
        this.personal_structure = personal_structure;
    }

    public void setTeaching_paper_core_journal(float teaching_paper_core_journal) {
        this.teaching_paper_core_journal = teaching_paper_core_journal;
    }

    public void setTeaching_utilization(float teaching_utilization) {
        this.teaching_utilization = teaching_utilization;
    }

    public void setExper_teaching_found(float exper_teaching_found) {
        this.exper_teaching_found = exper_teaching_found;
    }

    public void setRate_partTime(float rate_partTime) {
        this.rate_partTime = rate_partTime;
    }

    public void setTerm_year(String term_year) {
        this.term_year = term_year;
    }

    public void setUsing_area(String using_area) {
        this.using_area = using_area;
    }

    public void setTeaching_exper_found(float teaching_exper_found) {
        this.teaching_exper_found = teaching_exper_found;
    }

    // Getters

    public float getResearch_project_other() {
        return research_project_other;
    }

    public float getResearch_project_provincial() {
        return research_project_provincial;
    }

    public float getScientific_research_paper_core_journal() {
        return scientific_research_paper_core_journal;
    }

    public float getScientific_research_paper_3retrieval() {
        return scientific_research_paper_3retrieval;
    }

    public float getScientific_research_project_other() {
        return scientific_research_project_other;
    }

    public float getScientific_research_project_provincial() {
        return scientific_research_project_provincial;
    }

    public float getStudent_award() {
        return student_award;
    }

    public float getSocial_service_num() {
        return social_service_num;
    }

    public float getTeacher_award_nation() {
        return teacher_award_nation;
    }

    public float getTeacher_award_patent() {
        return teacher_award_patent;
    }

    public float getTeacher_award_provincial() {
        return teacher_award_provincial;
    }

    public float getTeaching_paper_3retrieval() {
        return teaching_paper_3retrieval;
    }

    public float getTeaching_paper_core_journal() {
        return teaching_paper_core_journal;
    }

    public float getTeaching_utilization() {
        return teaching_utilization;
    }

    public int getLab_id() {
        return lab_id;
    }

    public int getOpen_experient_hour_campus() {
        return open_experient_hour_campus;
    }

    public float getRate_partTime() {
        return rate_partTime;
    }

    public int getOpen_experient_hour_Outcampus() {
        return open_experient_hour_Outcampus;
    }

    public int getPaper_textbook() {
        return paper_textbook;
    }

    public String getTerm_year() {
        return term_year;
    }

    public float getVal_equipment() {
        return val_equipment;
    }

    public float getExper_teaching_found() {
        return exper_teaching_found;
    }

    public float getTeaching_exper_found() {
        return teaching_exper_found;
    }

    public int getOpen_experient_number_campus() {
        return open_experient_number_campus;
    }

    public int getAward_fullTime() {
        return award_fullTime;
    }

    public int getOpen_experient_number_Outcampus() {
        return open_experient_number_Outcampus;
    }

    public String getNew_equipment() {
        return new_equipment;
    }

    public String getPersonal_structure() {
        return personal_structure;
    }

    public String getTeaching_experiment_project() {
        return teaching_experiment_project;
    }

    public String getUsing_area() {
        return using_area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
