package com.springframework.converts;

import com.springframework.commands.CategoryCommand;
import com.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {
    private static final Long ID_VALUE = 1L;
    private static final String DESCRIPTION = "description";

    private CategoryToCategoryCommand converter;

    @Before
    public void setup() {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() {
       assertNull(converter.convert(null));
    }

    @Test
    public void testNotNullObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        CategoryCommand convert = converter.convert(category);

        assertEquals(category.getId(), convert.getId());
        assertEquals(category.getDescription(), convert.getDescription());
    }

}