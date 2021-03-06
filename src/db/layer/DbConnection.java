package db.layer;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DbConnection {
    private static final String driver = "jdbc:sqlserver://kraka.ucn.dk";
    private static final String databaseName = ";databaseName=dmaj0916_197353";

    private static java.sql.Connection con;

    // an instance of the class is generated
    private static DbConnection instance = null;

    // the constructor is private to ensure that only one object of this class is created
    private DbConnection() {
        String password = ";password=Password1!";
        String userName = "; user=dmaj0916_197353";
        String url = driver + databaseName + userName + password;

        try {
            //load of driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");

        } catch (Exception e) {
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        try {
            //connection to the database
            con = DriverManager.getConnection(url);
            con.setAutoCommit(true);
            DatabaseMetaData dma = con.getMetaData();
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }//end try
        catch (Exception e) {
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor

    //closeDb: closes the connection to the database
    public static void closeConnection() {
        try {
            con.close();
            instance = null;
            System.out.println("The connection is closed");
        } catch (Exception e) {
            System.out.println("Error trying to close the database " + e.getMessage());
        }
    }//end closeDB

    //getDbCon: returns the singleton instance of the DB connection
    public java.sql.Connection getDbCon() {
        return con;
    }

    //this method is used to get the instance of the connection
    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }
}