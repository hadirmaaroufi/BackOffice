package tn.esprit.pidev.bns.repository.siwarbacc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.bns.entity.siwarbacc.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
