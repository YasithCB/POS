package bo;

import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    private final CustomerDAO crudDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> getAllCustomers() {
        try {
            return crudDAO.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveCustomer(CustomerDTO customerDTO) {
        try {
            crudDAO.insert(customerDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerDetails(CustomerDTO customerDTO) {
        try {
            crudDAO.update(customerDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isCustomerExists(String id) {
        try {
            return crudDAO.exists(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteCustomer(String id) {
        try {
            crudDAO.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        return crudDAO.generateNewId();
    }
}
