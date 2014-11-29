/*Author: Terianne LeBlanc Bolding
CLID: TLL6799
Class: CMPS-360
Assignment: Project 3
Due Date: November 23rd 11:55 pm
Description:Using the provided NetBeans project, create a client system for the database that allows the user, via a selection from a menu, to
● list
◦ ids and student names in the database
◦ courses in the database with course ids
◦ majors in the database with major ids
◦ students with a given major
◦ students in a course in the database
● list
◦ schedule of one student in the database
◦ name, address and major of one student in the database
● add a
◦ new student to the database
◦ new course to the database
◦ new major to the database
● enroll a student in a course in the database
● exit the program
*/
package socketmckoidb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AddQuerys {
    public Connection connection;
    public List<Results> resultList = new ArrayList<Results>();
    public AddQuerys(){
                // ******************************************************
        // ****************  Connecting to datatbase  ***********
        // ******************************************************
        
        // Register Mckoi JDBC driver
        try {
            Class.forName("com.mckoi.JDBCDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Cannot register driver: " + e);
            return;
        }
        
        // URL for local database with configuration file
        String url = "jdbc:mckoi://localhost:9157/BedrockU.conf?create=false";        
        
        // create root user info
        String admin = "admin";
        String adminPw = "9999";
        
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }
    
    }
     /**
Prototype: public static void newStudent(String id, String name, String majorId);
Description: Add a new student to the database.
Precondition(s): Database online at localhost:9157 and created and non duplicate information passed as paramaters.
Postcondition(s): A new student has been added to the database.
Visibility: Public
*/   
    public String newStudent(String id, String name, String majorId){
     

       
         // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try{
         Statement statement = connection.createStatement();
                    statement.executeQuery(
                        "INSERT INTO Student(id, name, majorId) VALUES " +
                        "(" + id + ", '" + name + "', " + majorId + ")"
                    );
           
            System.out.println("Insertion accepted");
            return "Insertion Accepted";
        } 
        catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return "Insertion Not Accepted";
        }
        
    }
     /**
Prototype: public static void newCourse(String id,String courseDesc);
Description: Add a new course to the database.
Precondition(s): Database online at localhost:9157 and created and non duplicate information passed as paramaters.
Postcondition(s): A new course has been added to the database.
Visibility: Public
*/   
    public Boolean newCourse(String id,String courseDesc){
       
         // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try{
         Statement statement = connection.createStatement();
                    statement.executeQuery(
                        "INSERT INTO Course(courseId, courseDesc) VALUES " +
                        "(" + id + ", '" + courseDesc + "')"
                    );
           System.out.println("Insertion accepted");
            return true;
        } 
        catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return false;
        }
        
    }
     /**
Prototype: public static void newMajor(String id,String majorDesc);
Description: Add a new major to the database.
Precondition(s): Database online at localhost:9157 and created and non duplicate information passed as paramaters.
Postcondition(s): A new major has been added to the database.
Visibility: Public
*/   
     public Boolean newMajor(String id,String majorDesc){
        try{
         Statement statement = connection.createStatement();
                   statement.executeQuery(
                        "INSERT INTO Major(majorId, majorDesc) VALUES " +
                        "(" + id + ", '" + majorDesc + "')"
                    );
                   System.out.println("Insertion accepted");
           return true;
            
        } 
        catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return false;
        }
        
    }
     /**
Prototype: public static void AddStudentCourse(String studentId,String courseId );
Description: Enroll a student in a course.
Precondition(s): Database online at localhost:9157 and created and accurate information passed as parameters.
Postcondition(s): Student has been enrolled in the course.
Visibility: Public
*/
         public Boolean AddStudentCourse(String studentId,String courseId ){
         // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try{
         Statement statement = connection.createStatement();
                    statement.executeQuery(
                        "INSERT INTO Enrolled(id, courseId) VALUES " +
                        "(" + studentId + ", " + courseId + ")"
                    );
                   System.out.println("Insertion accepted");
           
            return true;
        } 
        catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return false;
        }
        
    }
     /**
Prototype: public static void newAddress(String id,String address,String city,String state,String zip);
Description: Add an address 
Precondition(s): Database online at localhost:9157 and non duplicate information passed as paramaters.
Postcondition(s): Address has been added.
Visibility: Public
*/
    public String newAddress(String id,String address,String city,String state,String zip){
       
         // ******************************************************
        // ****************  Querying datatbase  ****************
        // ******************************************************
        try{
         Statement statement = connection.createStatement();
                    statement.executeQuery(
                        "INSERT INTO Address(id, street, city, state, zip) VALUES " +
                        "(" + id + ", '" + address + "', '" + city + "', '" +
			      state + "', '" + zip + "')"
                    );
                   System.out.println("Insertion accepted");
                   return "Insertion Accepted";
            
        } 
        catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return "Instertion Failed";
        }
        
    }
    
    }


