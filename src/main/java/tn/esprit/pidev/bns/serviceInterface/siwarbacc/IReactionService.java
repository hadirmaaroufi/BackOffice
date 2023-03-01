package tn.esprit.pidev.bns.serviceInterface.siwarbacc;

import tn.esprit.pidev.bns.entity.siwarbacc.Reaction;

import java.util.Date;
import java.util.List;

public interface IReactionService {



 List<Reaction> retrieveAllReactions();

 Reaction retrieveReaction(Integer reactionId);

  Reaction addReaction(Reaction r);
 void removeReaction(Integer reactionId);
 Reaction updateReaction(Reaction r);
}
