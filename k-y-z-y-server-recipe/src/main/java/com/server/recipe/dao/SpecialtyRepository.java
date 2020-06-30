package com.server.recipe.dao;

import com.server.model.Specialtylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialtylist,String> {
    Specialtylist findByName(String name);
}
