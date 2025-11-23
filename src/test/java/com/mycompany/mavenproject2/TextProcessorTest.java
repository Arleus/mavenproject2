/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TextProcessorTest {

    // 1. Texto null → excepción
    @Test
    void testTextoNull() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                TextProcessor.reverseAndCapitalize(null);
            }
        });
    }

    // 2. Texto vacío (solo espacios)
    @Test
    void testTextoSoloEspacios() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                TextProcessor.reverseAndCapitalize("   ");
            }
        });
    }

    // 3. Texto válido "hola" → "ALOH"
    @Test
    void testTextoValidoHola() {
        String result = TextProcessor.reverseAndCapitalize("hola");
        assertEquals("ALOH", result);
    }

    // 4. Texto mayor a 1000 caracteres
    @Test
    void testTextoMayorA1000() {
        String textoLargo = "a".repeat(1001);

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() {
                TextProcessor.reverseAndCapitalize(textoLargo);
            }
        });
    }

    // 5. Texto normal sin espacios "python" → "NOHTYP"
    @Test
    void testTextoPython() {
        assertEquals("NOHTYP", TextProcessor.reverseAndCapitalize("python"));
    }

    // 6. Texto con espacios " hola " → "ALOH"
    @Test
    void testTextoConEspacios() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("  hola  "));
    }
    
    @Test
    void testClassLoads() {
        new TextProcessor(); // aunque no tenga constructor, fuerza la carga de clase
}
}
