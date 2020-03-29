package com.StudyGuide.StudyGuide.dao.repository.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
