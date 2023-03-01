package tn.esprit.pidev.bns.entity.hadir;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import tn.esprit.pidev.bns.entity.ibtihel.Cart;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String reference;
    private String name;
    @Lob
    private byte[] image;
    private String description;
    private int price;
    private int stock;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="products")
    private List<Shop> shops;
    @JsonIgnore
    @ManyToOne
    private Category category;
    /*@ManyToMany(cascade = CascadeType.ALL, mappedBy="products")
    private Set<Favorite> favorites;*/
    /*@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="products")
    private Set<Cart> carts;*/
}
