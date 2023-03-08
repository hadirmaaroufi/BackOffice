package tn.esprit.pidev.bns.serviceInterface.siwarbacc;

import tn.esprit.pidev.bns.entity.siwarbacc.Blog;
import tn.esprit.pidev.bns.entity.siwarbacc.Comment;

import java.util.List;

public interface ICommentService {
    public List<Comment> retrieveAllComments();

    public Comment updateComment(Integer id, Comment updcomment );
    public Comment addComment (Comment c);
    public void removeComment(Integer id);
    public Comment getCommentById(Integer id) ;

    //public Comment affectCommentToForum (Integer idComment, String titleF);
}
