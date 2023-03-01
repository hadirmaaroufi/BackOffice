package tn.esprit.pidev.bns.serviceInterface.siwardhrif;

import tn.esprit.pidev.bns.entity.siwardhrif.Offer;

import java.util.List;

public interface IOfferService {
        public Offer createOffer(Offer offer);
        public List<Offer> getAllOffers();

        public Offer getOfferById(Integer idOffer) ;

        public void deleteOffer(Integer idOffer) ;

}
