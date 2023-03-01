package tn.esprit.pidev.bns.controller.siwardhrif;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwardhrif.Claim;
import tn.esprit.pidev.bns.serviceInterface.siwardhrif.IClaimService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/claim")
public class ClaimRestController {
    @Autowired
    IClaimService claimService;

    //http://localhost:9000/bns/claim/add-claim
    @PostMapping("/addclaim")
    public Claim createClaim(@RequestBody Claim c) {

        Claim claim = claimService.createClaim(c);
        return claim;
    }


    //http://localhost:9000/bns/claim/retrieve-all-claims
    @GetMapping("/retrieve-all-claims")
    public List<Claim> getAllClaims() {
        List<Claim> listClaims = claimService.getAllClaims();
        return listClaims;
    }

    //http://localhost:9000/bns/claim/retrieve-claim/id
    @GetMapping("/retrieve-claim/{idClaim}")
    public Claim retrieveClaim(@PathVariable("idClaim") Integer idClaim) {
        return claimService.retrieveClaim(idClaim);
    }

    //http://localhost:9000/bns/claim/traiterClaim/id
    @GetMapping("/traiterClaim/{idClaim}")
    public Claim traiterClaim(@PathVariable("idClaim") Integer idClaim) {
        return claimService.traiterClaim(idClaim);
    }

    //http://localhost:9000/bns/claim/getClaimsByEtat/1 or 0
    @GetMapping("/getClaimsByEtat/{treated}")
    public List<Claim> getClaimsByEtat(@PathVariable("treated") boolean treated) {
        return claimService.getClaimsByEtat(treated);
    }

    //http://localhost:9000/bns/claim/ByCreationDate/
    @GetMapping("/ByCreationDate/{debut}/{fin}")
    public String getClaimsByCreationDate(@PathVariable ("debut") Date debut,
                                          @PathVariable ("fin") Date fin) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Claim> claims = claimService.getClaimsByCreationDate(debut, fin);
        return "claimsByCreationDate";
    }

    //http://localhost:9000/bns/claim/ByProcessingDate/
    @GetMapping("/ByProcessingDate/{debut}/{fin}")
    public String getClaimsByProcessingDate(@PathVariable ("debut") Date debut,
                                          @PathVariable ("fin") Date fin) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Claim> claims = claimService.getClaimsByProcessingDate(debut, fin);
        return "claimsProcessingDate";
    }


    //http://localhost:9000/bns/claim/remove-claim/1
    @DeleteMapping("/remove-claim/{idClaim}")
    public void deleteClaim (@PathVariable("idClaim") Integer idClaim) {
        claimService.deleteClaim(idClaim);
    }


}
