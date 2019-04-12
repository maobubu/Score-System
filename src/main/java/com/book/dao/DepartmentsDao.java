package com.book.dao;

import com.book.domain.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class DepartmentsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String ADD_LABS_SQL="INSERT INTO departments VALUES(?,?) ";
    private final static String DELETE_LABS_SQL="DELETE from departments where departmentID = ?";
    private final static String EDIT_LABS_SQL="UPDATE departments set name= ?, departmentID = ? where departmentID = ?;";
    private final static String GET_LABS_SQL="SELECT * FROM departments where departmentID = ?";
    private final static String QUERY_ALL_LABS_SQL="SELECT * FROM departments ";
    private final static String QUERY_LABS_SQL="SELECT * FROM departments WHERE departmentID like ? or name like ?  ";
    //count the number of books
    private final static String MATCH_LABS_SQL="SELECT count(*) FROM departments WHERE departmentID like ?  or name like ?  ";

    public int matchDepartment(String searchWord){
        String swcx="%"+searchWord+"%";
        return jdbcTemplate.queryForObject(MATCH_LABS_SQL,new Object[]{swcx,swcx},Integer.class);
    }

    public ArrayList<Departments> queryDepartment(String sw){
        String swcx="%"+sw+"%";
        //System.out.println("query string"+swcx);
        final ArrayList<Departments> departments=new ArrayList<Departments>();
        jdbcTemplate.query(QUERY_LABS_SQL, new Object[]{swcx,swcx}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Departments department =new Departments();
                    department.setDepartmentID(resultSet.getInt("departmentID"));
                    department.setName(resultSet.getString("name"));
                    departments.add(department);
                }

            }
        });
        return departments;
    }

    public ArrayList<Departments> getAllDepartment(){
        final ArrayList<Departments> departments=new ArrayList<Departments>();

        jdbcTemplate.query(QUERY_ALL_LABS_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Departments department =new Departments();
                    department.setDepartmentID(resultSet.getInt("departmentID"));
                    department.setName(resultSet.getString("name"));

                    departments.add(department);
                }
            }
        });
        return departments;

    }

    public int deleteDepartment(int departmentID){

        return jdbcTemplate.update(DELETE_LABS_SQL,departmentID);
    }

    public int addDepartment(Departments department){
        String name=department.getName();
        int departmentID=department.getDepartmentID();
        System.out.println("name: "+name+" departmentID: "+departmentID);


        return jdbcTemplate.update(ADD_LABS_SQL,name,departmentID);
    }

    public Departments getDepartment(int departmentID){
        final Departments department =new Departments();
        jdbcTemplate.query(GET_LABS_SQL, new Object[]{departmentID}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                department.setDepartmentID(resultSet.getInt("departmentID"));
                department.setName(resultSet.getString("name"));
            }

        });
        return department;
    }
    public int editDepartment(Departments department){
        String name = department.getName();
        int departmentID = department.getDepartmentID();
        System.out.println("name: "+name+" departmentID: "+departmentID);

        return jdbcTemplate.update(EDIT_LABS_SQL,name,departmentID,departmentID);
    }


}
