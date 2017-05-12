package DBLayer;

import ModelLayer.RAW_Material;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  RawMaterialDBIF  {

    void create(String barcode, String name) throws SQLException;
    boolean update (RAW_Material rawMat ) throws SQLException;
    boolean delete (String id) throws SQLException;
    RAW_Material read(String id) throws SQLException;
}
