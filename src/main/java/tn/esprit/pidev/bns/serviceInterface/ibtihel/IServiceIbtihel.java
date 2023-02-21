package tn.esprit.pidev.bns.serviceInterface.ibtihel;

import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.Delivery;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;

import java.util.List;

public interface IServiceIbtihel {


    //cart

    public Cart addCart(Cart cart);
    public Cart updateCart(Cart cart);
    public Cart deleteCart(Integer idCart);

    List<Cart> ListCart();

    public Cart ListCartById(Integer idCart);

 //order
    public PurchaseOrder addPurchaseOrder(PurchaseOrder order);
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder order);


    List<PurchaseOrder> ListPurchaseOrder();

    public PurchaseOrder ListOrderById(Integer idOrder);

    //delivery

    public Delivery addDelivery(Delivery delivery);
    public Delivery updateDelivery(Delivery delivery);

    public Delivery deleteDelivery(Integer idDelivery);

    List<Delivery> ListDelivery();

    public Delivery ListDeliveryById(Integer idDelivery);
}
