package com.server.recipe.service;


import com.server.common.model.response.CommonCode;
import com.server.common.model.response.QueryResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.InformationCategory;
import com.server.model.Recipe;
import com.server.recipe.dao.RecipeRepository;
import com.server.common.model.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;
    public QueryResponseResult RecipeCategoryList(int page, int size, String category) {
        //自定义条件查询
        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("category", ExampleMatcher.GenericPropertyMatchers.contains());
        Recipe recipe=new Recipe();
        recipe.setCategory(category);

        //分页参数
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        Example<Recipe> example = Example.of(recipe, exampleMatcher);
        Page<Recipe> all = recipeRepository.findAll(example, pageable);//实现自定义查询并且分页查询
        QueryResult queryResult= new QueryResult();
        queryResult.setList(all.getContent());//数据列表
        queryResult.setTotal(all.getTotalElements());//数据总记录数
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;

    }

    public ResponseResult RecipeDele(String recipeid) {

        if (recipeid != null) {
            recipeRepository.deleteById(recipeid);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public ResponseResult Recipeupdate(Recipe recipe) {
        if (recipe != null) {
            Optional<Recipe> byId = recipeRepository.findById(recipe.getRecipeid());
            if (byId.isPresent()){
                Recipe recipe1 = byId.get();
                recipe1.setCategory(recipe.getCategory());
                recipe1.setMessage(recipe.getMessage());
                recipeRepository.save(recipe1);
                return new ResponseResult(CommonCode.SUCCESS);
            }
            return new ResponseResult(CommonCode.FAIL);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    public Recipe Recipeselect(String recipeid) {

        if (recipeid!=null){
            Optional<Recipe> byId = recipeRepository.findById(recipeid);
            if (byId.isPresent()){
                Recipe recipe = byId.get();
                return recipe;
            }
            return null;
        }
        return null;
    }
}
