
package paymasterpoo;

import java.util.ArrayList;


public class Nomina {
    private ArrayList<Empleado> empleados;

    public Nomina() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void mostrarNomina() {
        for (Empleado e : empleados) {
            double bruto = e.calcularSalarioBruto();
            double neto = e.calcularSalarioNeto();

            System.out.println("Empleado: " + e.getNombre());
            System.out.println("Salario Bruto: " + bruto);
            System.out.println("Salario Neto: " + neto);
            System.out.println("--------------------------");
        }
    }
}
