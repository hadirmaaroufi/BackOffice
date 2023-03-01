package tn.esprit.pidev.bns.entity.hadir;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Supplier;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

    @JsonIgnore
    @ManyToOne
    private Supplier supplier;
    //@JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*@JoinTable(name = "shop_product",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))*/
    private List<Product> products = new ArrayList<>();
}
