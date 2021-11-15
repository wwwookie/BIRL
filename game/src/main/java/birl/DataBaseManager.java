package birl;

import java.sql.*;

/**
 * This class handles the connection to the BIRL database.
 */
public class DataBaseManager {

    private static String url;
    private static String user;        // change to 'postgres'?
    private static String pwd;
    private static String query;

    public DataBaseManager(String url, String user, String pwd, String query){
        DataBaseManager.url = url;
        DataBaseManager.user = user;
        DataBaseManager.pwd = pwd;
        DataBaseManager.query = query;
    }

    public void connectToDB(){

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
}