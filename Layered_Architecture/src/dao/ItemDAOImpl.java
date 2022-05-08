package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements CrudDAO<ItemDTO, String>{
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM item");
        ArrayList<ItemDTO> all = new ArrayList<>();
        while (rs.next()) {
            all.add(new ItemDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getBigDecimal(3),
                    rs.getInt(4)
            ));
        }
        return all;
    }

    @Override
    public boolean insert(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean exists(String s) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", s);
        return rs.next();
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?", s);
        while (rs.next()) {
            return new ItemDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getBigDecimal(4),
                    rs.getInt(3)
            );
        }
        return null;
    }

    /*public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        while (rst.next()){
            allItems.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(4),
                    rst.getInt(3)
            ));
        }
        return allItems;
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
    }

    public boolean insertItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    public boolean existsItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
    }

    public String genarateNewCode() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?");
        rst.next();
        ItemDTO item = new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }*/
}
