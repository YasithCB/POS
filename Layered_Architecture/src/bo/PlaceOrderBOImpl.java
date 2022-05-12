package bo;

import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailsDAO;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.OrderDAOImpl;
import dao.custom.impl.OrderDetailsDAOImpl;
import db.DBConnection;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOImpl {

    private final ItemDAO itemDAO = new ItemDAOImpl();
    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();

    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/

        Connection connection = DBConnection.getDbConnection().getConnection() ;
        /*if order id already exist*/
        if (orderDAO.exists(orderId)) {

        }

        if (!orderDAO.insert(new OrderDTO(orderId, orderDate, customerId))) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }

        for (OrderDetailDTO dto : orderDetails) {

            if (!orderDetailsDAO.insert(new OrderDetailDTO(orderId, dto.getItemCode(), dto.getQty(), dto.getUnitPrice()))) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            //Search & Update Item
//            ItemDTO item = findItem(dto.getItemCode());
            ItemDTO item = null;
            item.setQtyOnHand(item.getQtyOnHand() - dto.getQty());

            if (!itemDAO.update(item)) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;

    }
}
