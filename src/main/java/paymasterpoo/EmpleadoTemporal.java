/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymasterpoo;

/**
 *
 * @author sebastian ortiz 
 */
public class EmpleadoTemporal extends Empleado {
    private double salarioMensual;

    public EmpleadoTemporal(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioMensual;
    }
}