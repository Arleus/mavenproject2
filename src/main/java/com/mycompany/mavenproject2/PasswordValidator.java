/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author aabv0
 */
public class PasswordValidator {

    private static final String SPECIAL_CHARS = "!@#$%*&?()_+=\\{\\}\\[\\]\\|;:\"'<>,./?";

    public static boolean isValid(String password) {

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        if (password.startsWith(" ") || password.endsWith(" ")) {
            return false;
        }

        if (password.contains("  ")) { // doble espacio
            return false;
        }

        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (SPECIAL_CHARS.indexOf(ch) != -1) {
                hasSpecial = true;
            } else if (ch == ' ') {
                continue;
            } 
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
