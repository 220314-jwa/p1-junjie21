package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private static Connection connection = null;

    public static Connection getConnection(){
        // if there is no connection yet:

            String url = "jdbc:postgresql://localhost:5432/postgres";
            String username = "postgres";
            String password = "jy89611768++";

            // try to connect to the database:
            try{
                connection = DriverManager.getConnection(url,username,password);
            }catch(SQLException e){
                e.printStackTrace();
            }

        return connection;
    }
}
