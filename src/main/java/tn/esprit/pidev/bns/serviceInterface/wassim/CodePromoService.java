package tn.esprit.pidev.bns.serviceInterface.wassim;

import tn.esprit.pidev.bns.entity.wassim.CodePromo;

import java.util.List;
import java.util.Optional;

public interface CodePromoService {
    List<CodePromo> getAllCodePromos();
    Optional<CodePromo> getCodePromoById(Integer id);
    CodePromo createCodePromo(CodePromo codePromo);
    CodePromo updateCodePromo(Integer id, CodePromo codePromoDetails);
    String deleteCodePromo(int id);
}
