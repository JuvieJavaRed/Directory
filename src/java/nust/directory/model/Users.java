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
 *ICTS TEAM
 */
public class Users {
    
    String name;
    String surname;
    String job_title;
    String userID;
    String password;
    Database db = new Database();
    
     public String getName(){
        return name;
    
    }
     public String getSurname(){
        return surname;
    }
      public String getJob_title(){
        return job_title;
    
    }
     public String getUser_id(){
        return userID;
    
    }
     public String getPassword(){
        return password;
    
    }
    public static void main(String[]args){
        //Users u = new Users();
        Users u2 = new Users();
        //u.update_User("Chiratidzo", "Matowe","Software Developer", "N01311820R", "Boyfriendsname");
        //u.update_User("Brandon", "Nyoni", "Developer", "N0136662H","011Chelsea");
        //u.deleteUser("N01311820R");
        //u2 = u.viewUser("N01311820R");
        
        if ( u2 == null){
         System.out.println("USER NOT FOUND");
        }else{
           System.out.println(u2.name + "" +  u2.surname + "FOUND");
        }
       
    }    
	
    public  void addUser(String name, String surname, String job_title, String userID, String password){
         String query = "INSERT INTO user (name , surname , job_title, user_id, password) VALUES ('" + name + "','" + surname +"','"+ job_title +"','" + userID + "','"+ password +"')";
        try {
            db.insert_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
	
    public void update_User(String name, String surname,String job_title, String userID, String password){
          String query = "UPDATE user SET name ='" + name + "', surname ='" + surname + "',job_title='"+ job_title + "',password='" +password+ "'WHERE user_id ='" + userID +"'";
      try {
            db.update_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
	
    public  void deleteUser(String userID){
         String query = "DELETE FROM user WHERE user_id ='" + userID +"'";
        try {
            db.delete(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
	
    public  Users viewUser(String userID){
         String query = " SELECT * FROM user WHERE user_id= '" + userID + "'";
        Users u = new Users();
        
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                
                u.name = rs.getString("name");
                u.surname = rs.getString("surname");
                u.job_title=rs.getString("job_title");
                u.userID = rs.getString("user_id");
                u.password = rs.getString("password");
               
                 
                return  u;
        
            }
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                
           }
        return null;
        
    }
    public List<Users> view_Users(){
        String query = " SELECT * FROM user";
        List<Users> UsersList = new ArrayList <Users>();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Users u = new Users();
                u.name = rs.getString("name");
                u.surname = rs.getString("surname");
                u.job_title=rs.getString("job_title");
                u.userID = rs.getString("user_id");
                u.password = rs.getString("password");
                UsersList.add(u);
            }
            return UsersList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                
           }
        return null;
    }
}


 