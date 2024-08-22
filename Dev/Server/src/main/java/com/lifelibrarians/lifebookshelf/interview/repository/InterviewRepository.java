package com.lifelibrarians.lifebookshelf.interview.repository;

import com.lifelibrarians.lifebookshelf.interview.domain.Interview;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

	@Query("SELECT i FROM Interview i "
			+ "JOIN FETCH i.questions "
			+ "JOIN FETCH i.currentQuestion "
			+ "WHERE i.id = :interviewId")
	Optional<Interview> findWithQuestionsById(Long interviewId);
}
