package bo;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }

    // singleton
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    // public final static integer values
    public enum BOTypes{
        CUSTOMER, ITEM, ORDER
    }

    // method for hide the object creation logic and return what client want
    public SuperBO getBO(BOFactory.BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
