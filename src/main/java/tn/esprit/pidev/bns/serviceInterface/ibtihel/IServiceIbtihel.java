package tn.esprit.pidev.bns.serviceInterface.ibtihel;

import tn.esprit.pidev.bns.entity.ibtihel.Cart;

import java.util.List;

public interface IServiceIbtihel {


    public Cart addCart(Cart cart);
    public Cart updateCart(Cart cart);
    public Cart deleteCart(Integer idCart);

    List<Cart> ListCart();

    public Cart ListCartById(Integer idCart);

}
