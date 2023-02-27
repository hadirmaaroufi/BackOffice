package tn.esprit.pidev.bns.controller.siwarbacc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwarbacc.Forum;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.IForumService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/forum")
@Tag(name = "Forum Docs")
public class ForumRestController {
    @Autowired
    IForumService forumService;
    @Operation(description = "Get All Forums")
    @GetMapping("/retrieve-all-forums")
    public List<Forum> getForums() {
        List<Forum> listForums = forumService.retrieveAllForums();
        return listForums;
    }
    @Operation(description = "Retrieve Forums")
    @GetMapping("/retrieve-forum/{forum-id}")
    public Forum retrieveForum(@PathVariable("forum-id") Integer forumId) {
        return forumService.retrieveForum(forumId);
    }
    @Operation(description = "Add Forums")
    @PostMapping("/add-forum")
    public Forum addForum(@RequestBody Forum f) {
        Forum forum = forumService.addForum(f);
        return forum;
    }
    @Operation(description = "Delete Forums")
    @DeleteMapping("/remove-forum/{forum-id}")
    public void removeForum(@PathVariable("forum-id") Integer forumId) {
        forumService.removeForum(forumId);
    }
    @Operation(description = "Update Forums")
    @PutMapping("/update-forum")
    public Forum updateForum(@RequestBody Forum f) {
        Forum forum= forumService.updateForum(f);
        return forum;
    }

}
