package dao;

import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean insert(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean exists(ID id) throws SQLException,ClassNotFoundException;
    boolean delete(ID id) throws SQLException,ClassNotFoundException;
    String generateNewId() throws SQLException,ClassNotFoundException;
    T Search(ID id) throws SQLException,ClassNotFoundException;
}
