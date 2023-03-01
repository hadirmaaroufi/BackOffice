package tn.esprit.pidev.bns.controller.siwardhrif;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwardhrif.Offer;
import tn.esprit.pidev.bns.service.siwardhrif.OfferServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/offer")
public class OfferRestController {
        @Autowired
        OfferServiceImpl OfferService;

        //http://localhost:9000/bns/offer/add-offer
        @PostMapping("/add-offer")
        public Offer createOffer(@RequestBody Offer o) {
            Offer offer = OfferService.createOffer(o);
            return offer;
        }

    //http://localhost:9000/bns/offer/retrieve-all-offers
    @GetMapping("/retrieve-all-offers")
    public List<Offer> getAllOffers() {
        List<Offer> listOffers = OfferService.getAllOffers();
        return listOffers;
    }

    //http://localhost:9000/bns/offer/retrieve-offer
    @GetMapping("/retrieve-offer/{idOffer}")
    public Offer getOfferById(@PathVariable("idOffer") Integer idOffer) {
        return OfferService.getOfferById(idOffer);
    }


    //http://localhost:9000/bns/offer/remove-offer
    @DeleteMapping("/remove-offer/{idOffer}")
    public void deleteOffer (@PathVariable("idOffer") Integer idOffer) {
        OfferService.deleteOffer(idOffer);
    }

        // autres méthodes REST pour la gestion des appels d'offre
    }
