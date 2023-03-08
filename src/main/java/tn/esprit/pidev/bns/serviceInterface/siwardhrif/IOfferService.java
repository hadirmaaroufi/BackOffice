package tn.esprit.pidev.bns.serviceInterface.siwardhrif;

import org.apache.commons.mail.EmailException;
import tn.esprit.pidev.bns.entity.siwardhrif.Offer;

import java.util.List;

public interface IOfferService {
        public Offer createOffer(Offer offer) throws EmailException;
        public List<Offer> getAllOffers();

        public Offer getOfferById(Integer idOffer) ;

        public void deleteOffer(Integer idOffer) ;

}
