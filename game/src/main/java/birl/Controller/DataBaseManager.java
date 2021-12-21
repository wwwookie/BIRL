package birl.Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            /* debug
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", good against: " + rs.getString("good_against"));
            System.out.println(", bad against: " + rs.getString("bad_against"));*/

            System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectNameFromTableByID(String table, int id){

        try(Connection conn = DriverManager.getConnection(url, user, pwd);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM " + table + " WHERE id = " + id);
        ) {	
            rs.next();	      
            return rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  Search for in query specified values in query's table by id.
     * @param query - This query will be resolved. Must look like "SELECT attribute(s) FROM table WHERE id = int value".
     * @param id    - Search table for attributes by this param.
     * @return      - String representing query result.
     * @throws Exception
     */
    
    /* IDK if i will need this..
    public String searchTableById(String query, int id) throws Exception{
        
        ArrayList<String> selectedArrtibutes = new ArrayList<>();
        String table;
        
        // walk through query-String and collect data (which attribute(s)/table)
        if(query.startsWith("SELECT") || query.startsWith("select")){

            int index;

            // cut select statement
            query = query.substring(6);

            // get attributes
            while(query.indexOf(",") != -1){
                selectedArrtibutes.add(query.substring(0, query.indexOf(",") - 1));
                query.substring(query.indexOf(","));
            }


        } else throw new Exception("Query incorrect, must start with SELECT/select");


    }*/

    // TODO: find smart way to print out query, no matter which.
    // above while-loop is pretty static...
}