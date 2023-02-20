package tn.esprit.pidev.bns.entity.ibtihel;

import lombok.*;
import tn.esprit.pidev.bns.entity.hadir.Product;

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
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCart;
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products;
}
