package dao.custom;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO {
    ArrayList<CustomerDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}
