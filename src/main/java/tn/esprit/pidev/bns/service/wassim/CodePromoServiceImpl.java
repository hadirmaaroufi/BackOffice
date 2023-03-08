package tn.esprit.pidev.bns.service.wassim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.wassim.CodePromo;
import tn.esprit.pidev.bns.repository.wassim.CodePromoRepository;
import tn.esprit.pidev.bns.serviceInterface.wassim.CodePromoService;

import java.util.List;
import java.util.Optional;

@Service
public class CodePromoServiceImpl implements CodePromoService {

    @Autowired
    private CodePromoRepository codePromoRepository;

    @Override
    public List<CodePromo> getAllCodePromos() {
        return codePromoRepository.findAll();
    }

    @Override
    public Optional<CodePromo> getCodePromoById(Integer id) {
        return codePromoRepository.findById(id);
    }

    @Override
    public CodePromo createCodePromo(CodePromo codePromo) {
        return codePromoRepository.save(codePromo);
    }


    @Override
    public CodePromo updateCodePromo(Integer id, CodePromo codePromoDetails) {
        Optional<CodePromo> optionalCodePromo = codePromoRepository.findById(id);
        if (optionalCodePromo.isPresent()) {
            CodePromo codePromo = optionalCodePromo.get();
            codePromo.setCode(codePromoDetails.getCode());
            codePromo.setReduction(codePromoDetails.getReduction());
            codePromo.setDateFin(codePromoDetails.getDateFin());
            return codePromoRepository.save(codePromo);
        }
        return null;
    }


    @Override
    public String deleteCodePromo(int id) {

        codePromoRepository.deleteById(id);
        return "Request supprimer";
    }
}

