package bo.custom;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    void deleteItem(String code) throws SQLException, ClassNotFoundException;

    void saveCustomer(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    void updateCustomer(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean isCustomerExists(String code) throws SQLException, ClassNotFoundException;

    String generateNewItemCode() throws SQLException, ClassNotFoundException;
}
