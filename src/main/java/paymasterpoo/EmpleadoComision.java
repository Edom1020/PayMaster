package paymasterpoo;

/**
 *
 * 
 */
public class EmpleadoComision extends Empleado {
    private double salarioBase;
    private double ventas;
    private double porcentaje;

    public EmpleadoComision(String nombre, double salarioBase, double ventas, double porcentaje) {
        super(nombre);

        if (ventas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }

        this.salarioBase = salarioBase;
        this.ventas = ventas;
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularSalarioBruto() {
        double salario = salarioBase + (ventas * porcentaje);

        // Bono 3% si ventas > 20M
        if (ventas > 20000000) {
            salario += ventas * 0.03;
        }

        // Bono alimentación
        salario += 1000000;

        return salario;
    }
}
