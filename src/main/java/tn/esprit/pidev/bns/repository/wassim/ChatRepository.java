package tn.esprit.pidev.bns.repository.wassim;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.bns.entity.wassim.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
}

