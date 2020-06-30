package com.server.UserControl.dao;


import com.server.model.Client_user;
import com.server.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.PrimitiveIterator;

public interface ClientUserRepository extends JpaRepository<Client_user,String> {

    public Client_user findByUsernameAndPassword(String username,String password);

    public Client_user findByUsername(String username);

    public Client_user findById(Integer id);
}
