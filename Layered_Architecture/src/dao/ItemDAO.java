package dao;

import db.DBConnection;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {

     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

     boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

     boolean insertItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

     boolean existsItem(String code) throws SQLException, ClassNotFoundException ;

     String genarateNewCode() throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
}
