package bo.custom;

import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO {

    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String code);

    CustomerDTO searchCustomer(String id);

    ItemDTO searchItem(String code);

    boolean isItemExists(String code);

    boolean isCustomerexists(String id);

    String generateNewOrderId();

    ArrayList<CustomerDTO> getAllCustomers();

    ArrayList<ItemDTO> getAllItems();
}
