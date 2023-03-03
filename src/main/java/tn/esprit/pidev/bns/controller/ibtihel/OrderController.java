package tn.esprit.pidev.bns.controller.ibtihel;

import com.stripe.exception.StripeException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.ICart;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IOrder;

import java.util.List;

@RestController

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/OrderController")
public class OrderController {

    IOrder iOrder;

    ICart iCart;



    //////////order


    @PostMapping("/addOrder/{idCart}")
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder order,
                                          @PathVariable("idCart") int idCart )
    {
        order.setCart(iCart.ListCartById(idCart));
        return  iOrder.addPurchaseOrder(order);
    }


    @PutMapping("/updateOrder")
    public PurchaseOrder updatePurchaseOrder( @RequestBody PurchaseOrder order) {
        return  iOrder.updatePurchaseOrder(order);
    }

    @GetMapping("/GetListOrders")
    public List<PurchaseOrder> ListPurchaseOrder() {
        return iOrder.ListPurchaseOrder();
    }

    @GetMapping("/GetListOrderById/{id}")
    public PurchaseOrder ListOrderById( @PathVariable ("id") Integer idOrder) {
        return iOrder.ListOrderById(idOrder);
    }

    @PutMapping("/TotalOrdersTVA/{idOrder}")
    public int TotalOrdersTVA(@PathVariable("idOrder") int idOrder) {
        return iOrder.TotalOrdersTVA(idOrder);
    }



    ///////// stripe payment

    @PostMapping("/stripePayment/{token}/{idUser}/{idOrder}")
    @ResponseBody
    public double createCharge(@PathVariable ("token") String token, @PathVariable("idUser") int idUser, @PathVariable ("idOrder") int idOrder) throws StripeException
    {
        return iOrder.createCharge(token,idUser,idOrder);
    }
}
