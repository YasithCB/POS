package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {

    boolean placeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String code);

    CustomerDTO searchCustomer(String id);

    ItemDTO searchItem(String code);

    boolean isItemExists(String code);

    boolean isCustomerexists(String id);

    String generateNewOrderId();

    ArrayList<CustomerDTO> getAllCustomers();

    ArrayList<ItemDTO> getAllItems();
}
