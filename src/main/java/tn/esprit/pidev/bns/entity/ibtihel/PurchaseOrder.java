package tn.esprit.pidev.bns.entity.ibtihel;

import lombok.*;

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
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    private String reference;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private int orderPrice;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String discountCode;
    private String address;
    private int phoneNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus ;

    @OneToOne
    private Cart cart;
    @ManyToOne
    private Delivery delivery;
}
