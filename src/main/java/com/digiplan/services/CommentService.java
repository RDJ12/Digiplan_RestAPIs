package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Comment;

public interface CommentService {

    Comment getComment(Integer id);

    List<Comment> getAllComments();

    Comment addComment(Comment commentData);

    Comment updateComment(Integer id, Comment commentData);

    String deleteComment(Integer id);
}
