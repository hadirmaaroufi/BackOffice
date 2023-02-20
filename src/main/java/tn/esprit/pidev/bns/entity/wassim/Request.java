package tn.esprit.pidev.bns.entity.wassim;

import lombok.*;
import tn.esprit.pidev.bns.entity.omar.Client;
import tn.esprit.pidev.bns.entity.omar.Supplier;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRequest;
    private String title;
    private String content;
    private String evidence;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Supplier supplier;
}
