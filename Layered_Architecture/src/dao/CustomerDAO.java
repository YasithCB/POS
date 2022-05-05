package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    boolean insertCustomers(CustomerDTO customer) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean existsCustomer(String id) throws SQLException,ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException,ClassNotFoundException;
    String generateNewId() throws SQLException,ClassNotFoundException;
    CustomerDTO SearchCustomer(String id) throws SQLException,ClassNotFoundException;
}
