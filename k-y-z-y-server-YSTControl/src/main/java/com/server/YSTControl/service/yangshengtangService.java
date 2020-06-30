package com.server.YSTControl.service;

import com.server.UserControl.dao.ClientUserRepository;
import com.server.YSTControl.dao.ArtcileRepository;
import com.server.YSTControl.dao.CommentsRepository;
import com.server.YSTControl.dao.MessageyangshengRepository;
import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class yangshengtangService {
    @Autowired
    MessageyangshengRepository messageyangshengRepository;

    @Autowired
    ArtcileRepository artcileRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    ClientUserRepository userRepository;

    public QueryResponseResult findclientuserList(int page, int size, String category) {

        //自定义条件查询
        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("category", ExampleMatcher.GenericPropertyMatchers.contains());

        //条件值对象
        InformationCategory informationCategory=new InformationCategory();
        informationCategory.setCategory(category);
        //分页参数
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Example<InformationCategory> example = Example.of(informationCategory, exampleMatcher);
        Page<InformationCategory> all = messageyangshengRepository.findAll(example, pageable);//实现自定义查询并且分页查询
        QueryResult queryResult= new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    public ResponseResult add(InformationCategory informationCategory) {

        if (informationCategory!=null){
            messageyangshengRepository.save(informationCategory);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult delete(InformationCategory informationCategory) {
        if (informationCategory!=null){
            messageyangshengRepository.delete(informationCategory);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);

    }

    public ResponseResult update(InformationCategory informationCategory) {

        if (informationCategory!=null){
            Optional<InformationCategory> byId = messageyangshengRepository.findById(informationCategory.getYsid());
            if (byId.isPresent()){
                InformationCategory informationCategory1 = byId.get();
                informationCategory1.setMessage(informationCategory.getMessage());
                informationCategory1.setCategory(informationCategory1.getCategory());
                messageyangshengRepository.save(informationCategory1);
                return new ResponseResult(CommonCode.SUCCESS);
            }
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ArticleVo getArticleInfo(Integer id) {
        ArticleVo articleVo = new ArticleVo();
        Optional<Article> article = artcileRepository.findById(id);
        List<Comments> comments1 = commentsRepository.findAllByParentidAndType(id,1);
        List<CommentsVo> commentsVos = new ArrayList<>();
        for (Comments comment:comments1){
            CommentsVo commentsVo = new CommentsVo();
            Client_user byId = userRepository.findById(comment.getFromUser());
            commentsVo.setFromUser(byId);
            commentsVo.setComment(comment.getComment());
            commentsVo.setCreateTime(comment.getCreate_time());

            List<Comments> comments = commentsRepository.findAllByParentidAndType(comment.getId(),2);
            if (comments != null && !comments.isEmpty()){
                List<CommentsVo> list = new ArrayList<>();
                for (Comments c:comments){
                    CommentsVo vo = new CommentsVo();
                    Client_user byId1 = userRepository.findById(c.getFromUser());
                    Client_user byId2 = userRepository.findById(c.getToUser());
                    vo.setFromUser(byId1);
                    vo.setToUser(byId2);
                    vo.setCreateTime(c.getCreate_time());
                    vo.setComment(c.getComment());
                    list.add(vo);
                }
                commentsVo.setCommentsVos(list);
            }
            commentsVos.add(commentsVo);
        }
        articleVo.setArticle(article.get());
        articleVo.setCommentsVos(commentsVos);
        return articleVo;
    }

}
