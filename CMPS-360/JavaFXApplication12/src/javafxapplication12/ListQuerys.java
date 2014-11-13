/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Teri
 */
public class ListQuerys {
    
    
    public static void IdandName(){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
                "SELECT Student.id, Student.name " +
                "FROM Student"
            );
            
            // display result of query
            System.out.println("Student Ids and Names:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.print(" : " +result.getString(2));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }
    public static void IdandCourse(){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
                "SELECT courseId, courseDesc " +
                "FROM Course"
            );
            
            // display result of query
            System.out.println("Course Ids and Descriptions:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.print(" : " +result.getString(2));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }  
    public static void IdandMajor(){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
                "SELECT majorId, majorDesc " +
                "FROM Major"
            );
            
            // display result of query
            System.out.println("Course Ids and Descriptions:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.print(" : " +result.getString(2));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    
    
    }
    public static void StudentMajor(){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
            "SELECT Student.name, Major.majorDesc" + 
                    " FROM Student, Major"+
                    " WHERE Student.majorId=Major.majorId"
            );
            
            // display result of query
            System.out.println("Course Ids and Descriptions:\n");
            while(result.next()) {
                System.out.print(result.getString(1)+":"+result.getString(2));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    
    }    public static void StudentCourse(){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
            "SELECT Student.name, Course.courseDesc" + 
                    " FROM Student, Enrolled,Course"+
                    " WHERE Student.id=Enrolled.id AND Enrolled.courseId=Course.courseId"
            );
            
            // display result of query
            System.out.println("Students in a course in the database:\n");
            while(result.next()) {
                System.out.print(result.getString(1)+":"+result.getString(2));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }

    
    
    }
    public static void StudentSchedule(int id){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
            "SELECT Course.courseDesc" + 
                    " FROM Course, Enrolled"+
                    " WHERE "+id+"=Enrolled.id AND Enrolled.courseId=Course.courseId"
            );
            
            // display result of query
            System.out.println("Students in a course in the database:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }

    
    
    }
        public static void StudentInfo(int id){
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
        
        // make a connection to the database
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, admin, adminPw);
        } catch (SQLException e) {
            System.out.println("cannot connect to database: " + e);
            return;
        }



        // ******************************************************
        // ****************  Querying datatbase  ****************
try {
            // create a Statement object for query execution
            Statement statement = connection.createStatement();
            // create a result object
            ResultSet result;
            
            // query to get addresses of students
            result = statement.executeQuery(
            "SELECT Student.name,Address.street, Address.city, " + 
                        "Address.state, Address.zip,Major.majorDesc" +
                    " FROM Student, Address, Major"+
                    " WHERE "+id+"=Student.id AND Student.id = Address.id AND Student.majorId = Major.majorId"
            );
            
            // display result of query
            System.out.println("Students in a course in the database:\n");
            while(result.next()) {
                System.out.print(result.getString(1)+result.getString(2)+result.getString(3)+result.getString(4)+result.getString(5)+":"+result.getString(6));
                System.out.println("\n");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }

    
    
    }
    
    }

