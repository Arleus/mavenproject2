/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author aabv0
 */
public class TextProcessor {

    public static String reverseAndCapitalize(String input) {

        // Validación null
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // Trim inicial para detectar espacios
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        // Límite de longitud
        if (input.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // 1. Eliminar espacios inicio/fin → trimmed
        // 2. Invertir texto
        String reversed = new StringBuilder(trimmed).reverse().toString();

        // 3. Convertir a mayúsculas
        return reversed.toUpperCase();
    }
}