package dao;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO,String>{

    public ArrayList<ItemDTO> getItemsPriceAbove(double price) throws SQLException, ClassNotFoundException;

}
