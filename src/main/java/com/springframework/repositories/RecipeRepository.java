package com.springframework.repositories;

import com.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;



public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
