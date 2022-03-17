package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection   {

    private static Connection connection = null ;

    static 
    {
        try{
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/cyberent","root","password"); //change your password here
            System.out.println("Database Connected");
        }catch(Exception ex)
        {
            System.out.println("Database Connection Failed.");
        }
    }

    public static Connection getConnection() { return connection; }

}