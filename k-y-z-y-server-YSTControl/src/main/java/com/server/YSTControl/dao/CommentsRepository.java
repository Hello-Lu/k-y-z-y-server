package com.server.YSTControl.dao;

import com.server.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,String> {

    public List<Comments> findAllByParentidAndType(Integer id,Integer type);


}
