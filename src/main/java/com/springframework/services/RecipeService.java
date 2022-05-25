package com.springframework.services;

import com.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
