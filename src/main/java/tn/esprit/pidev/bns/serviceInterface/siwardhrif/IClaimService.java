package tn.esprit.pidev.bns.serviceInterface.siwardhrif;

import tn.esprit.pidev.bns.entity.siwardhrif.Claim;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
public interface IClaimService {

    public Claim createClaim(Claim claim);

    public List<Claim> getAllClaims();

    public Claim updateClaim(Integer idClaim, Claim claim);

    public void deleteClaim(Integer idClaim);

    public List<Claim> getClaimsByEtat(boolean treated);

    public List<Claim> getClaimsByCreationDate(Date debut, Date fin);

    public List<Claim> getClaimsByProcessingDate(Date debut, Date fin);

    public Claim traiterClaim(Integer idClaim);


    Claim retrieveClaim(Integer idClaim);
}
