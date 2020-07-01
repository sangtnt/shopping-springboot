package com.shelmark.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shelmark.demo.Entity.UserReviewPro;

@Repository
public interface UserReviewProRepository extends JpaRepository<UserReviewPro, Long >{

}
