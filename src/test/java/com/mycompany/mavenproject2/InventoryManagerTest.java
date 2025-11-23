/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject2;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    @Test
    void testCantidadCero() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Laptop", 0));
    }

    @Test
    void testCantidadMayorA1000() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Laptop", 1001));
    }

    @Test
    void testNombreVacio() {
        InventoryManager manager = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("", 5));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    void testCantidadNegativa() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("Laptop", -1));
    }

    @Test
    void testNombreMuyCorto() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("H", 5));
    }

    @Test
    void testNombreSoloEspacios() {
        InventoryManager manager = new InventoryManager();
        assertThrows(IllegalArgumentException.class,
                () -> manager.addItem("   ", 3));
    }

    @Test
    void testAgregarItemCorrectamente() {
        InventoryManager manager = new InventoryManager();
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }
}