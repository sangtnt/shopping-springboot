package com.shelmark.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shelmark.demo.Entity.User;
import com.shelmark.demo.Entity.UserRatePro;

@Repository
public interface UserRateProRepository extends JpaRepository<UserRatePro, Long> {
	public List<UserRatePro> findByUser(User user);
}
