/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nust.directory.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static nust.directory.model.Database.conn;

/**
 *
 * ICTS TEAM
 */
public class Department{
    
    String department_name;
    String department_id;
    String building;
    String faculty_code;
    Database db = new Database();
    
     public String getDepartment_name(){
        return department_name;
    
    }
     public String getDepartment_id(){
        return department_id;
    
    }
    
    public String getBuilding(){
        return building;
    
    }
     public String getFaculty_code(){
        return faculty_code;
    
    }
    
    public static void main(String[]args){
        Department d = new Department();
        //d.add_department("COMP SCIENCE"," SCU"," APPLIED SCIENCE");
        //d.update_department("Computer Science","SCU","Mechanics");
    }

    public void add_department(String department_name, String department_id, String building, String faculty_code){
          String query = "INSERT INTO department ( department_name , department_id, building, faculty_code) VALUES ('" + department_name + "','"+department_id+"','" + building+ "','"+faculty_code+"')";
        try {
            db.insert_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void update_department(String department_name, String department_id, String building, String faculty_code){
          String query = "UPDATE department SET department_name ='" + department_name + "', department_id ='" + department_id+ "',building ='" + building +"',faculty_code ='" + faculty_code +"' WHERE department_id ='" + department_id +"'";
      try {
            db.update_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    

    public void delete_department(String department_id){
         String query = "DELETE FROM department WHERE department_id ='" + department_id +"'";
        try {
            db.delete(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public Department view_department(String department_id){
        String query = " SELECT * FROM faculty WHERE department_id= '" + department_id + "'";
        Department d = new Department();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                
                d.building = rs.getString("building");
                d.department_id = rs.getString("department_id");
                d.department_name = rs.getString("department_name");
               
                conn.close(); 
                return  d;
        
            }
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        return null;

    }
     public List<Department> view_department(){
        String query = " SELECT * FROM department";
         List<Department> DepartmentList = new ArrayList <Department>();
        
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Department d = new Department();
                d.building = rs.getString("building");
                d.department_id = rs.getString("department_id");
                d.department_name = rs.getString("department_name");
                DepartmentList.add(d);
            }
            return DepartmentList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
       

        }
}
    


