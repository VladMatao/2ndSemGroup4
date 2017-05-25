package DBLayer;

import ModelLayer.Statistics;

import java.sql.SQLException;

/**
 Project 2nd Semester Group 4 dmaj0916 UCN
 */
public interface  StatisticsDBIF {

    void create(String productBarcode, int revenue, int quantity) throws SQLException;
    boolean update (Statistics stats, String id ) throws SQLException;
    boolean delete (String id) throws SQLException;
    Statistics read(String id) throws SQLException;
}
