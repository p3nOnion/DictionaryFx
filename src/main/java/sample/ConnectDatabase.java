package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    public static void connect ( ) throws SQLException {
        //jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
        try (Connection con = DriverManager.getConnection ( "jdbc:oracle:thin:@localhost:8088" , "root" , "usbw" )) {


            if ( con != null ) {
                System.out.println ( "Connected" );
            } else System.out.println ( "Disconnected" );
        }
    }
}
