package tn.esprit.pidev.bns.entity.siwardhrif;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//Entity Claim
public class Claim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClaim;

    private String fullName;

    private String orderNumber;

    private String productRef;

    private Date creationDate; // date de creation de réclamation par client

    private boolean treated; //traiter ou non par l'admin

    private Date processingDate; // date de traitement de réclamation par l'admin

    @Enumerated(EnumType.STRING)
    private ClaimSubject subject;

    private String subtheme; // chaque sujet des sous themes

    @Column(columnDefinition = "TEXT")
    private String description;

    private String cfile; // importer fichier pdf ou images par le client

    @ManyToOne
    private Client client;
}
