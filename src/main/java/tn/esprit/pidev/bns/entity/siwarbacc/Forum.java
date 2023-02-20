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
public class Forum implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idForum;
    private String title;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    private boolean isValid;

    @ManyToOne
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="forum")
    private Set<Comment> comments;
}
