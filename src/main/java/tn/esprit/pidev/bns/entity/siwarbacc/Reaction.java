package tn.esprit.pidev.bns.entity.siwarbacc;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForum;
    private String title;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @ManyToOne
    private Comment comment;
    @ManyToOne
    private Client client;
}
