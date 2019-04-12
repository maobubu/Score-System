
package com.book.dao;

import com.book.domain.Evaluate2s;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class Evaluate2sDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String ADD_LABS_SQL = "INSERT INTO evaluate2s VALUES(NULL ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String DELETE_LABS_SQL = "DELETE from evaluate2s where id = ?";
    private final static String EDIT_LABS_SQL = "UPDATE evaluate2s set camOpeExperiment =?, offCamOpeExperiment =?, teaEfficiency =?, expTeaProject =?, teaPaper =?, expTeaMaterials =?, stuAward =?, sciResProject =?, resPapers =?, socServices =?, updOfEquipment =?, valEquipment =?, stuAveArea =?, stuAveFund =?, stuAveTeaExpMatFund =?, perStructure =?, numOfParWorkers =?, proAchievements =? where id = ?;";
    private final static String GET_LABS_SQL = "SELECT * FROM evaluate2s where id = ?";
    private final static String QUERY_ALL_LABS_SQL = "SELECT * FROM evaluate2s ";
    private final static String QUERY_LABS_SQL = "SELECT * FROM evaluate2s WHERE id like ? ";
    //count the number of books
    private final static String MATCH_LABS_SQL = "SELECT count(*) FROM evaluate2s WHERE id like ? ";

    public int matchEvaluate2(String searchWord) {
        String swcx = "%" + searchWord + "%";
        return jdbcTemplate.queryForObject(MATCH_LABS_SQL, new Object[]{swcx}, Integer.class);
    }

    public ArrayList<Evaluate2s> queryEvaluate2(String sw) {
        String swcx = "%" + sw + "%";
        //System.out.println("query string"+swcx);
        final ArrayList<Evaluate2s> evaluate2s = new ArrayList<Evaluate2s>();
        jdbcTemplate.query(QUERY_LABS_SQL, new Object[]{swcx}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    Evaluate2s evaluate2 = new Evaluate2s();
                    evaluate2.setId(resultSet.getInt("id"));
                    evaluate2.setCamOpeExperiment(resultSet.getFloat("camOpeExperiment"));
                    evaluate2.setOffCamOpeExperiment(resultSet.getFloat("offCamOpeExperiment"));
                    evaluate2.setTeaEfficiency(resultSet.getFloat("teaEfficiency"));
                    evaluate2.setExpTeaProject(resultSet.getFloat("expTeaProject"));
                    evaluate2.setTeaPaper(resultSet.getFloat("teaPaper"));
                    evaluate2.setExpTeaMaterials(resultSet.getFloat("expTeaMaterials"));
                    evaluate2.setStuAward(resultSet.getFloat("stuAward"));
                    evaluate2.setSciResProject(resultSet.getFloat("sciResProject"));
                    evaluate2.setResPapers(resultSet.getFloat("resPapers"));
                    evaluate2.setSocServices(resultSet.getFloat("socServices"));
                    evaluate2.setUpdOfEquipment(resultSet.getFloat("updOfEquipment"));
                    evaluate2.setValEquipment(resultSet.getFloat("valEquipment"));
                    evaluate2.setStuAveArea(resultSet.getFloat("stuAveArea"));
                    evaluate2.setStuAveFund(resultSet.getFloat("stuAveFund"));
                    evaluate2.setStuAveTeaExpMatFund(resultSet.getFloat("stuAveTeaExpMatFund"));
                    evaluate2.setPerStructure(resultSet.getFloat("perStructure"));
                    evaluate2.setNumOfParWorkers(resultSet.getFloat("numOfParWorkers"));
                    evaluate2.setProAchievements(resultSet.getFloat("proAchievements"));

                    evaluate2s.add(evaluate2);
                }

            }
        });
        return evaluate2s;
    }

    public ArrayList<Evaluate2s> getAllEvaluate2() {
        final ArrayList<Evaluate2s> evaluate2s = new ArrayList<Evaluate2s>();

        jdbcTemplate.query(QUERY_ALL_LABS_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    Evaluate2s evaluate2 = new Evaluate2s();
                    evaluate2.setId(resultSet.getInt("id"));
                    evaluate2.setCamOpeExperiment(resultSet.getFloat("camOpeExperiment"));
                    evaluate2.setOffCamOpeExperiment(resultSet.getFloat("offCamOpeExperiment"));
                    evaluate2.setTeaEfficiency(resultSet.getFloat("teaEfficiency"));
                    evaluate2.setExpTeaProject(resultSet.getFloat("expTeaProject"));
                    evaluate2.setTeaPaper(resultSet.getFloat("teaPaper"));
                    evaluate2.setExpTeaMaterials(resultSet.getFloat("expTeaMaterials"));
                    evaluate2.setStuAward(resultSet.getFloat("stuAward"));
                    evaluate2.setSciResProject(resultSet.getFloat("sciResProject"));
                    evaluate2.setResPapers(resultSet.getFloat("resPapers"));
                    evaluate2.setSocServices(resultSet.getFloat("socServices"));
                    evaluate2.setUpdOfEquipment(resultSet.getFloat("updOfEquipment"));
                    evaluate2.setValEquipment(resultSet.getFloat("valEquipment"));
                    evaluate2.setStuAveArea(resultSet.getFloat("stuAveArea"));
                    evaluate2.setStuAveFund(resultSet.getFloat("stuAveFund"));
                    evaluate2.setStuAveTeaExpMatFund(resultSet.getFloat("stuAveTeaExpMatFund"));
                    evaluate2.setPerStructure(resultSet.getFloat("perStructure"));
                    evaluate2.setNumOfParWorkers(resultSet.getFloat("numOfParWorkers"));
                    evaluate2.setProAchievements(resultSet.getFloat("proAchievements"));

                    evaluate2s.add(evaluate2);
                }
            }
        });
        return evaluate2s;

    }

    public int deleteEvaluate2(int id) {

        return jdbcTemplate.update(DELETE_LABS_SQL, id);
    }

    public int addEvaluate2(Evaluate2s evaluate2) {
        //int id = evaluate2.getId();
        float camOpeExperiment = evaluate2.getCamOpeExperiment();
        float offCamOpeExperiment = evaluate2.getOffCamOpeExperiment();
        float teaEfficiency = evaluate2.getTeaEfficiency();
        float expTeaProject = evaluate2.getExpTeaProject();
        float teaPaper = evaluate2.getTeaPaper();
        float expTeaMaterials = evaluate2.getExpTeaMaterials();
        float stuAward = evaluate2.getStuAward();
        float sciResProject = evaluate2.getSciResProject();
        float resPapers = evaluate2.getSocServices();
        float socServices = evaluate2.getResPapers();
        float updOfEquipment = evaluate2.getUpdOfEquipment();
        float valEquipment = evaluate2.getValEquipment();
        float stuAveArea = evaluate2.getStuAveArea();
        float stuAveFund = evaluate2.getStuAveFund();
        float stuAveTeaExpMatFund = evaluate2.getStuAveTeaExpMatFund();
        float perStructure = evaluate2.getPerStructure();
        float numOfParWorkers = evaluate2.getNumOfParWorkers();
        float proAchievements = evaluate2.getProAchievements();


        return jdbcTemplate.update(ADD_LABS_SQL
                ,camOpeExperiment
                ,offCamOpeExperiment
                ,teaEfficiency
                ,expTeaProject
                ,teaPaper
                ,expTeaMaterials
                ,stuAward
                ,sciResProject
                ,resPapers
                ,socServices
                ,updOfEquipment
                ,valEquipment
                ,stuAveArea
                ,stuAveFund
                ,stuAveTeaExpMatFund
                ,perStructure
                ,numOfParWorkers
                ,proAchievements
                );
    }

    public Evaluate2s getEvaluate2(int id) {
        final Evaluate2s evaluate2 = new Evaluate2s();
        jdbcTemplate.query(GET_LABS_SQL, new Object[]{id}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                evaluate2.setId(resultSet.getInt("id"));
                evaluate2.setCamOpeExperiment(resultSet.getFloat("camOpeExperiment"));
                evaluate2.setOffCamOpeExperiment(resultSet.getFloat("offCamOpeExperiment"));
                evaluate2.setTeaEfficiency(resultSet.getFloat("teaEfficiency"));
                evaluate2.setExpTeaProject(resultSet.getFloat("expTeaProject"));
                evaluate2.setTeaPaper(resultSet.getFloat("teaPaper"));
                evaluate2.setExpTeaMaterials(resultSet.getFloat("expTeaMaterials"));
                evaluate2.setStuAward(resultSet.getFloat("stuAward"));
                evaluate2.setSciResProject(resultSet.getFloat("sciResProject"));
                evaluate2.setResPapers(resultSet.getFloat("resPapers"));
                evaluate2.setSocServices(resultSet.getFloat("socServices"));
                evaluate2.setUpdOfEquipment(resultSet.getFloat("updOfEquipment"));
                evaluate2.setValEquipment(resultSet.getFloat("valEquipment"));
                evaluate2.setStuAveArea(resultSet.getFloat("stuAveArea"));
                evaluate2.setStuAveFund(resultSet.getFloat("stuAveFund"));
                evaluate2.setStuAveTeaExpMatFund(resultSet.getFloat("stuAveTeaExpMatFund"));
                evaluate2.setPerStructure(resultSet.getFloat("perStructure"));
                evaluate2.setNumOfParWorkers(resultSet.getFloat("numOfParWorkers"));
                evaluate2.setProAchievements(resultSet.getFloat("proAchievements"));
            }

        });
        return evaluate2;
    }

    public int editEvaluate2(Evaluate2s evaluate2) {
        int id = evaluate2.getId();
        float camOpeExperiment = evaluate2.getCamOpeExperiment();
        float offCamOpeExperiment = evaluate2.getOffCamOpeExperiment();
        float teaEfficiency = evaluate2.getTeaEfficiency();
        float expTeaProject = evaluate2.getExpTeaProject();
        float teaPaper = evaluate2.getTeaPaper();
        float expTeaMaterials = evaluate2.getExpTeaMaterials();
        float stuAward = evaluate2.getStuAward();
        float sciResProject = evaluate2.getSciResProject();
        float resPapers = evaluate2.getSocServices();
        float socServices = evaluate2.getResPapers();
        float updOfEquipment = evaluate2.getUpdOfEquipment();
        float valEquipment = evaluate2.getValEquipment();
        float stuAveArea = evaluate2.getStuAveArea();
        float stuAveFund = evaluate2.getStuAveFund();
        float stuAveTeaExpMatFund = evaluate2.getStuAveTeaExpMatFund();
        float perStructure = evaluate2.getPerStructure();
        float numOfParWorkers = evaluate2.getNumOfParWorkers();
        float proAchievements = evaluate2.getProAchievements();

        return jdbcTemplate.update(EDIT_LABS_SQL
                ,camOpeExperiment
                ,offCamOpeExperiment
                ,teaEfficiency
                ,expTeaProject
                ,teaPaper
                ,expTeaMaterials
                ,stuAward
                ,sciResProject
                ,resPapers
                ,socServices
                ,updOfEquipment
                ,valEquipment
                ,stuAveArea
                ,stuAveFund
                ,stuAveTeaExpMatFund
                ,perStructure
                ,numOfParWorkers
                ,proAchievements
                ,id);
    }


}
