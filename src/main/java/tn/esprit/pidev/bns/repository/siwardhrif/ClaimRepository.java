package tn.esprit.pidev.bns.repository.siwardhrif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.bns.entity.omar.Client;
import tn.esprit.pidev.bns.entity.siwardhrif.Claim;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {
    List<Claim> findByTreated(boolean treated);
    List<Claim> findByCreationDateBetween(Date debut, Date fin);
    List<Claim> findByProcessingDateBetween(Date debut, Date fin);

}
