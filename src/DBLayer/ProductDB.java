
package DBLayer;
import ModelLayer.Product;
import java.sql.*;

public class ProductDB implements ProductDBIF {

    @Override
    public void create(String name, String barcode, int productionTime, int price, int stock, String requiredMatID) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String query = " INSERT INTO Product (Name, Barcode, Price, Stock, Production_Time, RequiredMatID)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, barcode);
            preparedStmt.setDouble(3, price);
            preparedStmt.setInt(4, stock);
            preparedStmt.setInt(5, productionTime);
            preparedStmt.setString(6, requiredMatID);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean update(Product product) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String barcode=product.getBarcode();
            String name = product.getName();
            double price = product.getPrice();
            int stock = product.getStock();
            int productionTime=product.getProductionTime();
            //ArrayList<RAW_Material> rawMaterials=product.getRawMaterials();
            PreparedStatement psttm = conn.prepareStatement("UPDATE Product SET Name = ?, Price = ?, Stock = ?, Production_Time = ? WHERE barcode = ? ");
            //psttm.setInt(1,curentQuantity);
            psttm.setNString(1,name);
            psttm.setDouble(2,price);
            psttm.setInt(3,stock);
            psttm.setInt(4,productionTime);
            psttm.setNString(5,barcode);
            psttm.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }
    @Override
    public boolean delete(String barcode) throws SQLException {
        try {
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("Delete from Product where barcode='%s'", barcode);
            conn.createStatement().executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            DBConnection.closeConnection();
        }
        return true;
    }
    @Override
    public Product read(String barcode) throws SQLException{
        Product product = null;
        try{
            Connection conn = DBConnection.getInstance().getDBcon();
            String sql = String.format("SELECT * FROM Product where barcode=%s",barcode);
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()){
                product = buildObject(rs);
            }
        } finally{
            DBConnection.closeConnection();
        }
        return product;
    }

    private static Product buildObject(ResultSet rs) throws SQLException{
        Product product;
        try {
            String name = rs.getString(1);
            String barcode = rs.getString(2);
            int price = rs.getInt(3);
            int stock = rs.getInt(4);
            int productionTime = rs.getInt(5);
            String requiredMatID=rs.getString(6);
            product = new Product(name,barcode,price,stock,productionTime,requiredMatID);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return product;
    }
}
