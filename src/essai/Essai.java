/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai;
import java.sql.*;

/**
 *
 * @author Omar Ghlila
 */
public class Essai {
    

    
    public static void main(String[] args) {
        // TODO code application logic here
        Connection cnx= connecterDB();
    }
    public static Connection connecterDB(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Driver okey");
           String url ="jdbc:mysql://localhost:3306/pfe";
           String user="root";
           String password="omar";
           Connection cnx= DriverManager.getConnection(url,user,password);
           System.out.println("Connexion bien établie");
           return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
