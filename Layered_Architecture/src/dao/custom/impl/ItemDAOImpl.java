package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM item");
        ArrayList<Item> all = new ArrayList<>();
        while (rs.next()) {
            all.add(new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(4),
                    rs.getBigDecimal(3)
            ));
        }
        return all;
    }

    @Override
    public boolean insert(Item entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",entity.getDescription(), entity.getUnitPrice(), entity.getQtyOnHand(), entity.getCode());
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
    public Item search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?", s);
        while (rs.next()) {
            return new Item(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getBigDecimal(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Item> getItemsPriceAbove(double price) throws SQLException, ClassNotFoundException {
        return null;
    }

}
