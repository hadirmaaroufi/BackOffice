package tn.esprit.pidev.bns.service.siwarbacc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.bns.entity.siwarbacc.Comment;
import tn.esprit.pidev.bns.repository.siwarbacc.CommentRepository;
import tn.esprit.pidev.bns.serviceInterface.siwarbacc.ICommentService;

import java.util.List;

@Slf4j
@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> retrieveAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    public Comment updateComment(Comment c) {
        return commentRepository.save(c);
    }

    public Comment addComment(Comment c) {
        return commentRepository.save(c);
    }



    public Comment retrieveComment(Integer id) { return commentRepository.findById(id).orElse( null);}


    public void removeComment(Integer id) {
        Comment c=retrieveComment(id);
        commentRepository.delete(c);
    }

}
