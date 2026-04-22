package paymasterpoo;

/**
 *
 * @author Esteb
 */
public abstract class Empleado {
    protected String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto (POLIMORFISMO)
    public abstract double calcularSalarioBruto();

    // Deducciones (4%)
    public double calcularDeducciones(double salarioBruto) {
        return salarioBruto * 0.04;
    }

    // Salario neto
    public double calcularSalarioNeto() {
        double bruto = calcularSalarioBruto();
        double deducciones = calcularDeducciones(bruto);
        double neto = bruto - deducciones;

        if (neto < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }

        return neto;
    }

    public String getNombre() {
        return nombre;
    }
}
