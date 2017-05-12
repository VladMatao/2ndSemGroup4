package DBLayer;
import ModelLayer.Person;
import java.sql.*;

/**
 * Created by Alexander on 5/10/2017.
 */
public class PersonDB implements PersonDBIF {
      public void create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage) throws SQLException {
          try {
              Connection conn = DBConnection.getInstance().getDBcon();
              String query = " INSERT INTO Person (id, f_name, l_name, CNP, address, phNr, city, position, wage)" + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

              // create the mysql insert preparedstatement

              PreparedStatement preparedStmt = conn.prepareStatement(query);
              preparedStmt.setString(1, id);
              preparedStmt.setString(2, f_name);
              preparedStmt.setString(3, l_name);
              preparedStmt.setInt(4, CNP);
              preparedStmt.setString(5, address);
              preparedStmt.setString(6, phNr);
              preparedStmt.setString(7, city);
              preparedStmt.setString(8, position);
              preparedStmt.setDouble(9, wage);

              // execute the preparedstatement
              preparedStmt.execute();

              conn.close();
          } catch (Exception e) {
              System.err.println("Got an exception!");
              System.err.println(e.getMessage());
          }
      }


    /*public Person create(String id, String f_name, String l_name, int CNP, String address, String phNr, String city, String position, double wage)
    {
        Person person = new Person(id,f_name,l_name,CNP,address,phNr,city,position, double, wage);
        String sql = String.format("INSERT INTO Product VALUES ('%s', '%s', '%d', '%d', '%d', '%s') ",name,barcode,price,stock,productionTime,requiredMatID);


        try {
            java.sql.Connection conn = DBConnection.getInstance().getDBcon();
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBConnection.closeConnection();
        }
        return product;
    }*/

    public boolean update(Person person) throws SQLException {
        try{
            Connection conn = DBConnection.getInstance().getDBcon();
            String id = person.getId();
            String f_name = person.getF_name();
            String l_name = person.getL_name();
            int CNP = person.getCNP();
            String address = person.getAddress();
            String city = person.getCity();
            double wage = person.getWage();
            String position = person.getposition();
            String phNr = person.getPhNr();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Person SET f_name = ?, l_name = ?,CNP = ? address = ?, phNr = ?, city = ?,  function = ?, wage = ?, WHERE id = ?");
            psttm.setNString(2,f_name);
            psttm.setNString(3,l_name);
            psttm.setInt(4,CNP);
            psttm.setNString(5,address);
            psttm.setNString(6,city);
            psttm.setNString(7,phNr);
            psttm.setNString(8,position);
            psttm.setDouble(9,wage);
            psttm.executeLargeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    public Person read(String id) throws SQLException{
        Person person = null;
        try{
            ResultSet rs;
            try (Connection conn = DBConnection.getInstance().getDBcon()) {
                String sql = String.format("SELECT * FROM Person where PersonID=%s", id);
                rs = conn.createStatement().executeQuery(sql);
            }
            if (rs.next()){
                person = buildObject(rs);
            }
        }catch (SQLException e) {
            throw e;
        }finally{
            DBConnection.closeConnection();
        }
        return person;
    }

    private static Person buildObject(ResultSet rs) throws SQLException{
        Person person;
        try {
            String id = rs.getString(1);
            String f_name = rs.getString(2);
            String l_name = rs.getString(3);
            int CNP = rs.getInt(4);
            String address = rs.getString(5);
            String phNr = rs.getString(6);
            String city = rs.getString(7);
            String position = rs.getString(8);
            double wage = rs.getDouble(9);
            person = new Person(id, f_name, l_name, CNP, address, phNr, city, position, wage);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return person;
    }

    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Person where PersonID='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }


    public String getId() {
        Person person = null;
        return person.getId();
    }
}
