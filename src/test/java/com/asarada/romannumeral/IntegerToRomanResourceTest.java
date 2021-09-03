package com.asarada.romannumeral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanResourceTest {

    @Test
    void getIntToRoman() {
        IntegerToRomanResource ir = new IntegerToRomanResource();

        assertEquals(ir.getIntToRoman("A"),"{\"Warning\":\"Invalid Integer, passed parameter 'A' is not a number\"}");
        assertEquals(ir.getIntToRoman("88"),
                "{\n" +
                        "   \"input\" : \"88\",\n" +
                        "   \"output\" : \"LXXXVIII\"\n" +
                        "}");
        assertNotEquals(ir.getIntToRoman("4"),"{\n" +
                "   \"input\" : \"4\",\n" +
                "   \"output\" : \"IIII\"\n" +
                "}");
        assertDoesNotThrow(() -> {
            ir.getIntToRoman("4000");
        });
    }
}