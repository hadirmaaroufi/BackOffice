package tn.esprit.pidev.bns.entity.ibtihel;

import lombok.*;
import tn.esprit.pidev.bns.entity.hadir.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommandLine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCommandeLine;
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Product> products;

    @ManyToOne (cascade = CascadeType.ALL)
   private Cart cart;
}
