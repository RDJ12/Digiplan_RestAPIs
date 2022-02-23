package com.digiplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digiplan.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
