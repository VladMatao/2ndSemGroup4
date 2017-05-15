package DBLayer;

import ModelLayer.RAW_Material;

import java.sql.SQLException;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  RawMaterialDBIF {

    void create(String barcode, String id) throws SQLException;
    boolean update (RAW_Material rawMat, String barcode) throws SQLException;
    boolean delete (String barcode) throws SQLException;
    RAW_Material read(String barcode) throws SQLException;
}
