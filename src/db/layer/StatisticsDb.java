
package db.layer;

import model.layer.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project 2nd Semester Group 4 dmaj0916 UCN
 */

public class StatisticsDb implements StatisticsDbIf {

    @Override
    public void create(String productBarcode, int revenue, int quantity) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String query = " INSERT INTO Statistics (ProductBarcode, Revenue, Quantity)"
                    + " values (?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, productBarcode);
            preparedStmt.setInt(2, revenue);
            preparedStmt.setInt(3, quantity);


            // execute the preparedstatement
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
    }

    @Override
    public boolean update(Statistics stats, String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Statistics SET ProductBarcode = ?, Revenue = ?, Quantity = ? WHERE id = ? ");
            psttm.setString(1, stats.getProductBarcode());
            psttm.setInt(2, stats.getRevenue());
            psttm.setInt(3, stats.getQuantity());
            psttm.setString(4, id);
            psttm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        try {
            Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Statistics where Barcode='%s'", id);
            conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DbConnection.closeConnection();
        }
        return true;
    }

    @Override
    public Statistics read(String id) throws SQLException {
        Statistics stats = null;
        try {
            java.sql.Connection conn = DbConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM stats where Barcode =%s", id);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) {
                stats = buildObject(rs);
            }
        } finally {
            DbConnection.closeConnection();
        }
        return stats;
    }


    private static Statistics buildObject(ResultSet rs) throws SQLException {
        Statistics stats;
        try {
            String productBarcode = rs.getString(1);
            int revenue = rs.getInt(2);
            int quantity = rs.getInt(3);
            stats = new Statistics(productBarcode, revenue, quantity);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return stats;
    }
}
