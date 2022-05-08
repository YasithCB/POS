package dao;

import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CrudDAO<CustomerDTO, String> {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM customer");
        ArrayList<CustomerDTO> all = new ArrayList<>();
        while (rs.next()) {
            all.add(new CustomerDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }
        return all;
    }

    @Override
    public boolean insert(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
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
    public CustomerDTO search(String s) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.executeQuery("SELECT * FROM Customer WHERE id=?", s);
        while (resultSet.next()) {
            return new CustomerDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        }
        return null;
    }

    /*public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
        ArrayList allCustomers = new ArrayList();
        while (rst.next()){
            allCustomers.add(new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        return allCustomers;
    }

    public boolean insertCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
    }

    public boolean existsCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id).next();
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
    }

    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    public CustomerDTO SearchCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer WHERE id=?",id);
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
        return customerDTO;
    }*/
}
