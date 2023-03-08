package tn.esprit.pidev.bns.controller.siwarbacc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.bns.entity.siwarbacc.Comment;
import tn.esprit.pidev.bns.exception.siwarbacc.BadWordException;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.ICommentService;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Comment")
@Tag(name = "CommentDocs")
public class CommentRestController {
    @Autowired
    ICommentService commentService;

    private static final List<String> BAD_WORDS = Arrays.asList("Conasse", "hell", "blame");

    @Operation(description = "Get All Comments")

    @GetMapping("/retrieve-all-Comments")
    public ResponseEntity<List<Comment>> retrieveAllComments() {
        List<Comment> comments = commentService.retrieveAllComments();
        return ResponseEntity.ok(comments);
    }
    @Operation(description = "Retrieve Comments")

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Integer id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }
    @Operation(description = "Add Comments")
    @PostMapping("/add-comment")
    public ResponseEntity<String> addComment(@RequestBody  Comment comment) {
        try {
            Comment savedComment = commentService.addComment(comment);
            return ResponseEntity.ok("Comment added successfully");
        } catch (BadWordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The comment contains inappropriate language.");
        }
    }

    @ExceptionHandler(BadWordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadWordException() {
    }



    @Operation(description = "Remove Comments")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeComment(@PathVariable Integer id) {
        try {
            commentService.removeComment(id);
            return ResponseEntity.ok("Comment with ID " + id + " has been deleted.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }




    @Operation(description = "Update comments")
    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody Comment updcomment) {
        try {
            Comment updatedComment = commentService.updateComment(id, updcomment);
            return ResponseEntity.ok(updatedComment);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (BadWordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    private boolean checkText(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (BAD_WORDS.contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    }








