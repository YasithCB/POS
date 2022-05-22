package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
     ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

     boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

     void updateCustomerDetails(CustomerDTO customerDTO)throws SQLException, ClassNotFoundException;

     boolean isCustomerExists(String id) throws SQLException, ClassNotFoundException;

     void deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     String generateNewCustomerId() throws SQLException, ClassNotFoundException;

}
