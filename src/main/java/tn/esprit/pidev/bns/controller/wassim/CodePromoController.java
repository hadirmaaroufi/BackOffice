package tn.esprit.pidev.bns.controller.wassim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.wassim.CodePromo;
import tn.esprit.pidev.bns.serviceInterface.wassim.CodePromoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/codePromo")
public class CodePromoController {

    @Autowired
    private CodePromoService codePromoService;

    // CRUD: Create
   // @PostMapping("/create")
 //   public CodePromo createCodePromo(@RequestBody CodePromo codePromo) {
       // return codePromoService.createCodePromo(codePromo);

   // }
    @PostMapping("/create")
    public ResponseEntity<CodePromo> createCodePromo(@RequestBody CodePromo codePromo) {
        CodePromo createdCodePromo = codePromoService.createCodePromo(codePromo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCodePromo);
    }


    // CRUD: Read
    @GetMapping("/read")
    public List<CodePromo> getAllCodePromos() {
        return codePromoService.getAllCodePromos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodePromo> getCodePromoById(@PathVariable(value = "id") Integer id) {
        Optional<CodePromo> codePromo = codePromoService.getCodePromoById(id);
        if (!codePromo.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(codePromo.get());
    }

    @PutMapping("/update/{id}")
    public CodePromo updateCodePromo(@PathVariable  int id, @RequestBody CodePromo codePromoDetails) {
        return codePromoService.updateCodePromo(id,codePromoDetails);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCodePromo(@PathVariable  int id) {

        codePromoService.deleteCodePromo(id);
    }
}
