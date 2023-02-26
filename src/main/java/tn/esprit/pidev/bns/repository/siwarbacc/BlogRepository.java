package tn.esprit.pidev.bns.repository.siwarbacc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.bns.entity.siwarbacc.Blog;

import java.util.List;
@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
   
}
