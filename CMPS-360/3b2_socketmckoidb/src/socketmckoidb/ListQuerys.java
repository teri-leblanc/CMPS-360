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


public class ListQuerys {
    
     /**
Prototype: public static void IdandName();
Description: List all Names with IDs
Precondition(s): Database online at localhost:9157.
Postcondition(s): All Names and IDs outputted to the terminal.
Visibility: Public
*/    
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
            System.out.println("**********************************************");
            System.out.println("Student Ids and Names:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.print(" : " +result.getString(2));
                System.out.println("\n");
            System.out.println("**********************************************");               
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }
     /**
Prototype: public static void IdandCourse();
Description: List all Courses with IDs
Precondition(s): Database online at localhost:9157.
Postcondition(s): All Courses and IDs outputted to the terminal.
Visibility: Public
*/    
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
            System.out.println("**********************************************");
            System.out.println("Course Ids and Descriptions:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.print(" : " +result.getString(2));
                System.out.println("\n");
            System.out.println("**********************************************");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    }  
     /**
Prototype: public static void IdandMajor();
Description: List all Majors with IDS.
Precondition(s): Database online at localhost:9157.
Postcondition(s): All Majors and IDs outputted to the terminal.
Visibility: Public
*/    
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
            System.out.println("**********************************************");
            System.out.println("Course Ids and Descriptions:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.print(" : " +result.getString(2));
                System.out.println("\n");
                 System.out.println("**********************************************");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    
    
    }
      /**
Prototype: public static void StudentMajor();
Description: List all Students and their given majors
Precondition(s): Database online at localhost:9157.
Postcondition(s): All Students and their given majors outputted to the terminal.
Visibility: Public
*/    
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
             System.out.println("**********************************************");
            System.out.println("Course Ids and Descriptions:\n");
            while(result.next()) {
                System.out.print(result.getString(1)+" : "+result.getString(2));
                System.out.println("\n");
                 System.out.println("**********************************************");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }
    
    }
      /**
Prototype: public static void StudentCourse();
Description: List all students and their given course enrollment.
Precondition(s): Database online at localhost:9157.
Postcondition(s): All Students with their enrolled courses outputted.
Visibility: Public
*/       
    
    public static void StudentCourse(){
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
             System.out.println("**********************************************");
            System.out.println("Students in a course in the database:\n");
            while(result.next()) {
                System.out.print(result.getString(1)+" : "+result.getString(2));
                System.out.println("\n");
                 System.out.println("**********************************************");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }

    
    
    }
      /**
Prototype: public static void StudentSchedule(int id);
Description: List the passed students schedule.
Precondition(s): Database online at localhost:9157 and valid student ID passed.
Postcondition(s): Students schedule outputted.
Visibility: Public
*/ 
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
             System.out.println("**********************************************");
            System.out.println("Students in a course in the database:\n");
            while(result.next()) {
                System.out.print(result.getString(1));
                System.out.println("\n");
                 System.out.println("**********************************************");
            }
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }

    
    
    }
      /**
Prototype: public static void StudentInfo(int id);
Description: List the passed students Name, Address, and Major.
Precondition(s): Database online at localhost:9157 and valid student ID passed.
Postcondition(s): Students info is outputted to the terminal.
Visibility: Public
*/ 
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
             System.out.println("**********************************************");
            System.out.println("Students in a course in the database:\n");
            while(result.next()) {
                System.out.print(result.getString(1)+" : "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" : "+result.getString(6));
                System.out.println("\n");
                 
            }
            System.out.println("**********************************************");
            
        } catch (SQLException e) {
            System.out.println("Error querying database: " + e);
            return;
        }

    
    
    }
    
    }

