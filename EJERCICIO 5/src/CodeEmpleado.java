import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;

public class CodeEmpleado {
    private String idEmpleado;
    private String primerNombre;
    private String apellidoEmpleado;
    private String generoEmpleado;
    private double salarioMensual;
    private LocalDate fechaNacimientoEmpleado;
    private LocalDate fechaIngresoEmpleado;

    // Constructor
    public CodeEmpleado(String idEmpleado, String primerNombre, String apellidoEmpleado, String generoEmpleado, double salarioMensual,
                        LocalDate fechaNacimientoEmpleado, LocalDate fechaIngresoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.primerNombre = primerNombre;
        this.apellidoEmpleado = apellidoEmpleado;
        this.generoEmpleado = generoEmpleado;
        this.salarioMensual = salarioMensual;
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
    }

    public void actualizarSalario(double nuevoSalario) {
        this.salarioMensual = nuevoSalario;
    }


    public int obtenerEdad() {
        return Period.between(fechaNacimientoEmpleado, LocalDate.now()).getYears();
    }


    public int calcularAntiguedad() {
        return Period.between(fechaIngresoEmpleado, LocalDate.now()).getYears();
    }


    public double calcularPrestaciones() {
        int antiguedad = calcularAntiguedad();
        return (antiguedad * salarioMensual) / 12;
    }


    public String mostrarInformacion() {
        return "Empleado:\n" +
                "ID: " + idEmpleado + "\n" +
                "Nombre: " + primerNombre + "\n" +
                "Apellido: " + apellidoEmpleado + "\n" +
                "Género: " + generoEmpleado + "\n" +
                "Salario: $" + salarioMensual + "\n" +
                "Fecha de Nacimiento: " + fechaNacimientoEmpleado + "\n" +
                "Fecha de Ingreso: " + fechaIngresoEmpleado + "\n" +
                "Edad: " + obtenerEdad() + " años\n" +
                "Antigüedad: " + calcularAntiguedad() + " años\n" +
                "Prestaciones: $" + calcularPrestaciones();
    }

    public static void main(String[] args) {
        while (true) {

            String idEmpleado = JOptionPane.showInputDialog("Ingrese el ID del empleado:");
            String primerNombre = JOptionPane.showInputDialog("Ingrese el primer nombre del empleado:");
            String apellidoEmpleado = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");
            String generoEmpleado = JOptionPane.showInputDialog("Ingrese el género del empleado:");
            double salarioMensual = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual del empleado:"));


            LocalDate fechaNacimientoEmpleado = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (aaaa-mm-dd):"));
            LocalDate fechaIngresoEmpleado = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de ingreso (aaaa-mm-dd):"));


            CodeEmpleado empleado = new CodeEmpleado(idEmpleado, primerNombre, apellidoEmpleado, generoEmpleado, salarioMensual, fechaNacimientoEmpleado, fechaIngresoEmpleado);


            JOptionPane.showMessageDialog(null, empleado.mostrarInformacion());

            boolean continuarConEmpleado = true;
            while (continuarConEmpleado) {

                int opcion = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Opciones",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        new String[]{"Modificar Salario", "Calcular Edad", "Calcular Prestaciones", "Finalizar"}, "Finalizar");

                switch (opcion) {
                    case 0: // Modificar Salario
                        double nuevoSalario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo salario:"));
                        empleado.actualizarSalario(nuevoSalario);
                        JOptionPane.showMessageDialog(null, "Salario actualizado:\n" + empleado.mostrarInformacion());
                        break;
                    case 1: // Calcular Edad
                        JOptionPane.showMessageDialog(null, "Edad del empleado: " + empleado.obtenerEdad() + " años");
                        break;
                    case 2: // Calcular Prestaciones
                        JOptionPane.showMessageDialog(null, "Prestaciones del empleado: $" + empleado.calcularPrestaciones());
                        break;
                    case 3: // Finalizar opciones
                        continuarConEmpleado = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }


                if (continuarConEmpleado) {
                    int realizarOtraOperacion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación para este empleado?");
                    if (realizarOtraOperacion != JOptionPane.YES_OPTION) {
                        continuarConEmpleado = false;
                    }
                }
            }


            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otro empleado?");
            if (continuar != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                break;
            }
        }
    }
}
