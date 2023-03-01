package tn.esprit.pidev.bns.controller.siwarbacc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwarbacc.Reaction;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.IReactionService;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/reaction")
@Tag(name = "Reaction Docs")
public class ReactionRestController  {
   @Autowired
    IReactionService reactionService;
    @Operation(description = "Get All Reactions")
    @GetMapping("/retrieve-All-Reactions")
    public List<Reaction> getReactions() {
        List<Reaction> listReactions = reactionService.retrieveAllReactions();
        return listReactions;
    }

    @Operation(description = "Retrieve Reaction")
    @GetMapping("/retrieve-reaction/{reaction-id}")
    public Reaction retrieveReaction(@PathVariable("reaction-id") Integer reactionId) {
        return reactionService.retrieveReaction(reactionId);
    }
    @Operation(description = "Add Reaction")
    @PostMapping("/add-Reaction")
    public Reaction addReaction(@RequestBody Reaction r) {
        Reaction reaction = reactionService.addReaction(r);
        return reaction;
    }

    @Operation(description = "Delete Reactions")
    @DeleteMapping("/remove-Reaction/{Reaction-id}")
  public void removeReaction(@PathVariable("Reaction-id") Integer reactionId) {
        reactionService.removeReaction(reactionId);
    }
    @Operation(description = "Update Reactions")
    @PutMapping("/update-Reaction")
    public Reaction updateReaction(@RequestBody Reaction r) {
        Reaction reaction= reactionService.updateReaction(r);
        return reaction;
    }

}

