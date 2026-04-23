/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testpackages;

/**
 *
 * @author Esteb
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import paymasterpoo.EmpleadoComision;

public class EmpleadoComisionTest {

    @Test
    void testSalarioNormal() {
        EmpleadoComision emp = new EmpleadoComision("Luis", 1000000, 10000000, 0.05);
        double salario = emp.calcularSalarioBruto();

        double esperado = 1000000 + (10000000 * 0.05) + 1000000;
        assertEquals(esperado, salario);
    }

    @Test
    void testSalarioConBonoVentas() {
        EmpleadoComision emp = new EmpleadoComision("Luis", 1000000, 25000000, 0.05);
        double salario = emp.calcularSalarioBruto();

        double esperado = 1000000 + (25000000 * 0.05) + (25000000 * 0.03) + 1000000;
        assertEquals(esperado, salario);
    }

    @Test
    void testVentasNegativas() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmpleadoComision("Luis", 1000000, -1000, 0.05);
        });
    }
}