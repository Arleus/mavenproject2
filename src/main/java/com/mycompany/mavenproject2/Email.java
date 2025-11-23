/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author aabv0
 */
public class Email {

    public boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        if (email.length() < 6 || email.length() > 254) {
            return false;
        }

        int atIndex = email.indexOf('@');
        if (atIndex == -1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);

        if (local.isEmpty() || local.startsWith(".") || local.endsWith(".") || local.contains("..")) {
            return false;
        }

        if (!local.matches("[A-Za-z0-9._-]+")) {
            return false;
        }

        if (!domain.contains(".")) {
            return false;
        }

        String[] domainParts = domain.split("\\.");
        if (domainParts.length < 2) {
            return false;
        }

        String nombreDominio = domainParts[0];
        String extension = domainParts[domainParts.length - 1];

        if (nombreDominio.length() < 2) {
            return false;
        }

        String[] validExtensions = {"com", "net", "org", "edu", "gov", "pe"};
        boolean extensionValida = false;

        for (String ext : validExtensions) {
            if (extension.equalsIgnoreCase(ext)) {
                extensionValida = true;
                break;
            }
        }

        if (!extensionValida) {
            return false;
        }

        return true;
    }
}


