package com.springframework.converts;

import com.springframework.commands.UnitOfMeasureCommand;
import com.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {
    private static final String DESCRIPTION = "description";
    private static final Long ID_VALUE = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testConverterWithNull() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testConverterWithEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void testConverter() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(ID_VALUE);
        uom.setDescription(DESCRIPTION);

        UnitOfMeasureCommand convert = converter.convert(uom);


        assertEquals(uom.getId(), convert.getId());
        assertEquals(uom.getDescription(), convert.getDescription());
    }
}