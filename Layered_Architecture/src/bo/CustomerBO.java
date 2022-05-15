package bo;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
     ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

     void saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

     void updateCustomerDetails(CustomerDTO customerDTO)throws SQLException, ClassNotFoundException;

     boolean isCustomerExists(String id) throws SQLException, ClassNotFoundException;

     void deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     String generateNewCustomerId() throws SQLException, ClassNotFoundException;

}
