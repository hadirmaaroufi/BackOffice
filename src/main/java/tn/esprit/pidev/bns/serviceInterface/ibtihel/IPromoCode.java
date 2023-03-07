package tn.esprit.pidev.bns.serviceInterface.ibtihel;

import tn.esprit.pidev.bns.entity.ibtihel.PromoCode;
import tn.esprit.pidev.bns.entity.ibtihel.PromoCodeCreateRequest;

import java.util.List;

public interface IPromoCode {

    String createPromoCode(PromoCodeCreateRequest promoCodeRequest);
    List<PromoCode> getAll();
    PromoCode getById(int id);
    void deleteById(int id);
}
