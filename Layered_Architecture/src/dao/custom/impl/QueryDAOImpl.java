package dao.custom.impl;

import dao.custom.QueryDAO;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<CustomerDTO> searchOrderByOrderID(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
