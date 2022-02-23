package com.digiplan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digiplan.entities.Comment;
import com.digiplan.services.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping("/getComment/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable Integer id) {
		Comment comment = this.commentService.getComment(id);
		if (comment != null)
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllComments")
	public List<Comment> getAllComments() {
		return this.commentService.getAllComments();
	}

	@PostMapping("/addComment")
	public ResponseEntity<Comment> addComment(@RequestBody Comment commentData) {
		return new ResponseEntity<Comment>(this.commentService.addComment(commentData), HttpStatus.CREATED);
	}

	@PutMapping("/updateComment/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable Integer id, @RequestBody Comment commentData) {
		Comment comment = this.commentService.updateComment(id, commentData);
		if (comment != null)
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable Integer id) {
		String status = this.commentService.deleteComment(id);
		if (status.equals("Deleted"))
			return new ResponseEntity<String>(status, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
