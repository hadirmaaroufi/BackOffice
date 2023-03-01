package tn.esprit.pidev.bns.service.siwardhrif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pidev.bns.entity.siwardhrif.Claim;
import tn.esprit.pidev.bns.repository.siwardhrif.ClaimRepository;
import tn.esprit.pidev.bns.serviceInterface.siwardhrif.IClaimService;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClaimServiceImpl implements IClaimService {
        @Autowired
        private ClaimRepository claimRepository;


        public Claim createClaim(Claim c) {
            c.setCreationDate(new Date());
            c.setTreated(false);
            return claimRepository.save(c);
        }

    public List<Claim> getAllClaims() {
        return (List<Claim>) claimRepository.findAll();
    }

    @Override
    public Claim updateClaim(Integer idClaim, Claim claim) {
        Claim existingClaim = retrieveClaim(idClaim);
        existingClaim.setSubject(claim.getSubject());
        existingClaim.setDescription(claim.getDescription());
        return claimRepository.save(existingClaim);
    }
    public Claim retrieveClaim (Integer  idClaim){
        return claimRepository.findById(idClaim).orElseThrow(() -> new RuntimeException("Claim not found"));
    }
    @Override
    public void deleteClaim(Integer idClaim) {
        Claim c=retrieveClaim(idClaim);
        claimRepository.delete(c);
    }

    @Override
    public List<Claim> getClaimsByEtat(boolean treated) {
        return claimRepository.findByTreated(treated);
    }

    @Override
    public List<Claim> getClaimsByCreationDate(Date debut, Date fin) {
        return claimRepository.findByCreationDateBetween(debut, fin);
    }

    @Override
    public List<Claim> getClaimsByProcessingDate(Date debut, Date fin) {
        return claimRepository.findByProcessingDateBetween(debut, fin);
    }

    @Override
    public Claim traiterClaim(Integer idClaim) {
        Claim claim = retrieveClaim(idClaim);
        claim.setTreated(true);
        claim.setProcessingDate(new Date());
        return claimRepository.save(claim);
    }


}
