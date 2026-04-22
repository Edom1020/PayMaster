package paymasterpoo;

/**
 *
 * @author Esteb
 */
public class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;
    private int años;

    public EmpleadoAsalariado(String nombre, double salarioMensual, int años) {
        super(nombre);
        this.salarioMensual = salarioMensual;
        this.años = años;
    }

    @Override
    public double calcularSalarioBruto() {
        double salario = salarioMensual;

        // Bono 10% si > 5 años
        if (años > 5) {
            salario += salarioMensual * 0.10;
        }

        // Bono alimentación
        salario += 1000000;

        return salario;
    }
}