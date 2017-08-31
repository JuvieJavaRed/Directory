/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nust.directory.model;

import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nust.directory.model.Database;
import java.util.ArrayList;
import static nust.directory.model.Database.conn;

public class Building {
    String name;
    int building_id;
    int floor;
    int numOffices;
    Database db = new Database();
    
    
    
    public int getBuilding_id(){
        return building_id;
    
    }
     public String getName(){
        return name;
    
    }
    
    public int getFloor(){
        return floor;
    
    }
     public int getNumOffices(){
        return numOffices;
    
    }
    /**
     *
     * @param args
     */
    public static void main(String[]args){
        
        Building b = new Building();
        //b.add_building(  "Rednation Building", 5 , 500);
        //b.update_building( "id005", "Rednation Building", 4, 500 );
        //b.delete_building("Admissions Building");
        //b.view_building("id005");
        
    }
    public void add_building( String name, int floor, int numOffices){
        String query = "INSERT INTO building ( name , number_floors, numOffices) VALUES ('" + name + "'" + "," + floor + "," + numOffices + ")";
        try {
            db.insert_db(query);
            System.out.println("Successful");
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("UnSuccessful at adding");
       }
        
   }
			
    public void update_building(String name, int building_id, int floor, int numOffices){
        String query = "UPDATE building SET name ='" + name + "', number_floors ='" + floor + "',number_offices ='" + numOffices + "'WHERE building_id ='" + building_id +"'";
      try {
            db.update_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
	
    public void delete_building( int building_id){
        String query = "DELETE FROM building WHERE building_id ='" + building_id +"'";
        try {
            db.delete(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   
    public Building view_building(int building_id){
        String query = " SELECT * FROM building WHERE building_id= '" + building_id + "'";
        Building b = new Building();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                
                b.building_id = parseInt(rs.getString("building_id"));
                b.floor = parseInt(rs.getString("number_floors"));
                b.name = rs.getString("name");
                b.numOffices = parseInt(rs.getString("numOffices"));
                
                
                return  b;
        
            }
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        return null;
    }
    
    public List<Building> view_building(){
        String query = " SELECT * FROM building ";
        List<Building> BuildingList = new ArrayList <Building>();
      
      
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Building b = new Building();  
                b.building_id = parseInt(rs.getString("building_id"));
                b.floor = parseInt(rs.getString("number_floors"));
                b.name = rs.getString("name");
                b.numOffices = parseInt(rs.getString("numOffices"));
                
                BuildingList.add(b);
            }
           
            return BuildingList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
    }
   public List<Building> display_builing(){
        String query = " SELECT * FROM building ";
        List<Building> BuildingList = new ArrayList <Building>();
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Building b = new Building();  
                b.name = rs.getString("name");
                b.building_id = parseInt(rs.getString("building_id"));
                BuildingList.add(b);
            }
           
            return BuildingList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
           }
        
       
    }
}

   
