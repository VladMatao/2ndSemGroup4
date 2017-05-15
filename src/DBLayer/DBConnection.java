package DBLayer;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnection {
    private static final String  driver = "jdbc:sqlserver://kraka.ucn.dk";
    private static final String  databaseName = ";databaseName=dmaj0916_197353";

    private static String  userName = "; user=dmaj0916_197353";
    private static String password = ";password=Password1!";

    private DatabaseMetaData dma;
    private static java.sql.Connection con;

    // an instance of the class is generated
    private static DBConnection  instance = null;

    // the constructor is private to ensure that only one object of this class is created
    private DBConnection()
    {
        String url = driver + databaseName + userName + password;

        try{
            //load of driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");
        }
        catch(Exception e){
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url);
            con.setAutoCommit(true);
            dma = con.getMetaData(); // get meta data
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }
        catch(Exception e){
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }
    }

    public static void closeConnection()
    {
        try{
            con.close();
            instance= null;
            System.out.println("The connection is closed");
        }
        catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
        }
    }

    //getDBcon: returns the singleton instance of the DB connection
    public java.sql.Connection getDBcon()
    {
        return con;
    }

    public static boolean instanceIsNull()
    {
        return (instance == null);
    }

    public static DBConnection getInstance()
    {
        if (instance == null)
        {
            instance = new DBConnection();
        }
        return instance;
    }
}