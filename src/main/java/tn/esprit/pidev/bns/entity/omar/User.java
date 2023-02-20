package tn.esprit.pidev.bns.entity.omar;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String lastName;
    private String photo;
    private int phoneNumber;
    private String email;
    private String username;
    private String password;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
}
