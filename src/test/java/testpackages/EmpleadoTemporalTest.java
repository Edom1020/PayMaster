package testpackages;

/**
 *
 * @author Esteb
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import paymasterpoo.EmpleadoTemporal;

public class EmpleadoTemporalTest {

    @Test
    void testSalarioTemporal() {
        EmpleadoTemporal emp = new EmpleadoTemporal("Sofia", 1800000);
        double salario = emp.calcularSalarioBruto();

        assertEquals(1800000, salario);
    }
}
