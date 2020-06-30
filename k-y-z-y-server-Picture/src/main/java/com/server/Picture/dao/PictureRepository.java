package com.server.Picture.dao;

import com.server.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture,String> {
}
