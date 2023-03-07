package tn.esprit.pidev.bns.entity.omar;

import lombok.*;
import tn.esprit.pidev.bns.entity.hadir.Favorite;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;
import tn.esprit.pidev.bns.entity.ibtihel.PromoCode;
import tn.esprit.pidev.bns.entity.siwarbacc.Forum;
import tn.esprit.pidev.bns.entity.siwardhrif.Claim;
import tn.esprit.pidev.bns.entity.siwardhrif.Offer;
import tn.esprit.pidev.bns.entity.wassim.Request;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client extends User implements Serializable {
    @OneToOne
    private Favorite favorite;
    @OneToOne
    private Cart cart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Forum> forums;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Claim> claims;
    @OneToOne
    private Offer offer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private Set<Request> requests;


}
