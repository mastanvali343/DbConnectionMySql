/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novelefficient;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author java2
 */
public class Dbconnection {
 
    public static Connection getConnection() {
        Connection con = null;
        try {
    FileInputStream fis = new FileInputStream("dbinfo.properties");
    Properties p = new Properties();
    p.load(fis);
    String dname = p.getProperty("dname");
    String url = p.getProperty("url");
    String user = p.getProperty("user");
    String pass = p.getProperty("pass");
            Class.forName(dname);
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
  public static void main(String... ar) {
	Connection con = Dbconnection.getConnection();
	System.out.println(con);
}
}
