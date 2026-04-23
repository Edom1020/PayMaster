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
import paymasterpoo.EmpleadoAsalariado;

public class EmpleadoAsalariadoTest {

    @Test
    void testSalarioSinBono() {
        EmpleadoAsalariado emp = new EmpleadoAsalariado("Carlos", 3000000, 3);
        double salario = emp.calcularSalarioBruto();

        assertEquals(3000000 + 1000000, salario);
    }

    @Test
    void testSalarioConBono() {
        EmpleadoAsalariado emp = new EmpleadoAsalariado("Carlos", 3000000, 6);
        double salario = emp.calcularSalarioBruto();

        double esperado = 3000000 + (3000000 * 0.10) + 1000000;
        assertEquals(esperado, salario);
    }
}
