package com.springframework.services;


import com.springframework.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long valueOf, Long valueOf1);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
