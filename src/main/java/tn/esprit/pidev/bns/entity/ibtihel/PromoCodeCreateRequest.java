package tn.esprit.pidev.bns.entity.ibtihel;

import lombok.Data;

@Data
public class PromoCodeCreateRequest {

    private int userId;

    private int amount;

    private int year;

    private int month;

    private int date;

}
