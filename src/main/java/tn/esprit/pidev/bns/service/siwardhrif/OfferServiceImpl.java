package tn.esprit.pidev.bns.service.siwardhrif;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.siwardhrif.Offer;
import tn.esprit.pidev.bns.repository.siwardhrif.ClaimRepository;
import tn.esprit.pidev.bns.repository.siwardhrif.OfferRepository;
import tn.esprit.pidev.bns.serviceInterface.siwardhrif.IClaimService;
import tn.esprit.pidev.bns.serviceInterface.siwardhrif.IOfferService;

import java.util.List;

@Slf4j
@Service
public class OfferServiceImpl implements IOfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer getOfferById(Integer idOffer) {
        return offerRepository.findById(idOffer).orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    @Override
    public void deleteOffer(Integer idOffer) {
        offerRepository.deleteById(idOffer);
    }


    // autres méthodes de gestion des appels d'offre
    }
