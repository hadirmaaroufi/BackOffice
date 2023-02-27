package tn.esprit.pidev.bns.controller.siwarbacc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwarbacc.Comment;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.ICommentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Comment")
@Tag(name = "CommentDocs")
public class CommentRestController {
    @Autowired
    ICommentService commentService;

    @Operation(description = "Get All Comments")

    @GetMapping("/retrieve-all-Comments")
    public List<Comment> getComments() {
        List<Comment> listComments = commentService.retrieveAllComments();
        return listComments;
    }
         @Operation(description = "Retrieve Comments")
         @GetMapping("/retrieve-comment/{idComment}")
         public Comment retrieveComment(@PathVariable("idComment") Integer idComment) {
        return commentService.retrieveComment(idComment);
        }
        @Operation(description = "Add Comments")
        @PostMapping("/add-comment")
        public Comment addComment (@RequestBody Comment c ){
            Comment comment = commentService.addComment(c);
            return comment;
        }
        @Operation(description = "Remove Comments")
        @DeleteMapping("/remove-comment/{idComment}")
        public void removeComment (@PathVariable("idComment") Integer idComment)
        {
            commentService.removeComment(idComment);
        }
    @Operation(description = "Update comments")
        @PutMapping("/update-comment")
        public Comment updateComment (@RequestBody Comment c){
            Comment comment = commentService.updateComment(c);
            return comment;
        }

    }
