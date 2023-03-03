package tn.esprit.pidev.bns.serviceInterface.ibtihel;

import com.stripe.exception.StripeException;
import tn.esprit.pidev.bns.entity.ibtihel.*;

import java.util.List;

public interface IServiceIbtihel {



    //commandline
    public CommandLine addCommandLine(CommandLine commandLine);
    public CommandLine updateCommandLine(CommandLine commandLine);
    public CommandLine deleteCommandLine(Integer idCommandLine);
    List<CommandLine> ListCommandLine();

    public CommandLine ListCommanLineById(Integer idCommandLine);


    //cart

    public Cart saveCart(Cart cart, Integer idCommandLine);



    public void assignCommandeLineToCart(Integer idCommandLine, Integer idCart);

    public Cart updateCart(Cart cart);
    public Cart deleteCart(Integer idCart);

     public List<Cart> ListCart();

    public Cart ListCartById(Integer idCart);

 //order
    public PurchaseOrder addPurchaseOrder(PurchaseOrder order);
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder order);


    List<PurchaseOrder> ListPurchaseOrder();

    public PurchaseOrder ListOrderById(Integer idOrder);


   public int TotalOrdersTVA (int idOrder);

    //delivery

    public Delivery addDelivery(Delivery delivery);
    public Delivery updateDelivery(Delivery delivery);

    public Delivery deleteDelivery(Integer idDelivery);

    List<Delivery> ListDelivery();

    public Delivery ListDeliveryById(Integer idDelivery);

    public int notstarted(int id);
    public int delivered(int id);
    public int inProgress(int id);

    String availableDelivery(int id);





    public void assignDelivererToDelivery(Integer idDelivery, Integer idDeliverer);
    public void assignDeliveryToOrder(Integer idOrder, Integer idDelivery);


    public CommandLine addProductToCommandLine(int idCommandLine, int IdProduct);



    ///////// stripe ///////

    public Payment payment(int idUser, int idOrder, Payment p) throws StripeException;
    public double createCharge(String token, int idUser, int idOrder) throws StripeException ;


}
