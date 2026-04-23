package testpackages;

/**
 *
 * @author Esteb
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import paymasterpoo.*;

public class NominaTest {

    @Test
    void testAgregarEmpleado() {
        Nomina nomina = new Nomina();
        Empleado e = new EmpleadoTemporal("Test", 1000000);

        nomina.agregarEmpleado(e);

        assertNotNull(nomina);
    }
}