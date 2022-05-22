package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allDTO = new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer customer : all){
            allDTO.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress()
            ));
        }
        return allDTO;
    }

    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.insert(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        ));

    }

    @Override
    public void updateCustomerDetails(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.update(new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        ));
    }

    @Override
    public boolean isCustomerExists(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exists(id);
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewId();
    }
}
