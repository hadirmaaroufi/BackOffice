package tn.esprit.pidev.bns.entity.siwardhrif;

import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOffer;

    private String shopName;

    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    private int businessPhoneNumber;

    private String businessEmail;

    private String description;

    private Date startDate;

    private Date endDate;


    @OneToOne(mappedBy="offer")
    private Client client;
}

