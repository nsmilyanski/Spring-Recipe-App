package com.springframework.converts;

import com.springframework.commands.IngredientCommand;
import com.springframework.domain.Ingredient;
import com.springframework.domain.Recipe;
import com.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {
    private static final Long INGREDIENT_ID = 1L;
    private static final BigDecimal INGREDIENT_AMOUNT = new BigDecimal("50");
    private static final String DESCRIPTION = "description";
    private static final String UOM_DESCRIPTION = "description";
    private static final Long UOM_ID = 2L;
    private static final Recipe RECIPE = new Recipe();

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        UnitOfMeasureToUnitOfMeasureCommand uom = new UnitOfMeasureToUnitOfMeasureCommand();
        converter = new IngredientToIngredientCommand(uom);
    }


    @Test
    public void testNullConverter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testConverterWitEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void testConverterWithUOM() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID);
        ingredient.setAmount(INGREDIENT_AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);
        unitOfMeasure.setDescription(UOM_DESCRIPTION);
        ingredient.setUom(unitOfMeasure);
        ingredient.setRecipe(RECIPE);

        IngredientCommand convert = converter.convert(ingredient);

        assertEquals(ingredient.getId(), convert.getId());
        assertEquals(ingredient.getDescription(), convert.getDescription());
        assertEquals(ingredient.getAmount(), convert.getAmount());
    }

    @Test
    public void testConvertNullUOM() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGREDIENT_ID);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(INGREDIENT_AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);
        //when
        IngredientCommand ingredientCommand = converter.convert(ingredient);
        //then
        assertNull(ingredientCommand.getUom());
        assertEquals(INGREDIENT_ID, ingredientCommand.getId());
        // assertEquals(RECIPE, ingredientCommand.get);
        assertEquals(INGREDIENT_AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }

}