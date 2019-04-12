package com.book.dao;

import com.book.domain.Labs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class LabsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String ADD_LABS_SQL="INSERT INTO labs VALUES(NULL ,?,?) ";
    private final static String DELETE_LABS_SQL="DELETE from labs where departmentID = ? and id = ?";
    private final static String EDIT_LABS_SQL="UPDATE labs set name= ?, departmentID = ? where id = ?;";
    private final static String GET_LABS_SQL="SELECT * FROM labs where departmentID = ? and id = ?";
    private final static String QUERY_ALL_LABS_SQL="SELECT * FROM labs ";
    private final static String QUERY_LABS_SQL="SELECT * FROM labs WHERE departmentID like ? or name like ? ";
    //count the number of books
    private final static String MATCH_LABS_SQL="SELECT count(*) FROM labs WHERE departmentID like ?  or name like ?  ";

    public int matchLab(String searchWord){
        String swcx="%"+searchWord+"%";
        return jdbcTemplate.queryForObject(MATCH_LABS_SQL,new Object[]{swcx,swcx},Integer.class);
    }

    public ArrayList<Labs> queryLab(String sw){
        String swcx="%"+sw+"%";
        //System.out.println("query string"+swcx);
        final ArrayList<Labs> labs=new ArrayList<Labs>();
        jdbcTemplate.query(QUERY_LABS_SQL, new Object[]{swcx,swcx}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Labs lab =new Labs();
                    lab.setDepartmentID(resultSet.getInt("departmentID"));
                    lab.setId(resultSet.getInt("id"));
                    lab.setName(resultSet.getString("name"));
                    labs.add(lab);
                }

            }
        });
        return labs;
    }

    public ArrayList<Labs> getAllLab(){
        final ArrayList<Labs> labs=new ArrayList<Labs>();

        jdbcTemplate.query(QUERY_ALL_LABS_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Labs lab =new Labs();
                    lab.setDepartmentID(resultSet.getInt("departmentID"));
                    lab.setId(resultSet.getInt("id"));
                    lab.setName(resultSet.getString("name"));

                    labs.add(lab);
                }
            }
        });
        return labs;

    }

    public int deleteLab(int departmentID, int id){

        return jdbcTemplate.update(DELETE_LABS_SQL,departmentID,id);
    }

    public int addLab(Labs lab){
        String name=lab.getName();
        int departmentID=lab.getDepartmentID();
        System.out.println("name: "+name+" departmentID: "+departmentID);


        return jdbcTemplate.update(ADD_LABS_SQL,name,departmentID);
    }

    public Labs getLab(int departmentID,int id){
        final Labs lab =new Labs();
        jdbcTemplate.query(GET_LABS_SQL, new Object[]{departmentID,id}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                lab.setDepartmentID(resultSet.getInt("departmentID"));
                lab.setName(resultSet.getString("name"));
                lab.setId(resultSet.getInt("id"));//very important
            }

        });
        return lab;
    }
    public int editLab(Labs lab){
        String name = lab.getName();
        int departmentID = lab.getDepartmentID();
        int id = lab.getId();
        System.out.println("name: "+name+" departmentID: "+departmentID+", id: "+id);

        return jdbcTemplate.update(EDIT_LABS_SQL,name,departmentID,id);
    }


}
