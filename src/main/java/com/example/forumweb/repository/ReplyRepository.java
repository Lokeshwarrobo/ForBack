package com.example.forumweb.repository;

import com.example.forumweb.model.Reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query(value = "select rep_id from reply where rep_id = ?1", nativeQuery = true )
    Long findRepId(Long repId);

	List<Reply> findReplyByAnswerId(Long answerId);
}