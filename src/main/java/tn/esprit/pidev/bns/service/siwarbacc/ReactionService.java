package tn.esprit.pidev.bns.service.siwarbacc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.siwarbacc.Reaction;
import tn.esprit.pidev.bns.repository.siwarbacc.ReactionRepository;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.IReactionService;

import java.util.List;

@Service
@Slf4j
public class ReactionService implements IReactionService {
    @Autowired
    ReactionRepository reactionRepository;

    public List<Reaction> retrieveAllReactions(){
        return (List<Reaction>) reactionRepository.findAll();
    }
    public Reaction updateReaction (Reaction r){
        return reactionRepository.save(r);
    }

    public  Reaction addReaction (Reaction r){
        return reactionRepository.save(r);
    }
    public Reaction retrieveReaction(Integer  idReaction){
        return reactionRepository.findById(idReaction).orElse(null);
    }

    public void removeReaction(Integer idReaction) {
        Reaction r=retrieveReaction(idReaction);
        reactionRepository.delete(r);
    }

}




