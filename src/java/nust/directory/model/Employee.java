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
public class Employee {
    String name;
    String surname;
    String employee_id;
    String job_title;
    String email_address;
    String extension;
    String title;
    String department_id;
    String floor;
    String office_number;
    int building_id;
    Database db = new Database();
    
    public static void main(String[]args){
        Employee u = new Employee();
        //u.addEmployee("Mthokozisi", "Nyoni", "4023", "Intern", "mthokozisi.nyoni@nust.ac.zw", "2407", "Mr", "SCS", "3", "AVU1");
        //u.updateEmployee("Mthokozisi", "Nyoni","0139", "Intern","mthokozisi.nyoni@nust.ac.zw", "4098", "Miss", "SRA", "1", "GDA2");
        //u.viewEmployee("4023");
        //u.deleteEmployee("4023");
    }
    
    public void  addEmployee( String name, String surname,String employee_id, String job_title,String email_address, String extension, String title, String department_id, String floor, String office_number,int building_id){
          String query = "INSERT INTO employee (name , surname ,employee_id, job_title, email_address, extension, title, department_id, floor, office_number, building_id ) VALUES ('" + name + "','" + surname +"','"+employee_id+"','" + job_title + "','"+ email_address +"','"+extension+"','"+title+"','"+department_id+"','"+floor+"','"+office_number+"',"+building_id+")";
        try {
            db.insert_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public  void updateEmployee(String name, String surname,String employee_id, String job_title,String email_address, String extension, String title, String department_id, String floor, String office_number,int building_id){
          String query = "UPDATE employee SET name ='" + name + "', surname ='" + surname + "',employee_id='"+ employee_id + "',job_title='"+ job_title +"',email_address='"+ email_address +"',extension='"+ extension +"',title='"+ title +"',department_id='"+ department_id +"',floor='"+ floor +"',office_number='"+ office_number +"',building_id ='" + building_id +"' WHERE employee_id ='" + employee_id +"'" ;
      try {
            db.update_db(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void deleteEmployee(String employee_id){
          String query = "DELETE FROM employee WHERE employee_id ='" + employee_id +"'";
        try {
            db.delete(query);
        } catch (Exception ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public Employee viewEmployee(String employee_id){
          String query = " SELECT * FROM employee WHERE employee_id= '" + employee_id + "'";
        Employee u = new Employee();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                
                u.name = rs.getString("name");
                u.surname = rs.getString("surname");
                u.employee_id = rs.getString("employee_id");
                u.job_title=rs.getString("job_title");
                u.email_address = rs.getString("email_address");
                u.extension = rs.getString("extension");
                u.title = rs.getString("title");
                u.department_id = rs.getString("department_id");
                u.floor = rs.getString("floor");
                u.office_number = rs.getString("office_number");
                u.building_id=parseInt(rs.getString("building_id"));
                conn.close(); 
                return  u;
        
            }
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                
           }
        return null;
    }
    
      public List<Employee> view_employee(){
        String query = " SELECT * FROM employee";
        List<Employee> EmployeeList = new ArrayList <Employee>();
       
        try {
            ResultSet rs = db.select_db(query);
            while (rs.next()){
                Employee u = new Employee();
                u.name = rs.getString("name");
                u.surname = rs.getString("surname");
                u.employee_id = rs.getString("employee_id");
                u.job_title=rs.getString("job_title");
                u.email_address = rs.getString("email_address");
                u.extension = rs.getString("extension");
                u.title = rs.getString("title");
                u.department_id = rs.getString("department_id");
                u.floor = rs.getString("floor");
                u.office_number = rs.getString("office_number");
                u.building_id=parseInt(rs.getString("building_id"));
                EmployeeList.add(u);
            }
            return EmployeeList;
        }catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                
           }
        return null;
    }
}
 
