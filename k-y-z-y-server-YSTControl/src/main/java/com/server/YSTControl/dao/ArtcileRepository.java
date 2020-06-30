package com.server.YSTControl.dao;

import com.server.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtcileRepository extends JpaRepository<Article,Integer> {
}
