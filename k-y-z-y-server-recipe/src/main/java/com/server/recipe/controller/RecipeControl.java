package com.server.recipe.controller;

import com.server.api.recipe.RecipeControlApi;
import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Recipe;
import com.server.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Recipe")
public class RecipeControl implements RecipeControlApi {

    @Autowired
    RecipeService recipeService;
    /**
    配方分类查询
     */
    @Override
    @GetMapping("/list/{page}/{size}/{category}")
    public QueryResponseResult RecipeCategoryList(@PathVariable("page")int page, @PathVariable("page")int size, @PathVariable("category")String category) {
        return recipeService.RecipeCategoryList(page,size,category);
    }

    @Override
    @PostMapping("/RecipeDele")
    public ResponseResult RecipeDele(@RequestParam("recipeid") String recipeid) {
        return recipeService.RecipeDele(recipeid);
    }

    @Override
    @PostMapping("/Recipeupdate")
    public ResponseResult Recipeupdate(Recipe recipe) {

        return recipeService.Recipeupdate(recipe);
    }

    @Override
    @PostMapping("/Recipeselect")
    public Recipe Recipeselect(String recipeid) {
        return recipeService.Recipeselect(recipeid);
    }


}
