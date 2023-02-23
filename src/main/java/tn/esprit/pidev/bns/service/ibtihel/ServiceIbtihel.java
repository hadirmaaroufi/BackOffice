package tn.esprit.pidev.bns.service.ibtihel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.CommandLine;
import tn.esprit.pidev.bns.entity.ibtihel.Delivery;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;
import tn.esprit.pidev.bns.repository.ibtihel.CartRepo;
import tn.esprit.pidev.bns.repository.ibtihel.CommandLineRepo;
import tn.esprit.pidev.bns.repository.ibtihel.DeliveryRepo;
import tn.esprit.pidev.bns.repository.ibtihel.PurchaseOrderRepo;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IServiceIbtihel;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceIbtihel implements IServiceIbtihel {

    PurchaseOrderRepo purchaseOrderRepo;
    CartRepo cartRepo;
    DeliveryRepo deliveryRepo;

    CommandLineRepo commandLineRepo;


    @Override
    public CommandLine addCommandLine(CommandLine commandLine) {
        return commandLineRepo.save(commandLine);
    }

    @Override
    public CommandLine updateCommandLine(CommandLine commandLine) {
        return commandLineRepo.save(commandLine);
    }

    @Override
    public CommandLine deleteCommandLine(Integer idCommandLine) {
        commandLineRepo.deleteById(idCommandLine);
        return null;
    }

    @Override
    public List<CommandLine> ListCommandLine() {
        return  (List<CommandLine>) commandLineRepo.findAll();
    }

    @Override
    public CommandLine ListCommanLineById(Integer idCommandLine) {
        return commandLineRepo.findById(idCommandLine).get();
    }

    @Override
    public Cart addCart(Cart cart){

        return cartRepo.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public Cart deleteCart(Integer idCart) {
        cartRepo.deleteById(idCart);
        return null;
    }

    @Override
    public List<Cart> ListCart() {
        return  (List<Cart>) cartRepo.findAll();
    }

    @Override
    public Cart ListCartById(Integer idCart) {
        return cartRepo.findById(idCart).get();
    }

    @Override
    public PurchaseOrder addPurchaseOrder(PurchaseOrder order) {
        return purchaseOrderRepo.save(order);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder order) {
        return purchaseOrderRepo.save(order);
    }

    @Override
    public List<PurchaseOrder> ListPurchaseOrder() {
        return  (List<PurchaseOrder>) purchaseOrderRepo.findAll();
    }

    @Override
    public PurchaseOrder ListOrderById(Integer idOrder) {
        return purchaseOrderRepo.findById(idOrder).get();
    }

    @Override
    public Delivery addDelivery(Delivery delivery) {
        return  deliveryRepo.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    @Override
    public Delivery deleteDelivery(Integer idDelivery) {
        deliveryRepo.deleteById(idDelivery);
        return null;
    }

    @Override
    public List<Delivery> ListDelivery() {
        return (List<Delivery>) deliveryRepo.findAll();
    }

    @Override
    public Delivery ListDeliveryById(Integer idDelivery) {
        return deliveryRepo.findById(idDelivery).get();
    }


}
