package tn.esprit.pidev.bns.service.ibtihel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.repository.ibtihel.CartRepo;
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
}
