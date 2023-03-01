package tn.esprit.pidev.bns.controller.siwardhrif;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.pidev.bns.entity.siwardhrif.Claim;
import tn.esprit.pidev.bns.repository.siwardhrif.ClaimRepository;
import tn.esprit.pidev.bns.serviceInterface.siwardhrif.IClaimService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/imagedata";

    @Autowired
    private ClaimRepository claimRepository;

    //http://localhost:9000/bns/claim/add-claim
    @PostMapping("/addclaim")
    @ResponseBody
    public Claim createClaim(Claim c , @RequestParam("img")MultipartFile file) {
        StringBuilder fileNames =new StringBuilder();
        String filename=c.getIdClaim() + file.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory,filename);

        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        c.setCfile(filename);
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
