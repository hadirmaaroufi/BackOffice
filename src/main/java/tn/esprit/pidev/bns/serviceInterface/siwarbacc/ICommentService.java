package tn.esprit.pidev.bns.serviceInterface.siwarbacc;

import tn.esprit.pidev.bns.entity.siwarbacc.Blog;
import tn.esprit.pidev.bns.entity.siwarbacc.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> retrieveAllComments();

    public Comment retrieveComment(Integer idComment);
    public Comment updateComment (Comment c);
    public Comment addComment (Comment c);

    public void removeComment(Integer idComment);

}
