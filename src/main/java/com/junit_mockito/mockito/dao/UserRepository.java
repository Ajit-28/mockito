package com.junit_mockito.mockito.dao;

import com.junit_mockito.mockito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
