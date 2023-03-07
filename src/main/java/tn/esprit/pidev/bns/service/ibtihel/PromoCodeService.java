package tn.esprit.pidev.bns.service.ibtihel;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.pidev.bns.entity.ibtihel.Delivery;
import tn.esprit.pidev.bns.entity.ibtihel.PromoCode;
import tn.esprit.pidev.bns.entity.ibtihel.PromoCodeCreateRequest;
import tn.esprit.pidev.bns.entity.ibtihel.PurchaseOrder;
import tn.esprit.pidev.bns.entity.omar.User;
import tn.esprit.pidev.bns.repository.ibtihel.PromoCodeRepo;
import tn.esprit.pidev.bns.service.omar.UserService;
import tn.esprit.pidev.bns.serviceInterface.ibtihel.IPromoCode;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoCodeService implements IPromoCode {
    @Autowired
    PromoCodeRepo promoCodeRepo;

    @Autowired
    UserService userService;

    private final CreateCodeService createCodeService;

    @Override
    public String createPromoCode(PromoCodeCreateRequest promoCodeRequest) {
        Optional<User> user = Optional.ofNullable(userService.getById(promoCodeRequest.getUserId()));

        if (user.isPresent()) {
            PromoCode promoCode = new PromoCode();
            promoCode.setCode(createCodeService.createCode() + promoCodeRequest.getAmount());
            promoCode.setCreateDate(new Date());
            promoCode.setAmount(promoCodeRequest.getAmount());
            promoCode.setExpirationDate(new Date(promoCodeRequest.getYear(), promoCodeRequest.getMonth(), promoCodeRequest.getDate()));
            promoCode.setUser(user.get());

            promoCodeRepo.save(promoCode);
            userService.addUser(user.get());

            return promoCode.getCode();
        }

        return "failed";
    }

    @Override
    public List<PromoCode> getAll() {
        return promoCodeRepo.findAll();
    }

    @Override
    public PromoCode getById(int id) {
         return promoCodeRepo.findById(id).orElseThrow(() ->
                new NotFoundException("promo code couldn't be found by following id: " + id));
    }

    @Override
    public void deleteById(int id) {
         promoCodeRepo.deleteById(id);
    }


}


