package tn.esprit.pidev.bns.controller.ibtihel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.ibtihel.PromoCodeCreateRequest;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IPromoCode;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/PromoCodeController")

public class PromoCodeController {

    @Autowired
    IPromoCode iPromoCode;


    @PostMapping("create-code")
    public ResponseEntity<?> createCode(@RequestBody PromoCodeCreateRequest promoCodeRequest) {
        iPromoCode.createPromoCode(promoCodeRequest);
        return ResponseEntity.ok("success");
    }


    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(iPromoCode.getAll());
    }


    @GetMapping("getBydId/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(iPromoCode.getById(id));
    }



    @DeleteMapping("delete-code/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
        iPromoCode.deleteById(id);
        return ResponseEntity.ok("success");
    }
}
