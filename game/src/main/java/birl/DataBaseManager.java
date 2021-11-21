package birl;

import java.sql.*;

/**
 * This class handles the connection to the BIRL database.
 */
public class DataBaseManager {

    private static String url;
    private static String user;        // change to 'postgres'?
    private static String pwd;

    public DataBaseManager(String url, String user, String pwd){
        DataBaseManager.url = url;
        DataBaseManager.user = user;
        DataBaseManager.pwd = pwd;
    }

    public void executeQuery(String query){

        try(Connection conn = DriverManager.getConnection(url, user, pwd);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ) {		      
            while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", good against: " + rs.getString("good_against"));
            System.out.println(", bad against: " + rs.getString("bad_against"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: find smart way to print out query, no matter which.
    // above while-loop is pretty static... 
}