package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allDTO = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item item : all){
            allDTO.add(new ItemDTO(
                    item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand()
            ));
        }
        return allDTO;
    }

    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    @Override
    public void saveCustomer(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.insert(new Item(
                itemDTO.getCode(),
                itemDTO.getDescription(),
                itemDTO.getQtyOnHand(),
                itemDTO.getUnitPrice()
        ));
    }

    @Override
    public void updateCustomer(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(new Item(
                itemDTO.getCode(),
                itemDTO.getDescription(),
                itemDTO.getQtyOnHand(),
                itemDTO.getUnitPrice()
        ));
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
