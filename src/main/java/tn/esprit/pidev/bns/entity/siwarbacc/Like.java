package tn.esprit.pidev.bns.entity.siwarbacc;

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
public class Like implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLike;
    private int like;
    private int userId;
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @ManyToOne
    private Comment comment;
    @ManyToOne
    private Client client;

}
