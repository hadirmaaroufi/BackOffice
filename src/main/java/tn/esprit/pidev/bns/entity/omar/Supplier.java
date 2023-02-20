package tn.esprit.pidev.bns.entity.omar;

import lombok.*;
import tn.esprit.pidev.bns.entity.hadir.Shop;
import tn.esprit.pidev.bns.entity.siwarbacc.Blog;
import tn.esprit.pidev.bns.entity.wassim.Request;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Supplier extends User implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Shop> shops;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Blog> blogs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="supplier")
    private Set<Request> requests;
}
