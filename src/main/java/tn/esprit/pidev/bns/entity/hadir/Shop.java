package tn.esprit.pidev.bns.entity.hadir;

import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Supplier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShop;
    private String name;
    private String photo;
    private String address;

    @ManyToOne
    private Supplier supplier;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products;
}
