package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> all = new ArrayList<>();
        while (rs.next()) {
            all.add(new Customer(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }
        return all;
    }

    @Override
    public boolean insert(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exists(String s) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT id FROM customer WHERE id=?", s);
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
    public Customer search(String s) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM Customer WHERE id=?", s);
        while (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        }
        return null;
    }

}
