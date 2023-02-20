package tn.esprit.pidev.bns.repository.omar;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.bns.entity.omar.User;

public interface IUserRepo  extends JpaRepository<User, Integer> {
}
