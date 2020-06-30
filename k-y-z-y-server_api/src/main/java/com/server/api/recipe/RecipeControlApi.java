package com.server.api.recipe;

import com.server.common.model.response.QueryResponseResult;
import com.server.common.model.response.ResponseResult;
import com.server.model.Recipe;

public interface RecipeControlApi {
    public QueryResponseResult RecipeCategoryList(int page, int size, String category);
    public ResponseResult RecipeDele(String recipeid);
    public ResponseResult Recipeupdate(Recipe recipe);
    public Recipe Recipeselect(String recipeid);
}
