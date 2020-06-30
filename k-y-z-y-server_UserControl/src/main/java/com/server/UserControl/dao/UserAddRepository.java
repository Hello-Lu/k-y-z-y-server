package com.server.UserControl.dao;

import com.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddRepository extends JpaRepository<User,String> {
}
