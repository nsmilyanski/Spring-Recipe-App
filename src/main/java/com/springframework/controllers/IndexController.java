package com.springframework.controllers;

import com.springframework.domain.Category;
import com.springframework.domain.UnitOfMeasure;
import com.springframework.repositories.CategoryRepository;
import com.springframework.repositories.RecipeRepository;
import com.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {
        System.out.println("Some message to say....1234");

        Optional<Category> american = categoryRepository.findCategoryByDescription("American");
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findUnitOfMeasureByDescription("Teaspoon");

        System.out.println("Print a american " + american.get().getId());
        System.out.println("Print a teaspoon " + teaspoon.get().getId());


        return "index";
    }
}
