package testpackages;

/**
 *
 * @author Esteb
 * 
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import paymasterpoo.EmpleadoPorHoras;

public class EmpleadoPorHorasTest {

    @Test
    void testCalculoHorasExtras() {
        EmpleadoPorHoras emp = new EmpleadoPorHoras("Juan", 10000, 50, 2, true);
        double salario = emp.calcularSalarioBruto();

        assertTrue(salario > 0);
    }
}