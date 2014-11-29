/*
Author: Terianne LeBlanc Bolding
CLID: TLL6799
Class: CMPS-360
Assignment: Project 4
Due Date: December 6th 11:55 pm
Description:Reprise Project 3, but with a HTML/JavaServer Pages user interface or a JavaServer Faces user interface.  
The site must be password protected.  As there is no password table in the database, it is OK to embed the password in the JSP code,
but every page used in a session must be accessible only if the user has entered the correct password at the starting page.

 */

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "secureBean")
@SessionScoped


public class SecureBean implements Serializable{

     String Admin; //Username from user
     String AdminPw; // Password from user
     Boolean isAuthenticated; //Check if the user has been authenticated this session
    
     /**
Prototype: public SecureBean();
Description: Constructor for SecureBean which handles the authentication services for the app
Postcondition(s): User is authenticated
Visibility: Public*/     
    public SecureBean() {
        isAuthenticated = false;
        
    }

    /**Admin gette
     * @return r*/
    public String getAdmin() {
        return Admin;
    }

    /**Admin setter
     * @param Admin*/
    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }
    /**AdminPw getter
     * @return */
    public String getAdminPw() {
        return AdminPw;
    }
    /**AdminPw setter
     * @param AdminPw*/
    public void setAdminPw(String AdminPw) {
        this.AdminPw = AdminPw;
    }
    /**isAuthenticated getter
     * @return */
    public Boolean isIsAuthenticated() {
        return isAuthenticated;
    }
    /**isAuthenticated setter
     * @param isAuthenticated
     */
    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
      /**
Prototype: String userValidate();
Description: Check username and password
Postcondition(s): User is either authenticated are informed that the password or username is incorrect.
Visibility: Public        
     * @return */        
    public String userValidate(){
    if(Admin.equals("admin") && AdminPw.equals("9999")){
        isAuthenticated = true;
        return "index.xhtml";
    }
    else{
        isAuthenticated = false;
        return "LoginFailed.xhtml";
    }
    }

}
