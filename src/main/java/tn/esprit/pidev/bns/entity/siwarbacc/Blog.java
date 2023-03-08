package tn.esprit.pidev.bns.entity.siwarbacc;

import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Client;
import tn.esprit.pidev.bns.entity.omar.Supplier;

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
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBlog;
    private String title;
    private String content;
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    private boolean isValid;

    @ManyToOne
    private Supplier supplier;
}
