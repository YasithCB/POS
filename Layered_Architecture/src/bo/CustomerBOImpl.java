package bo;

import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        try {
            return customerDAO.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        try {
            customerDAO.insert(customerDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomerDetails(CustomerDTO customerDTO) {
        try {
            customerDAO.update(customerDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCustomerExists(String id) {
        try {
            return customerDAO.exists(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteCustomer(String id) {
        try {
            customerDAO.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewId();
    }
}
