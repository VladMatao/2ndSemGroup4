package DBLayer;

import ModelLayer.Statistics;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  StatisticsDBIF {

    void create(String productBarcode, int revenue, int quantity) throws SQLException;
    boolean update (Statistics stats, String id ) throws SQLException;
    boolean delete (String id) throws SQLException;
    Statistics read(String id) throws SQLException;
}
