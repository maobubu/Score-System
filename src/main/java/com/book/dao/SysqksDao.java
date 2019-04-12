package com.book.dao;


import com.book.domain.Sysqks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class SysqksDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String ADD_LABS_SQL="INSERT INTO sysqks VALUES(NULL ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    // This is called whenever ADD_LABS_SQL are called
    private final static String INSERT_TO_SCORE2_TABLE ="insert into score2s(score2s.id,score2s.term_year,score2s.lab_id,camOpeExperiment,offCamOpeExperiment,teaEfficiency,expTeaProject,teaPaper,expTeaMaterials,stuAward,\n" +
            "sciResProject,resPapers,socServices,updOfEquipment,valEquipment,stuAveArea,stuAveFund,stuAveTeaExpMatFund,perStructure,numOfParWorkers,proAchievements)\n" +
            "select sysqks.id as '序号', sysqks.term_year as '学年',sysqks.lab_id as '实验室ID',(CASE WHEN (((open_experient_number_campus BETWEEN 500 and 1000) and (open_experient_hour_campus BETWEEN 30 and 50))\n" +
            "      or ((open_experient_number_campus>300) and (open_experient_hour_campus BETWEEN 30 and 50)) or ((open_experient_number_campus BETWEEN 500 and 1000) and (open_experient_hour_campus>30)))then 60\n" +
            "    WHEN (((open_experient_number_campus BETWEEN 1001 and 1500) and (open_experient_hour_campus BETWEEN 51 and 70))\n" +
            "      or ((open_experient_number_campus>1000) and (open_experient_hour_campus BETWEEN 51 and 70)) or ((open_experient_number_campus BETWEEN 1001 and 1500) and (open_experient_hour_campus>50)))then 80\n" +
            "    WHEN (open_experient_number_campus>1500 and open_experient_hour_campus>70) then 100\n" +
            "    else 0 END) as '校内实验分数',\n" +
            " (CASE WHEN (((open_experient_number_Outcampus BETWEEN 20 and 50) and (open_experient_hour_Outcampus BETWEEN 5 and 10))\n" +
            "      or ((open_experient_number_Outcampus>20) and (open_experient_hour_Outcampus BETWEEN 5 and 10)) or ((open_experient_number_Outcampus BETWEEN 20 and 50) and (open_experient_hour_Outcampus>10)))then 60\n" +
            "    WHEN (((open_experient_number_Outcampus BETWEEN 51 and 100) and (open_experient_hour_Outcampus BETWEEN 11 and 20))\n" +
            "      or ((open_experient_number_Outcampus>50) and (open_experient_hour_Outcampus BETWEEN 11 and 20)) or ((open_experient_number_Outcampus BETWEEN 51 and 100) and (open_experient_hour_Outcampus>10)))then 80\n" +
            "    WHEN (open_experient_number_Outcampus>100 and open_experient_hour_Outcampus>20) then 100\n" +
            "    else 0 END) as '校外实验分数',\n" +
            " (CASE WHEN (((teaching_paper_3retrieval BETWEEN 1 and 5) and (teaching_paper_core_journal BETWEEN 1 and 5))\n" +
            "      or ((teaching_paper_3retrieval>1) and (teaching_paper_core_journal BETWEEN 5 and 10)) or ((teaching_paper_3retrieval BETWEEN 20 and 50) and (teaching_paper_core_journal>1)))then 60\n" +
            "    WHEN (((teaching_paper_3retrieval BETWEEN 5 and 10) and (teaching_paper_core_journal BETWEEN 5 and 10))\n" +
            "      or ((teaching_paper_3retrieval>5) and (teaching_paper_core_journal BETWEEN 5 and 10)) or ((teaching_paper_3retrieval BETWEEN 5 and 10) and (teaching_paper_core_journal>5)))then 80\n" +
            "    WHEN (teaching_paper_3retrieval>10 and teaching_paper_core_journal>10) then 100\n" +
            "    else 0 END) as '教学论文',\n" +
            " (CASE WHEN teaching_utilization BETWEEN 0.1 and 0.3 then 60\n" +
            "    WHEN teaching_utilization BETWEEN 0.3 and 0.5    then 80\n" +
            "    WHEN teaching_utilization>0.5                    then 100\n" +
            "    else 0 END) as '教学利用率',\n" +
            " (CASE WHEN teaching_experiment_project BETWEEN 30 and 50 then 60\n" +
            "    WHEN teaching_experiment_project BETWEEN 50 and 70    then 80\n" +
            "    WHEN teaching_experiment_project>70                    then 100\n" +
            "    else 0 END) as '教学实验项目',\n" +
            " (CASE WHEN paper_textbook BETWEEN 1 and 50 then 60\n" +
            "    WHEN paper_textbook BETWEEN 50 and 100  then 80\n" +
            "    WHEN paper_textbook>100                 then 100\n" +
            "    else 0 END) as '实验教材',\n" +
            "(CASE WHEN student_award BETWEEN 1 and 5  then 60\n" +
            "      WHEN student_award BETWEEN 5 and 10 then 80\n" +
            "      WHEN student_award>10               then 100\n" +
            "    else 0 END) as '学生获奖',\n" +
            "(CASE WHEN scientific_research_project_provincial BETWEEN 1 and 5  then 60\n" +
            "      WHEN scientific_research_project_provincial BETWEEN 5 and 10 then 80\n" +
            "      WHEN scientific_research_project_provincial>10               then 100\n" +
            "      else 0 END) as '科研项目',\n" +
            "(CASE WHEN (((scientific_research_paper_3retrieval BETWEEN 1 and 5) and (scientific_research_paper_core_journal BETWEEN 1 and 5))\n" +
            "      or ((scientific_research_paper_3retrieval>1) and (scientific_research_paper_core_journal BETWEEN 5 and 10)) or ((scientific_research_paper_3retrieval BETWEEN 20 and 50) and (scientific_research_paper_core_journal>1)))then 60\n" +
            "    WHEN (((scientific_research_paper_3retrieval BETWEEN 5 and 10) and (scientific_research_paper_core_journal BETWEEN 5 and 10))\n" +
            "      or ((scientific_research_paper_3retrieval>5) and (scientific_research_paper_core_journal BETWEEN 5 and 10)) or ((scientific_research_paper_3retrieval BETWEEN 5 and 10) and (scientific_research_paper_core_journal>5)))then 80\n" +
            "    WHEN (scientific_research_paper_3retrieval>10 and scientific_research_paper_core_journal>10) then 100\n" +
            "    else 0 END) as '科研论文',\n" +
            "(CASE WHEN social_service_num BETWEEN 1 and 5  then 60\n" +
            "      WHEN social_service_num BETWEEN 5 and 10 then 80\n" +
            "      WHEN social_service_num>10               then 100\n" +
            "      else 0 END) as '社会服务',\n" +
            "(CASE WHEN (new_equipment) BETWEEN 500 and 1000  then 60\n" +
            "      WHEN (new_equipment) BETWEEN 1000 and 2000   then 80\n" +
            "      WHEN (new_equipment)>2000                   then 100\n" +
            "      else 0 END) as '仪器设备更新情况',\n" +
            "(CASE WHEN (val_equipment) BETWEEN 1 and 2  then 60\n" +
            "      WHEN (val_equipment) BETWEEN 2 and 3   then 80\n" +
            "      WHEN (val_equipment)>3                   then 100\n" +
            "      else 0 END) as '贵重仪器设备',\n" +
            "(CASE WHEN (using_area/open_experient_number_campus) BETWEEN 0.05 and 0.1  then 60\n" +
            "      WHEN (using_area/open_experient_number_campus) BETWEEN 0.1 and 0.5 then 80\n" +
            "      WHEN (using_area/open_experient_number_campus)>0.5               then 100\n" +
            "      else 0 END) as '生均面积',\n" +
            "(CASE WHEN (open_experient_number_campus/exper_teaching_found) BETWEEN 0.05 and 0.1  then 60\n" +
            "      WHEN (open_experient_number_campus/exper_teaching_found) BETWEEN 0.1 and 0.5   then 80\n" +
            "      WHEN (open_experient_number_campus/exper_teaching_found)>0.5                   then 100\n" +
            "      else 0 END) as '生均运行经费',\n" +
            "        (CASE WHEN (open_experient_number_campus/teaching_exper_found) BETWEEN 2000 and 5000  then 60\n" +
            "      WHEN (open_experient_number_campus/teaching_exper_found) BETWEEN 5000 and 1000   then 80\n" +
            "      WHEN (open_experient_number_campus/teaching_exper_found)>10000                   then 100\n" +
            "      else 0 END) as '生均教学实验材料费',\n" +
            "(CASE WHEN personal_structure=0  then 0\n" +
            "      WHEN (personal_structure) BETWEEN 0 and 0.3  then 60\n" +
            "      WHEN (personal_structure) BETWEEN 0.3 and 0.6   then 80\n" +
            "      WHEN (personal_structure)>0.6                   then 100\n" +
            "      else 0 END) as '人员结构',\n" +
            "(CASE WHEN (rate_partTime) <1             then 0\n" +
            "\t\t\tWHEN (rate_partTime) BETWEEN 1 and 2  then 60\n" +
            "      WHEN (rate_partTime) BETWEEN 2 and 3   then 80\n" +
            "      WHEN (rate_partTime)>3                   then 100\n" +
            "      else 0 END) as '兼职人员数',\n" +
            "(CASE WHEN (award_fullTime) <1               then 0\n" +
            "\t    WHEN (award_fullTime) BETWEEN 1 and 2  then 60\n" +
            "      WHEN (award_fullTime) BETWEEN 2 and 3   then 80\n" +
            "      WHEN (award_fullTime)>3                   then 100\n" +
            "      else 0 END) as '专职人员成果'\n" +
            "\n" +
            "from sysqks where id = (select max(id) from sysqks);";
    private final static String DELETE_LABS_SQL="DELETE from sysqks where id = ?";
    private final static String EDIT_LABS_SQL="UPDATE sysqks set term_year = ?, lab_id = ?,teacher_award_nation = ?,teacher_award_provincial = ?,teacher_award_patent = ?,student_award = ?,teaching_paper_3retrieval = ?,scientific_research_paper_3retrieval = ?,teaching_paper_core_journal= ?, scientific_research_paper_core_journal= ?, paper_textbook= ?, scientific_research_project_provincial= ?, scientific_research_project_other= ?, social_service_num= ?, research_project_provincial= ?, research_project_other= ?, open_experient_number_campus= ?, open_experient_number_Outcampus= ?, open_experient_hour_campus= ?, open_experient_hour_Outcampus= ?, using_area= ?, teaching_utilization= ?, teaching_experiment_project= ?, new_equipment= ?, val_equipment= ?, personal_structure= ?, award_fullTime= ?, rate_partTime= ?, exper_teaching_found= ?, teaching_exper_found= ? where id = ?;";
    private final static String GET_LABS_SQL="SELECT * FROM sysqks where id = ?";
    private final static String QUERY_ALL_LABS_SQL="SELECT * FROM sysqks ";
    private final static String QUERY_LABS_SQL="SELECT * FROM sysqks WHERE lab_id like ?";
    //count the number of books
    private final static String MATCH_LABS_SQL="SELECT count(*) FROM sysqks WHERE lab_id like ?";

    public int matchSysqk(String searchWord){
        String swcx="%"+searchWord+"%";
        return jdbcTemplate.queryForObject(MATCH_LABS_SQL,new Object[]{swcx},Integer.class);
    }

    public ArrayList<Sysqks> querySysqk(String sw){
        String swcx="%"+sw+"%";
        System.out.println("query string"+swcx);
        final ArrayList<Sysqks> sysqks=new ArrayList<Sysqks>();
        jdbcTemplate.query(QUERY_LABS_SQL, new Object[]{swcx}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Sysqks sysqk =new Sysqks();
                    sysqk.setId(resultSet.getInt("id"));//Very important
                   sysqk.setLab_id(resultSet.getInt("lab_id"));
                   sysqk.setVal_equipment(resultSet.getFloat("val_equipment"));
                   sysqk.setPaper_textbook(resultSet.getInt("paper_textbook"));
                   sysqk.setOpen_experient_hour_campus(resultSet.getInt("open_experient_hour_campus"));
                   sysqk.setNew_equipment(resultSet.getString("new_equipment"));
                   sysqk.setScientific_research_paper_3retrieval(resultSet.getFloat("scientific_research_paper_3retrieval"));
                   sysqk.setOpen_experient_number_campus(resultSet.getInt("open_experient_number_campus"));
                   sysqk.setOpen_experient_number_Outcampus(resultSet.getInt("open_experient_number_Outcampus"));
                   sysqk.setAward_fullTime(resultSet.getInt("award_fullTime"));
                   sysqk.setOpen_experient_hour_Outcampus(resultSet.getInt("open_experient_hour_Outcampus"));
                   sysqk.setResearch_project_other(resultSet.getFloat("research_project_other"));
                   sysqk.setResearch_project_provincial(resultSet.getFloat("research_project_provincial"));
                   sysqk.setScientific_research_paper_core_journal(resultSet.getFloat("scientific_research_paper_core_journal"));
                   sysqk.setScientific_research_project_other(resultSet.getFloat("scientific_research_project_other"));
                   sysqk.setScientific_research_project_provincial(resultSet.getFloat("scientific_research_project_provincial"));
                   sysqk.setSocial_service_num(resultSet.getFloat("social_service_num"));
                   sysqk.setStudent_award(resultSet.getFloat("student_award"));
                   sysqk.setTeacher_award_nation(resultSet.getFloat("teacher_award_nation"));
                   sysqk.setTeacher_award_patent(resultSet.getFloat("teacher_award_patent"));
                   sysqk.setTeacher_award_provincial(resultSet.getFloat("teacher_award_provincial"));
                   sysqk.setTeaching_paper_3retrieval(resultSet.getFloat("teaching_paper_3retrieval"));
                   sysqk.setTeaching_experiment_project(resultSet.getString("teaching_experiment_project"));
                   sysqk.setPersonal_structure(resultSet.getString("personal_structure"));
                   sysqk.setTeaching_paper_core_journal(resultSet.getFloat("teaching_paper_core_journal"));
                   sysqk.setTeaching_utilization(resultSet.getFloat("teaching_utilization"));
                   sysqk.setExper_teaching_found(resultSet.getFloat("exper_teaching_found"));
                   sysqk.setRate_partTime(resultSet.getFloat("rate_partTime"));
                   sysqk.setTerm_year(resultSet.getString("term_year"));
                   sysqk.setUsing_area(resultSet.getString("using_area"));
                   sysqk.setTeaching_exper_found(resultSet.getFloat("teaching_exper_found"));
                   sysqks.add(sysqk);
                }

            }
        });
        return sysqks;
    }

    public ArrayList<Sysqks> getAllSysqk(){
        final ArrayList<Sysqks> sysqks=new ArrayList<Sysqks>();

        jdbcTemplate.query(QUERY_ALL_LABS_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Sysqks sysqk =new Sysqks();
                    sysqk.setId(resultSet.getInt(("id")));
                    sysqk.setLab_id(resultSet.getInt("lab_id"));
                   sysqk.setVal_equipment(resultSet.getFloat("val_equipment"));
                   sysqk.setPaper_textbook(resultSet.getInt("paper_textbook"));
                   sysqk.setOpen_experient_hour_campus(resultSet.getInt("open_experient_hour_campus"));
                   sysqk.setNew_equipment(resultSet.getString("new_equipment"));
                   sysqk.setScientific_research_paper_3retrieval(resultSet.getFloat("scientific_research_paper_3retrieval"));
                   sysqk.setOpen_experient_number_campus(resultSet.getInt("open_experient_number_campus"));
                   sysqk.setOpen_experient_number_Outcampus(resultSet.getInt("open_experient_number_Outcampus"));
                   sysqk.setAward_fullTime(resultSet.getInt("award_fullTime"));
                   sysqk.setOpen_experient_hour_Outcampus(resultSet.getInt("open_experient_hour_Outcampus"));
                   sysqk.setResearch_project_other(resultSet.getFloat("research_project_other"));
                   sysqk.setResearch_project_provincial(resultSet.getFloat("research_project_provincial"));
                   sysqk.setScientific_research_paper_core_journal(resultSet.getFloat("scientific_research_paper_core_journal"));
                   sysqk.setScientific_research_project_other(resultSet.getFloat("scientific_research_project_other"));
                   sysqk.setScientific_research_project_provincial(resultSet.getFloat("scientific_research_project_provincial"));
                   sysqk.setSocial_service_num(resultSet.getFloat("social_service_num"));
                   sysqk.setStudent_award(resultSet.getFloat("student_award"));
                   sysqk.setTeacher_award_nation(resultSet.getFloat("teacher_award_nation"));
                   sysqk.setTeacher_award_patent(resultSet.getFloat("teacher_award_patent"));
                   sysqk.setTeacher_award_provincial(resultSet.getFloat("teacher_award_provincial"));
                   sysqk.setTeaching_paper_3retrieval(resultSet.getFloat("teaching_paper_3retrieval"));
                   sysqk.setTeaching_experiment_project(resultSet.getString("teaching_experiment_project"));
                   sysqk.setPersonal_structure(resultSet.getString("personal_structure"));
                   sysqk.setTeaching_paper_core_journal(resultSet.getFloat("teaching_paper_core_journal"));
                   sysqk.setTeaching_utilization(resultSet.getFloat("teaching_utilization"));
                   sysqk.setExper_teaching_found(resultSet.getFloat("exper_teaching_found"));
                   sysqk.setRate_partTime(resultSet.getFloat("rate_partTime"));
                   sysqk.setTerm_year(resultSet.getString("term_year"));
                   sysqk.setUsing_area(resultSet.getString("using_area"));
                   sysqk.setTeaching_exper_found(resultSet.getFloat("teaching_exper_found"));

                    sysqks.add(sysqk);
                }
            }
        });
        return sysqks;

    }

    public int deleteSysqk(int id){

        return jdbcTemplate.update(DELETE_LABS_SQL,id);
    }

    public int addSysqk(Sysqks sysqk){
        String term_year = sysqk.getTerm_year();
        int lab_id = sysqk.getLab_id();
        float teacher_award_nation = sysqk.getTeacher_award_nation();
        float teacher_award_provincial = sysqk.getTeacher_award_provincial();
        float teacher_award_patent= sysqk.getTeacher_award_patent();
        float student_award= sysqk.getStudent_award();
        float teaching_paper_3retrieval= sysqk.getTeaching_paper_3retrieval();
        float scientific_research_paper_3retrieval= sysqk.getScientific_research_paper_3retrieval();
        float teaching_paper_core_journal= sysqk.getTeaching_paper_core_journal();
        float scientific_research_paper_core_journal= sysqk.getScientific_research_paper_core_journal();
        int paper_textbook= sysqk.getPaper_textbook();
        float scientific_research_project_provincial= sysqk.getScientific_research_project_provincial();
        float scientific_research_project_other= sysqk.getScientific_research_project_other();
        float social_service_num= sysqk.getSocial_service_num();
        float research_project_provincial= sysqk.getResearch_project_provincial();
        float research_project_other= sysqk.getResearch_project_other();
        int open_experient_number_campus= sysqk.getOpen_experient_number_campus();
        int open_experient_number_Outcampus= sysqk.getOpen_experient_number_Outcampus();
        int open_experient_hour_campus= sysqk.getOpen_experient_hour_campus();
        int open_experient_hour_Outcampus= sysqk.getOpen_experient_hour_Outcampus();
        String using_area= sysqk.getUsing_area();
        float teaching_utilization= sysqk.getTeaching_utilization();
        String teaching_experiment_project= sysqk.getTeaching_experiment_project();
        String new_equipment= sysqk.getNew_equipment();
        float val_equipment= sysqk.getVal_equipment();
        String personal_structure= sysqk.getPersonal_structure();
        int award_fullTime= sysqk.getAward_fullTime();
        float rate_partTime= sysqk.getRate_partTime();
        float exper_teaching_found= sysqk.getExper_teaching_found();
        float teaching_exper_found= sysqk.getTeaching_exper_found();


        int ret =  jdbcTemplate.update(ADD_LABS_SQL,term_year,lab_id,teacher_award_nation
                ,teacher_award_provincial,teacher_award_patent,student_award,teaching_paper_3retrieval,
                scientific_research_paper_3retrieval,teaching_paper_core_journal,scientific_research_paper_core_journal,
                paper_textbook,scientific_research_project_provincial,scientific_research_project_other,
                social_service_num,research_project_provincial,research_project_other,open_experient_number_campus,
                open_experient_number_Outcampus,open_experient_hour_campus,open_experient_hour_Outcampus,
                using_area,teaching_utilization,teaching_experiment_project,new_equipment,val_equipment,
                personal_structure,award_fullTime,rate_partTime,exper_teaching_found,teaching_exper_found);
                //jdbcTemplate.execute(INSERT_TO_SCORE2_TABLE);
        return ret;
    }

    public Sysqks getSysqk(int id){
        final Sysqks sysqk =new Sysqks();
                System.out.println("id: "+id);

        jdbcTemplate.query(GET_LABS_SQL, new Object[]{id}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                sysqk.setId(resultSet.getInt("id"));
                sysqk.setLab_id(resultSet.getInt("lab_id"));
                   sysqk.setVal_equipment(resultSet.getFloat("val_equipment"));
                   sysqk.setPaper_textbook(resultSet.getInt("paper_textbook"));
                   sysqk.setOpen_experient_hour_campus(resultSet.getInt("open_experient_hour_campus"));
                   sysqk.setNew_equipment(resultSet.getString("new_equipment"));
                   sysqk.setScientific_research_paper_3retrieval(resultSet.getFloat("scientific_research_paper_3retrieval"));
                   sysqk.setOpen_experient_number_campus(resultSet.getInt("open_experient_number_campus"));
                   sysqk.setOpen_experient_number_Outcampus(resultSet.getInt("open_experient_number_Outcampus"));
                   sysqk.setAward_fullTime(resultSet.getInt("award_fullTime"));
                   sysqk.setOpen_experient_hour_Outcampus(resultSet.getInt("open_experient_hour_Outcampus"));
                   sysqk.setResearch_project_other(resultSet.getFloat("research_project_other"));
                   sysqk.setResearch_project_provincial(resultSet.getFloat("research_project_provincial"));
                   sysqk.setScientific_research_paper_core_journal(resultSet.getFloat("scientific_research_paper_core_journal"));
                   sysqk.setScientific_research_project_other(resultSet.getFloat("scientific_research_project_other"));
                   sysqk.setScientific_research_project_provincial(resultSet.getFloat("scientific_research_project_provincial"));
                   sysqk.setSocial_service_num(resultSet.getFloat("social_service_num"));
                   sysqk.setStudent_award(resultSet.getFloat("student_award"));
                   sysqk.setTeacher_award_nation(resultSet.getFloat("teacher_award_nation"));
                   sysqk.setTeacher_award_patent(resultSet.getFloat("teacher_award_patent"));
                   sysqk.setTeacher_award_provincial(resultSet.getFloat("teacher_award_provincial"));
                   sysqk.setTeaching_paper_3retrieval(resultSet.getFloat("teaching_paper_3retrieval"));
                   sysqk.setTeaching_experiment_project(resultSet.getString("teaching_experiment_project"));
                   sysqk.setPersonal_structure(resultSet.getString("personal_structure"));
                   sysqk.setTeaching_paper_core_journal(resultSet.getFloat("teaching_paper_core_journal"));
                   sysqk.setTeaching_utilization(resultSet.getFloat("teaching_utilization"));
                   sysqk.setExper_teaching_found(resultSet.getFloat("exper_teaching_found"));
                   sysqk.setRate_partTime(resultSet.getFloat("rate_partTime"));
                   sysqk.setTerm_year(resultSet.getString("term_year"));
                   sysqk.setUsing_area(resultSet.getString("using_area"));
                   sysqk.setTeaching_exper_found(resultSet.getFloat("teaching_exper_found"));
            }

        });
        return sysqk;
    }
    public int editSysqk(Sysqks sysqk){
        int id = sysqk.getId();
        String term_year = sysqk.getTerm_year();
        int lab_id = sysqk.getLab_id();
        float teacher_award_nation = sysqk.getTeacher_award_nation();
        float teacher_award_provincial = sysqk.getTeacher_award_provincial();
        float teacher_award_patent= sysqk.getTeacher_award_patent();
        float student_award= sysqk.getStudent_award();
        float teaching_paper_3retrieval= sysqk.getTeaching_paper_3retrieval();
        float scientific_research_paper_3retrieval= sysqk.getScientific_research_paper_3retrieval();
        float teaching_paper_core_journal= sysqk.getTeaching_paper_core_journal();
        float scientific_research_paper_core_journal= sysqk.getScientific_research_paper_core_journal();
        int paper_textbook= sysqk.getPaper_textbook();
        float scientific_research_project_provincial= sysqk.getScientific_research_project_provincial();
        float scientific_research_project_other= sysqk.getScientific_research_project_other();
        float social_service_num= sysqk.getSocial_service_num();
        float research_project_provincial= sysqk.getResearch_project_provincial();
        float research_project_other= sysqk.getResearch_project_other();
        int open_experient_number_campus= sysqk.getOpen_experient_number_campus();
        int open_experient_number_Outcampus= sysqk.getOpen_experient_number_Outcampus();
        int open_experient_hour_campus= sysqk.getOpen_experient_hour_campus();
        int open_experient_hour_Outcampus= sysqk.getOpen_experient_hour_Outcampus();
        String using_area= sysqk.getUsing_area();
        float teaching_utilization= sysqk.getTeaching_utilization();
        String teaching_experiment_project= sysqk.getTeaching_experiment_project();
        String new_equipment= sysqk.getNew_equipment();
        float val_equipment= sysqk.getVal_equipment();
        String personal_structure= sysqk.getPersonal_structure();
        int award_fullTime= sysqk.getAward_fullTime();
        float rate_partTime= sysqk.getRate_partTime();
        float exper_teaching_found= sysqk.getExper_teaching_found();
        float teaching_exper_found= sysqk.getTeaching_exper_found();
        System.out.println("id: "+id);
        return jdbcTemplate.update(EDIT_LABS_SQL,term_year,lab_id,teacher_award_nation
                ,teacher_award_provincial,teacher_award_patent,student_award,teaching_paper_3retrieval,
                scientific_research_paper_3retrieval,teaching_paper_core_journal,scientific_research_paper_core_journal,
                paper_textbook,scientific_research_project_provincial,scientific_research_project_other,
                social_service_num,research_project_provincial,research_project_other,open_experient_number_campus,
                open_experient_number_Outcampus,open_experient_hour_campus,open_experient_hour_Outcampus,
                using_area,teaching_utilization,teaching_experiment_project,new_equipment,val_equipment,
                personal_structure,award_fullTime,rate_partTime,exper_teaching_found,teaching_exper_found,id);
    }


}
