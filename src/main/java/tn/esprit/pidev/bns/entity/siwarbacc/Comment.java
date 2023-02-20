package tn.esprit.pidev.bns.entity.siwarbacc;

import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;
    private String commentary;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Forum forum;
    @ManyToOne
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="comment")
    private Set<Reaction> reactions;
}
