package com.digiplan.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digiplan.entities.Comment;
import com.digiplan.repositories.CommentRepository;
import com.digiplan.services.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getComment(Integer id) {
        log.info("@Start getComment");
        Comment comment = null;
        try {
            Optional<Comment> check = commentRepository.findById(id);
            if (check.isPresent())
                comment = commentRepository.getById(id);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return comment;
    }

    @Override
    public List<Comment> getAllComments() {
        log.info("@Start getAllCities");
        List<Comment> commentsList = null;
        try {
            commentsList = commentRepository.findAll();
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return commentsList;
    }

    @Override
    public Comment addComment(Comment commentData) {
        log.info("@Start addComment");
        Comment comment = null;
        try {
            comment = commentRepository.saveAndFlush(commentData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return comment;
    }

    @Override
    public Comment updateComment(Integer id, Comment commentData) {
        log.info("@Start updateComment");
        Comment comment = null;
        try {
            Optional<Comment> check = commentRepository.findById(id);
            if (check.isPresent())
                comment = commentRepository.saveAndFlush(commentData);
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return comment;
    }

    @Override
    public String deleteComment(Integer id) {
        log.info("@Start deleteComment");
        String status = "";
        try {
            commentRepository.deleteById(id);
            status = "Deleted";
        } catch (Exception exception) {
            log.error("Exception = " + exception);
        }
        return status;
    }

}
