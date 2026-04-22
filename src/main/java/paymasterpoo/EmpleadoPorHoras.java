package paymasterpoo;

/**
 *
 
 */
public class EmpleadoPorHoras extends Empleado {
    private double tarifaHora;
    private int horas;
    private int años;
    private boolean fondoAhorro;

    public EmpleadoPorHoras(String nombre, double tarifaHora, int horas, int años, boolean fondoAhorro) {
        super(nombre);

        if (horas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }

        this.tarifaHora = tarifaHora;
        this.horas = horas;
        this.años = años;
        this.fondoAhorro = fondoAhorro;
    }

    @Override
    public double calcularSalarioBruto() {
        double salario;

        if (horas <= 40) {
            salario = horas * tarifaHora;
        } else {
            salario = (40 * tarifaHora) + ((horas - 40) * tarifaHora * 1.5);
        }

        // Fondo ahorro (si aplica)
        if (años > 1 && fondoAhorro) {
            salario += salario * 0.02;
        }

        return salario;
    }
}