package com.digiplan.services;

import java.util.List;

import com.digiplan.entities.Comment;

public interface CommentService {

	public Comment getComment(Integer id);

	public List<Comment> getAllComments();

	public Comment addComment(Comment commentData);

	public Comment updateComment(Integer id, Comment commentData);

	public String deleteComment(Integer id);
}
