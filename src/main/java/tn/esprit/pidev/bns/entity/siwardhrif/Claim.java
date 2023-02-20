package tn.esprit.pidev.bns.entity.siwardhrif;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Claim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;
    private String firstName;
    private String lastName;
    private String productRef;
    private String subject;
    private String description;
    private String file;
    private int phoneNumber;
    private String email;

    @ManyToOne
    private Client client;
}
