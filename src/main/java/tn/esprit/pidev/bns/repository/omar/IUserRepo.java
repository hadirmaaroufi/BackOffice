package tn.esprit.pidev.bns.repository.omar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.bns.entity.omar.User;
@Repository
public interface IUserRepo  extends JpaRepository<User, Integer> {
}
