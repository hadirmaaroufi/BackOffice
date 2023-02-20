package tn.esprit.pidev.bns.entity.omar;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends User implements Serializable {
}
