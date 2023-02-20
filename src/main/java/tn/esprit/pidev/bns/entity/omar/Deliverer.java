package tn.esprit.pidev.bns.entity.omar;

import lombok.*;
import tn.esprit.pidev.bns.entity.ibtihel.Delivery;

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
public class Deliverer extends User implements Serializable {
    private String address;
    private boolean isAvailable;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="deliverer")
    private Set<Delivery> deliveries;
}
