package com.springframework.services;

import com.springframework.commands.RecipeCommand;
import com.springframework.domain.Recipe;


import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long valueOf);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long valueOf);

    void deleteById(Long valueOf);
}
