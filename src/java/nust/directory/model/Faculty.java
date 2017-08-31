/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nust.directory.model;

import static java.lang.Integer.parseInt;
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
public class Faculty {
    
    String faculty_name;
    String faculty_code;
    Database db = new Database();
    
     public String getFaculty_name(){
        return faculty_name;
    
    }
     public String getFaculty_code(){
        return faculty_code;
    
    }
 
    public static void main(String[]args){
        Faculty b = new Faculty();
        //b.add_faculty("Commerce", "C661", "SCS");
        //b.delete_faculty("C661");
        //b.update_faculty("New Applied Sceince", "AP661"," SCS");
        //b.view_faculty("AP661");
    }

    public void add_faculty(String faculty_name, String faculty_code){
         String query = "INSERT INTO faculty (faculty_name , faculty_code , department_id) VALUES ('" + faculty_name + "','"+faculty_code+"')";
        try {
            db.insert_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public  void update_faculty(String faculty_name, String faculty_code, String department_id){
           String query = "UPDATE faculty SET faculty_name ='" + faculty_name + "', faculty_code ='" + faculty_code+ "' WHERE faculty_code ='" + faculty_code +"'";
      try {
            db.update_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void delete_faculty(String faculty_code){
         String query = "DELETE FROM faculty WHERE faculty_code ='" + faculty_code +"'";
        try {
            db.delete(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public  Faculty view_faculty( String faculty_code ){
         String query = " SELECT * FROM faculty WHERE faculty_code= '" + faculty_code + "'";
        Faculty b = new Faculty();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                
                b.faculty_name = rs.getString("faculty_name");
                b.faculty_code = rs.getString("faculty_code");
               
                conn.close(); 
                return  b;
        
            }
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        return null;
    }
     public List<Faculty> view_faculty(){
        String query = " SELECT * FROM faculty ";
        List<Faculty> FacultyList = new ArrayList <Faculty>();
      
      
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Faculty b = new Faculty();  
                b.faculty_name = rs.getString("faculty_name");
                b.faculty_code = rs.getString("faculty_code");
                
                FacultyList.add(b);
            }
           
            return FacultyList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        
       
    }


   
}

