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
 * @author mary.dzinomwa
 */
public class Section {
    String section_id;
    String section_name;
    int building_id;
    Database db = new Database();
    
     public String getSection_id(){
        return section_id;
    
    }
     public String getSection_name(){
        return section_name;
    }
      public int getBuilding_id(){
        return building_id;
    }
      public static void main(String[]args){
        Section s = new Section();
        
    }

    public void add_section(String section_id, String section_name,int building_id){
         String query = "INSERT INTO section (section_id , section_name , building_id) VALUES ('" + section_id + "','"+ section_name +"','"+ building_id +"')";
        try {
            db.insert_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public  void update_section(String section_id, String section_name,int building_id){
           String query = "UPDATE section SET section_id ='" + section_id + "', section_name ='" + section_name +"',building_id='" +building_id + "' WHERE section_id ='" + section_id +"'";
      try {
            db.update_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public void delete_section(String section_id){
         String query = "DELETE FROM section WHERE section_id ='" + section_id +"'";
        try {
            db.delete(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public  Section view_selection( String  section_id ){
         String query = " SELECT * FROM section WHERE  section_id= '" +  section_id + "'";
        Section s = new Section();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                
                 s. section_id = rs.getString( "section_id");
                s. section_name = rs.getString(" section_name");
                s.building_id =parseInt(rs.getString("building_id")); 
                return  s;
        
            }
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        return null;
    }
     public List<Section> view_section(){
        String query = " SELECT * FROM section ";
        List<Section> SectionList = new ArrayList <Section>();
      
      
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Section s = new Section();  
                s. section_id = rs.getString( "section_id");
                s. section_name = rs.getString(" section_name");
                s.building_id =parseInt(rs.getString("building_id"));
                
                SectionList.add(s);
            }
           
            return SectionList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        
       
    }


   
}

