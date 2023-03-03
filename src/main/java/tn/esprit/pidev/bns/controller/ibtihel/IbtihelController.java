package tn.esprit.pidev.bns.controller.ibtihel;


import com.stripe.exception.StripeException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.CommandLine;
import tn.esprit.pidev.bns.entity.ibtihel.Delivery;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IServiceIbtihel;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/ControllerIbtihel")
public class IbtihelController {

    IServiceIbtihel serviceIbtihel;



    ////////commandline

    @PostMapping("/addCommandLine")
    public CommandLine addCommandLine(CommandLine commandLine) {
        System.out.println(commandLine.getQuantity());
        return serviceIbtihel.addCommandLine(commandLine);
    }

    @PutMapping("/updateCommandLine")
    public CommandLine updateCommandLine(CommandLine commandLine) {
       return serviceIbtihel.updateCommandLine(commandLine);
    }

    @PutMapping("/deleteCommandLine/{id}")
    public CommandLine deleteCommandLine(@PathVariable("id") Integer idCommandLine) {
    return serviceIbtihel.deleteCommandLine(idCommandLine);
    }


    @GetMapping("/GetListCommandLine")
    public List<CommandLine> ListCommandLine() {
      return  serviceIbtihel.ListCommandLine();
    }
    @GetMapping("/GetListCommandLineById/{id}")
    public CommandLine ListCommanLineById(@PathVariable("id") Integer idCommandLine) {
        return serviceIbtihel.ListCommanLineById(idCommandLine);
    }





////// add product to commandLine
    @PostMapping("/products/{idCommandeLine}/{idProduct}")
    public CommandLine addToCommandLine(@PathVariable ("idCommandeLine")int idCommandeLine,
                                        @PathVariable ("idProduct")int idProduct) {
        return serviceIbtihel.addProductToCommandLine(idCommandeLine, idProduct);
    }






    ////////cart

    @PostMapping("/saveCart/ {idCommandLine}")
    public Cart saveCart(@RequestBody Cart cart, @PathVariable("idCommandLine") Integer idCommandLine) {
         Cart cart1=serviceIbtihel.saveCart(cart,idCommandLine);
          return cart1;

    }

    @PutMapping("/assignCommandeLineToCart")
    public void assignCommandeLineToCart(@RequestParam("idCommandLine") Integer idCommandLine,
                                         @RequestParam("idCart") Integer idCart) {
        System.err.println(idCommandLine);
        System.err.println(idCart);
        serviceIbtihel.assignCommandeLineToCart(idCommandLine,idCart);
    }


    @PutMapping("/updateCart")
    public Cart updateCart( @RequestBody Cart cart) {
   return  serviceIbtihel.updateCart(cart);
    }

    @PutMapping("/deleteCart/{id}")
    public Cart deleteCart( @PathVariable("id") Integer idCart) {
   return serviceIbtihel.deleteCart(idCart);
    }



    @GetMapping("/GetListCart")
    public List<Cart> getListCart() {
        List <Cart> cartList = serviceIbtihel.ListCart();
      return cartList;
    }

    @GetMapping("/GetListCartById/{id}")
    public Cart ListCartById(@PathVariable("id") Integer idCart) {

        return serviceIbtihel.ListCartById(idCart);
    }









    //////////order


    @PostMapping("/addOrder/{idCart}")
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder order,
                                          @PathVariable ("idCart") int idCart )
    {
        order.setCart(serviceIbtihel.ListCartById(idCart));
       return  serviceIbtihel.addPurchaseOrder(order);
    }


    @PutMapping("/updateOrder")
    public PurchaseOrder updatePurchaseOrder( @RequestBody PurchaseOrder order) {
     return  serviceIbtihel.updatePurchaseOrder(order);
    }

    @GetMapping("/GetListOrders")
    public List<PurchaseOrder> ListPurchaseOrder() {
        return serviceIbtihel.ListPurchaseOrder();
    }

    @GetMapping("/GetListOrderById/{id}")
    public PurchaseOrder ListOrderById( @PathVariable ("id") Integer idOrder) {
      return serviceIbtihel.ListOrderById(idOrder);
    }

    @PutMapping("/TotalOrdersTVA/{idOrder}")
    public int TotalOrdersTVA(@PathVariable("idOrder") int idOrder) {
        return serviceIbtihel.TotalOrdersTVA(idOrder);
    }



   ////////delivery
 //hethi bech nbadalha ba3d kima mta l order
    @PostMapping("/addDelivery")
    public Delivery addDelivery( @RequestBody Delivery delivery)
                                {

        return serviceIbtihel.addDelivery(delivery);
    }


    @PutMapping("/updateDelivery")
    public Delivery updateDelivery(@RequestBody Delivery delivery) {
        return serviceIbtihel.updateDelivery(delivery);
    }



    @PutMapping("/deleteDelivery/{id}")
    public Delivery deleteDelivery(@PathVariable("id") Integer idDelivery) {
         return serviceIbtihel.deleteDelivery(idDelivery);
    }


    @GetMapping("/GetListDelivery")
    public List<Delivery> ListDelivery() {
       return serviceIbtihel.ListDelivery();
    }

    @GetMapping("/GetListDeliveryById/{id}")
    public Delivery ListDeliveryById( @PathVariable("id") Integer idDelivery) {
        return serviceIbtihel.ListDeliveryById(idDelivery);
    }



    @PutMapping("/assignDelivererToDelivery")
    public void assignDelivererToDelivery(@RequestParam("idDelivery") Integer idDelivery,
                                          @RequestParam("idDeliverer") Integer idDeliverer) {
        System.err.println(idDelivery);
        System.err.println(idDeliverer);
        serviceIbtihel.assignDelivererToDelivery(idDelivery,idDeliverer);
    }


    @PutMapping("/assignDeliveryToOrder")
    public void assignDeliveryToOrder(@RequestParam ("idOrder") Integer idOrder,
                                      @RequestParam("idDelivery") Integer idDelivery) {

        System.err.println(idOrder);
        System.err.println(idDelivery);
        serviceIbtihel.assignDeliveryToOrder(idOrder,idDelivery);

    }

    @GetMapping("/availableDelivery/{id}")
    public String availableDelivery(@PathVariable("id") int id) {
        return serviceIbtihel.availableDelivery(id);
    }


    ///////// stripe payment

    @PostMapping("/stripePayment/{token}/{idUser}/{idOrder}")
    @ResponseBody
    public double createCharge(@PathVariable ("token") String token, @PathVariable("idUser") int idUser, @PathVariable ("idOrder") int idOrder) throws StripeException
    {
        return serviceIbtihel.createCharge(token,idUser,idOrder);
    }
}
