package tn.esprit.pidev.bns.entity.siwardhrif;

import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Client;

import javax.persistence.*;
import java.io.Serializable;

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
    private BusinessType businessType;
    private int businessPhoneNumber;
    private String businessEmail;
    private String description;

    @OneToOne(mappedBy="offer")
    private Client client;
}
