package com.StudyGuide.StudyGuide.dao.repository.test;

import com.StudyGuide.StudyGuide.dao.model.entity.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {


}
