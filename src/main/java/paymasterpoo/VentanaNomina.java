/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paymasterpoo;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.*;
import paymasterpoo.*;

public class VentanaNomina extends JFrame {

    private JTextField txtNombre, txtSalario, txtHoras, txtVentas, txtAños;
    private JComboBox<String> comboTipo;
    private JTextArea areaResultado;

    public VentanaNomina() {
        setTitle("PayMaster - Sistema de Nómina");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#F5F7FA"));

        // PANEL SUPERIOR
        JLabel titulo = new JLabel("Sistema de Nómina", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.decode("#2C3E50"));
        add(titulo, BorderLayout.NORTH);

        // PANEL FORMULARIO
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        txtNombre.setBorder(new RoundedBorder(10));
        txtNombre.setBackground(Color.WHITE);
        panel.add(txtNombre);

        panel.add(new JLabel("Tipo de Empleado:"));
        comboTipo = new JComboBox<>(new String[]{
            "Asalariado", "Por Horas", "Comision", "Temporal"
        });
        comboTipo.setBorder(new RoundedBorder(10));
        comboTipo.setBackground(Color.WHITE);
        comboTipo.setForeground(Color.decode("#2C3E50"));
        comboTipo.setFont(new Font("Arial", Font.PLAIN, 13));
        comboTipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        comboTipo.setFocusable(false);
        comboTipo.setLightWeightPopupEnabled(true);
        panel.add(comboTipo);

        panel.add(new JLabel("Salario Base:"));
        txtSalario = new JTextField();
        txtSalario.setBorder(new RoundedBorder(10));
        txtSalario.setBackground(Color.WHITE);
        panel.add(txtSalario);

        panel.add(new JLabel("Horas (si aplica):"));
        txtHoras = new JTextField();
        txtHoras.setBorder(new RoundedBorder(10));
        txtHoras.setBackground(Color.WHITE);

        panel.add(txtHoras);

        panel.add(new JLabel("Ventas (si aplica):"));
        txtVentas = new JTextField();
        txtVentas.setBorder(new RoundedBorder(10));
        txtVentas.setBackground(Color.WHITE);
        panel.add(txtVentas);

        panel.add(new JLabel("Años:"));
        txtAños = new JTextField();
        txtAños.setBorder(new RoundedBorder(10));
        txtAños.setBackground(Color.WHITE);
        panel.add(txtAños);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBackground(Color.decode("#4A90E2"));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 14));
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCalcular.setBorder(new RoundedBorder(15));
        btnCalcular.setOpaque(true);
        panel.add(btnCalcular);

        add(panel, BorderLayout.CENTER);

        //  ÁREA DE RESULTADOS
        areaResultado = new JTextArea();
        areaResultado.setBackground(Color.WHITE);
        areaResultado.setForeground(Color.decode("#2C3E50"));
        areaResultado.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado), BorderLayout.SOUTH);

        // EVENTO BOTÓN
        btnCalcular.addActionListener(e -> calcular());
    }

    private void calcular() {
        try {
            String nombre = txtNombre.getText();
            String tipo = comboTipo.getSelectedItem().toString();

            Empleado empleado = null;

            double salario = txtSalario.getText().isEmpty() ? 0 : Double.parseDouble(txtSalario.getText());
            int horas = txtHoras.getText().isEmpty() ? 0 : Integer.parseInt(txtHoras.getText());
            double ventas = txtVentas.getText().isEmpty() ? 0 : Double.parseDouble(txtVentas.getText());
            int años = txtAños.getText().isEmpty() ? 0 : Integer.parseInt(txtAños.getText());

            switch (tipo) {
                case "Asalariado":
                    empleado = new EmpleadoAsalariado(nombre, salario, años);
                    break;

                case "Por Horas":
                    empleado = new EmpleadoPorHoras(nombre, salario, horas, años, true);
                    break;

                case "Comision":
                    empleado = new EmpleadoComision(nombre, salario, ventas, 0.05);
                    break;

                case "Temporal":
                    empleado = new EmpleadoTemporal(nombre, salario);
                    break;
            }

            double bruto = empleado.calcularSalarioBruto();
            double neto = empleado.calcularSalarioNeto();

            areaResultado.setText(
                    "Empleado: " + nombre + "\n"
                    + "Tipo: " + tipo + "\n"
                    + "Salario Bruto: $" + bruto + "\n"
                    + "Salario Neto: $" + neto
            );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new VentanaNomina().setVisible(true);
    }
}
