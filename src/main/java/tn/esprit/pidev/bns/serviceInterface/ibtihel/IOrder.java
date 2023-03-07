package tn.esprit.pidev.bns.serviceInterface.ibtihel;

import com.stripe.exception.StripeException;
import tn.esprit.pidev.bns.entity.ibtihel.Payment;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;

import java.util.List;

public interface IOrder {

    //order

    public PurchaseOrder confirmPurchaseOrder(PurchaseOrder order);
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder order);

    List<PurchaseOrder> ListPurchaseOrder();

    public PurchaseOrder ListOrderById(Integer idOrder);

    public int TotalOrdersTVA (int idOrder);

    public Payment payment(int idUser, int idOrder, Payment p) throws StripeException;
    public double createCharge(String token, int idUser, int idOrder) throws StripeException ;



}
