package com.book.dao;

import com.book.domain.Score2s;
import com.book.domain.Sysqks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class Score2sDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    private final static String DELETE_LABS_SQL = "DELETE from score2s where id = ?";
    private final static String UPDATE_LABS_SQL = "UPDATE score2s\n" +
            "JOIN sysqks\n" +
            "ON score2s.id = sysqks.id\n" +
            "set score2s.id = sysqks.id, score2s.term_year = sysqks.term_year, score2s.lab_id = sysqks.lab_id,camOpeExperiment = (CASE WHEN (((open_experient_number_campus BETWEEN 500 and 1000) and (open_experient_hour_campus BETWEEN 30 and 50))\n" +
            "      or ((open_experient_number_campus>300) and (open_experient_hour_campus BETWEEN 30 and 50)) or ((open_experient_number_campus BETWEEN 500 and 1000) and (open_experient_hour_campus>30)))then 60\n" +
            "    WHEN (((open_experient_number_campus BETWEEN 1001 and 1500) and (open_experient_hour_campus BETWEEN 51 and 70))\n" +
            "      or ((open_experient_number_campus>1000) and (open_experient_hour_campus BETWEEN 51 and 70)) or ((open_experient_number_campus BETWEEN 1001 and 1500) and (open_experient_hour_campus>50)))then 80\n" +
            "    WHEN (open_experient_number_campus>1500 and open_experient_hour_campus>70) then 100\n" +
            "    else 0 END),\n" +
            " offCamOpeExperiment = (CASE WHEN (((open_experient_number_Outcampus BETWEEN 20 and 50) and (open_experient_hour_Outcampus BETWEEN 5 and 10))\n" +
            "      or ((open_experient_number_Outcampus>20) and (open_experient_hour_Outcampus BETWEEN 5 and 10)) or ((open_experient_number_Outcampus BETWEEN 20 and 50) and (open_experient_hour_Outcampus>10)))then 60\n" +
            "    WHEN (((open_experient_number_Outcampus BETWEEN 51 and 100) and (open_experient_hour_Outcampus BETWEEN 11 and 20))\n" +
            "      or ((open_experient_number_Outcampus>50) and (open_experient_hour_Outcampus BETWEEN 11 and 20)) or ((open_experient_number_Outcampus BETWEEN 51 and 100) and (open_experient_hour_Outcampus>10)))then 80\n" +
            "    WHEN (open_experient_number_Outcampus>100 and open_experient_hour_Outcampus>20) then 100\n" +
            "    else 0 END),\n" +
            " teaefficiency = (CASE WHEN (((teaching_paper_3retrieval BETWEEN 1 and 5) and (teaching_paper_core_journal BETWEEN 1 and 5)) or ((teaching_paper_3retrieval>1) and (teaching_paper_core_journal BETWEEN 5 and 10)) or ((teaching_paper_3retrieval BETWEEN 20 and 50) and (teaching_paper_core_journal>1)))then 60\n" +
            "    WHEN (((teaching_paper_3retrieval BETWEEN 5 and 10) and (teaching_paper_core_journal BETWEEN 5 and 10))\n" +
            "      or ((teaching_paper_3retrieval>5) and (teaching_paper_core_journal BETWEEN 5 and 10)) or ((teaching_paper_3retrieval BETWEEN 5 and 10) and (teaching_paper_core_journal>5)))then 80\n" +
            "    WHEN (teaching_paper_3retrieval>10 and teaching_paper_core_journal>10) then 100\n" +
            "    else 0 END),\n" +
            "expteaproject = (CASE WHEN teaching_utilization BETWEEN 0.1 and 0.3 then 60\n" +
            "    WHEN teaching_utilization BETWEEN 0.3 and 0.5    then 80\n" +
            "    WHEN teaching_utilization>0.5                    then 100\n" +
            "    else 0 END),\n" +
            "teaPaper = (CASE WHEN teaching_experiment_project BETWEEN 30 and 50 then 60\n" +
            "    WHEN teaching_experiment_project BETWEEN 50 and 70    then 80\n" +
            "    WHEN teaching_experiment_project>70                    then 100\n" +
            "    else 0 END),\n" +
            "expTeaMaterials = (CASE WHEN paper_textbook BETWEEN 1 and 50 then 60\n" +
            "    WHEN paper_textbook BETWEEN 50 and 100  then 80\n" +
            "    WHEN paper_textbook>100                 then 100\n" +
            "    else 0 END),\n" +
            "stuAward = (CASE WHEN student_award BETWEEN 1 and 5  then 60\n" +
            "      WHEN student_award BETWEEN 5 and 10 then 80\n" +
            "      WHEN student_award>10               then 100\n" +
            "    else 0 END),\n" +
            "sciResProject = (CASE WHEN scientific_research_project_provincial BETWEEN 1 and 5  then 60\n" +
            "      WHEN scientific_research_project_provincial BETWEEN 5 and 10 then 80\n" +
            "      WHEN scientific_research_project_provincial>10               then 100\n" +
            "      else 0 END),\n" +
            "resPapers = (CASE WHEN (((scientific_research_paper_3retrieval BETWEEN 1 and 5) and (scientific_research_paper_core_journal BETWEEN 1 and 5))\n" +
            "      or ((scientific_research_paper_3retrieval>1) and (scientific_research_paper_core_journal BETWEEN 5 and 10)) or ((scientific_research_paper_3retrieval BETWEEN 20 and 50) and (scientific_research_paper_core_journal>1)))then 60\n" +
            "    WHEN (((scientific_research_paper_3retrieval BETWEEN 5 and 10) and (scientific_research_paper_core_journal BETWEEN 5 and 10))\n" +
            "      or ((scientific_research_paper_3retrieval>5) and (scientific_research_paper_core_journal BETWEEN 5 and 10)) or ((scientific_research_paper_3retrieval BETWEEN 5 and 10) and (scientific_research_paper_core_journal>5)))then 80\n" +
            "    WHEN (scientific_research_paper_3retrieval>10 and scientific_research_paper_core_journal>10) then 100\n" +
            "    else 0 END),\n" +
            "socServices = (CASE WHEN social_service_num BETWEEN 1 and 5  then 60\n" +
            "      WHEN social_service_num BETWEEN 5 and 10 then 80\n" +
            "      WHEN social_service_num>10               then 100\n" +
            "      else 0 END),\n" +
            "updOfEquipment = (CASE WHEN (new_equipment) BETWEEN 500 and 1000  then 60\n" +
            "      WHEN (new_equipment) BETWEEN 1000 and 2000   then 80\n" +
            "      WHEN (new_equipment)>2000                   then 100\n" +
            "      else 0 END),\n" +
            "valEquipment = (CASE WHEN (val_equipment) BETWEEN 1 and 2  then 60\n" +
            "      WHEN (val_equipment) BETWEEN 2 and 3   then 80\n" +
            "      WHEN (val_equipment)>3                   then 100\n" +
            "      else 0 END),\n" +
            "stuAveArea = (CASE WHEN (using_area/open_experient_number_campus) BETWEEN 0.05 and 0.1  then 60\n" +
            "      WHEN (using_area/open_experient_number_campus) BETWEEN 0.1 and 0.5 then 80\n" +
            "      WHEN (using_area/open_experient_number_campus)>0.5               then 100\n" +
            "      else 0 END),\n" +
            "stuAveFund = (CASE WHEN (open_experient_number_campus/exper_teaching_found) BETWEEN 0.05 and 0.1  then 60\n" +
            "      WHEN (open_experient_number_campus/exper_teaching_found) BETWEEN 0.1 and 0.5   then 80\n" +
            "      WHEN (open_experient_number_campus/exper_teaching_found)>0.5                   then 100\n" +
            "      else 0 END),\n" +
            "stuAveTeaExpMatFund = (CASE WHEN (open_experient_number_campus/teaching_exper_found) BETWEEN 2000 and 5000  then 60\n" +
            "      WHEN (open_experient_number_campus/teaching_exper_found) BETWEEN 5000 and 1000   then 80\n" +
            "      WHEN (open_experient_number_campus/teaching_exper_found)>10000                   then 100\n" +
            "      else 0 END),\n" +
            "perStructure = (CASE WHEN personal_structure=0  then 0\n" +
            "      WHEN (personal_structure) BETWEEN 0 and 0.3  then 60\n" +
            "      WHEN (personal_structure) BETWEEN 0.3 and 0.6   then 80\n" +
            "      WHEN (personal_structure)>0.6                   then 100\n" +
            "      else 0 END),\n" +
            "numOfParWorkers = (CASE WHEN (rate_partTime) <1             then 0\n" +
            "\t\t\tWHEN (rate_partTime) BETWEEN 1 and 2  then 60\n" +
            "      WHEN (rate_partTime) BETWEEN 2 and 3   then 80\n" +
            "      WHEN (rate_partTime)>3                   then 100\n" +
            "      else 0 END),\n" +
            "proAchievements = (CASE WHEN (award_fullTime) <1               then 0\n" +
            "      WHEN (award_fullTime) BETWEEN 1 and 2  then 60\n" +
            "      WHEN (award_fullTime) BETWEEN 2 and 3   then 80\n" +
            "      WHEN (award_fullTime)>3                   then 100\n" +
            "      else 0 END) where sysqks.id= ?;";
    private final static String GET_LABS_SQL = "SELECT * FROM score2s where id = ?";
    private final static String QUERY_ALL_LABS_SQL = "SELECT * FROM score2s ";
    private final static String QUERY_LABS_SQL = "SELECT * FROM score2s WHERE lab_id like ?";
    //count the number of books
    private final static String MATCH_LABS_SQL = "SELECT count(*) FROM score2s WHERE lab_id like ?";

    public int matchScore2(String searchWord) {
        String swcx = "%" + searchWord + "%";
        return jdbcTemplate.queryForObject(MATCH_LABS_SQL, new Object[]{swcx}, Integer.class);
    }

    public ArrayList<Score2s> queryScore2(String sw) {
        String swcx = "%" + sw + "%";
        //System.out.println("query string"+swcx);
        final ArrayList<Score2s> score2s = new ArrayList<Score2s>();
        jdbcTemplate.query(QUERY_LABS_SQL, new Object[]{swcx}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    Score2s score2 = new Score2s();
                    score2.setId(resultSet.getInt("id"));
                    score2.setLab_id(resultSet.getInt("lab_id"));
                    score2.setTerm_year(resultSet.getString("term_year"));
                    score2.setCamOpeExperiment(resultSet.getFloat("camOpeExperiment"));
                    score2.setOffCamOpeExperiment(resultSet.getFloat("offCamOpeExperiment"));
                    score2.setTeaEfficiency(resultSet.getFloat("teaEfficiency"));
                    score2.setExpTeaProject(resultSet.getFloat("expTeaProject"));
                    score2.setTeaPaper(resultSet.getFloat("teaPaper"));
                    score2.setExpTeaMaterials(resultSet.getFloat("expTeaMaterials"));
                    score2.setStuAward(resultSet.getFloat("stuAward"));
                    score2.setSciResProject(resultSet.getFloat("sciResProject"));
                    score2.setResPapers(resultSet.getFloat("resPapers"));
                    score2.setSocServices(resultSet.getFloat("socServices"));
                    score2.setUpdOfEquipment(resultSet.getFloat("updOfEquipment"));
                    score2.setValEquipment(resultSet.getFloat("valEquipment"));
                    score2.setStuAveArea(resultSet.getFloat("stuAveArea"));
                    score2.setStuAveFund(resultSet.getFloat("stuAveFund"));
                    score2.setStuAveTeaExpMatFund(resultSet.getFloat("stuAveTeaExpMatFund"));
                    score2.setPerStructure(resultSet.getFloat("perStructure"));
                    score2.setNumOfParWorkers(resultSet.getFloat("numOfParWorkers"));
                    score2.setProAchievements(resultSet.getFloat("proAchievements"));

                    score2s.add(score2);
                }

            }
        });
        return score2s;
    }

    public ArrayList<Score2s> getAllScore2() {
        final ArrayList<Score2s> score2s = new ArrayList<Score2s>();

        jdbcTemplate.query(QUERY_ALL_LABS_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    Score2s score2 = new Score2s();
                    score2.setId(resultSet.getInt("id"));
                    score2.setLab_id(resultSet.getInt("lab_id"));
                    score2.setTerm_year(resultSet.getString("term_year"));
                    score2.setCamOpeExperiment(resultSet.getFloat("camOpeExperiment"));
                    score2.setOffCamOpeExperiment(resultSet.getFloat("offCamOpeExperiment"));
                    score2.setTeaEfficiency(resultSet.getFloat("teaEfficiency"));
                    score2.setExpTeaProject(resultSet.getFloat("expTeaProject"));
                    score2.setTeaPaper(resultSet.getFloat("teaPaper"));
                    score2.setExpTeaMaterials(resultSet.getFloat("expTeaMaterials"));
                    score2.setStuAward(resultSet.getFloat("stuAward"));
                    score2.setSciResProject(resultSet.getFloat("sciResProject"));
                    score2.setResPapers(resultSet.getFloat("resPapers"));
                    score2.setSocServices(resultSet.getFloat("socServices"));
                    score2.setUpdOfEquipment(resultSet.getFloat("updOfEquipment"));
                    score2.setValEquipment(resultSet.getFloat("valEquipment"));
                    score2.setStuAveArea(resultSet.getFloat("stuAveArea"));
                    score2.setStuAveFund(resultSet.getFloat("stuAveFund"));
                    score2.setStuAveTeaExpMatFund(resultSet.getFloat("stuAveTeaExpMatFund"));
                    score2.setPerStructure(resultSet.getFloat("perStructure"));
                    score2.setNumOfParWorkers(resultSet.getFloat("numOfParWorkers"));
                    score2.setProAchievements(resultSet.getFloat("proAchievements"));

                    score2s.add(score2);
                }
            }
        });
        return score2s;

    }

    public int deleteScore2(int id) {

        return jdbcTemplate.update(DELETE_LABS_SQL, id);
    }

    public void addScore2() {

        jdbcTemplate.execute(INSERT_TO_SCORE2_TABLE);
    }

    public Score2s getScore2(int id) {
        final Score2s score2 = new Score2s();
        jdbcTemplate.query(GET_LABS_SQL, new Object[]{id}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                score2.setId(resultSet.getInt("id"));
                score2.setLab_id(resultSet.getInt("lab_id"));
                score2.setTerm_year(resultSet.getString("term_year"));
                score2.setCamOpeExperiment(resultSet.getFloat("camOpeExperiment"));
                score2.setOffCamOpeExperiment(resultSet.getFloat("offCamOpeExperiment"));
                score2.setTeaEfficiency(resultSet.getFloat("teaEfficiency"));
                score2.setExpTeaProject(resultSet.getFloat("expTeaProject"));
                score2.setTeaPaper(resultSet.getFloat("teaPaper"));
                score2.setExpTeaMaterials(resultSet.getFloat("expTeaMaterials"));
                score2.setStuAward(resultSet.getFloat("stuAward"));
                score2.setSciResProject(resultSet.getFloat("sciResProject"));
                score2.setResPapers(resultSet.getFloat("resPapers"));
                score2.setSocServices(resultSet.getFloat("socServices"));
                score2.setUpdOfEquipment(resultSet.getFloat("updOfEquipment"));
                score2.setValEquipment(resultSet.getFloat("valEquipment"));
                score2.setStuAveArea(resultSet.getFloat("stuAveArea"));
                score2.setStuAveFund(resultSet.getFloat("stuAveFund"));
                score2.setStuAveTeaExpMatFund(resultSet.getFloat("stuAveTeaExpMatFund"));
                score2.setPerStructure(resultSet.getFloat("perStructure"));
                score2.setNumOfParWorkers(resultSet.getFloat("numOfParWorkers"));
                score2.setProAchievements(resultSet.getFloat("proAchievements"));
            }

        });
        return score2;
    }

    public int editScore2(Sysqks sysqks) {
        int id = sysqks.getId();
        return jdbcTemplate.update(UPDATE_LABS_SQL
                ,id);
    }


}
