package com.StudyGuide.StudyGuide.dao.repository.user;

import com.StudyGuide.StudyGuide.dao.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
