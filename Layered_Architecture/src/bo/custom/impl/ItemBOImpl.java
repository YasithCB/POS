package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    @Override
    public void saveCustomer(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.insert(itemDTO);
    }

    @Override
    public void updateCustomer(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(itemDTO);
    }

    @Override
    public boolean isCustomerExists(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exists(code);
    }

    @Override
    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
}
