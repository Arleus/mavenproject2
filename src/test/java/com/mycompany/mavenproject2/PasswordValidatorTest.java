/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aabv0
 */public class PasswordValidatorTest {

    @Test
    void testMenosDe8Caracteres() {
        assertFalse(PasswordValidator.isValid("Cali12"));
    }

    @Test
    void testcontraNula() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                PasswordValidator.isValid(null)
        );
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    void testSinCaracterEspecial() {
        assertFalse(PasswordValidator.isValid("Contraseña123"));
    }

    @Test
    void testEspacioAlInicio() {
        assertFalse(PasswordValidator.isValid(" asscasw123"));
    }

    @Test
    void testcontraValida() {
        assertTrue(PasswordValidator.isValid("Arturo123*"));
    }

    @Test
    void testSinMayuscula() {
        assertFalse(PasswordValidator.isValid("calidad2334/"));
    }
     @Test
    void testcontraVacia() {
        assertThrows(IllegalArgumentException.class, () ->
                PasswordValidator.isValid("")
        );
    }

    @Test
    void testEspacioAlFinal() {
        assertFalse(PasswordValidator.isValid("Arturo123* "));
    }
    @Test
    void testDobleEspacio() {
        assertFalse(PasswordValidator.isValid("Arturo  123*")); 
     }

 
    @Test
    void testcontraMuyLarga() {
        String larga = "A".repeat(65);
        assertFalse(PasswordValidator.isValid(larga));
    }

    @Test
    void testSinMinuscula() {
        assertFalse(PasswordValidator.isValid("ARTURO123*"));
    }

    @Test
    void testSinDigito() {
        assertFalse(PasswordValidator.isValid("Arturoasdf*"));
    }

   

    @Test
    void testEspacioInternoPermitido() {
        // Tiene mayus, minus, digito, especial -> si no tuviera, devolvería false
        assertFalse(PasswordValidator.isValid("Arturo 123")); 
    }
}
