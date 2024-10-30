import javax.swing.JOptionPane;

public class CodeVehiculos {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema de gestión de vehículos!");

        // INGRESO DE DATOS
        String numeroMotor = JOptionPane.showInputDialog("Ingrese el número de motor:");
        String numeroVentanas = JOptionPane.showInputDialog("Ingrese el número de ventanas:");
        String cantidadPuertas = JOptionPane.showInputDialog("Ingrese la cantidad de puertas:");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");

        // KM INICIAL
        String kilometrajeInicialStr = JOptionPane.showInputDialog("Ingrese el kilometraje inicial:");
        int kilometrajeInicial = convertirKilometraje(kilometrajeInicialStr, "El kilometraje inicial debe ser un número entero no negativo.");

        // KM FINAL

        String kilometrajeFinalStr = JOptionPane.showInputDialog("Ingrese el kilometraje final (debe ser mayor o igual al inicial):");
        int kilometrajeFinal = convertirKilometraje(kilometrajeFinalStr, "El kilometraje final debe ser un número entero no negativo.");

        // VALIDACION KILOMETRAJE

        if (kilometrajeFinal < kilometrajeInicial) {
            JOptionPane.showMessageDialog(null, "Error: El kilometraje final debe ser mayor o igual al inicial.");
            return; // Termina el programa si la condición no se cumple
        }

        // CALCULO KM RECORRIDOS

        int kilometrosRecorridos = kilometrajeFinal - kilometrajeInicial;

        // DATOS

        String resultado = "Información del Vehículo:\n" +
                "Número de Motor: " + numeroMotor + "\n" +
                "Número de Ventanas: " + numeroVentanas + "\n" +
                "Cantidad de Puertas: " + cantidadPuertas + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Kilometraje Inicial: " + kilometrajeInicial + " km\n" +
                "Kilometraje Final: " + kilometrajeFinal + " km\n" +
                "Kilómetros Recorridos: " + kilometrosRecorridos + " km";

        JOptionPane.showMessageDialog(null, resultado);
    }


    private static int convertirKilometraje(String kilometrajeStr, String mensajeError) {
        int kilometraje = 0;

        // VERIFICAR Y RESTRICCION DE VALORES NEGATIVOS

        if (kilometrajeStr != null && !kilometrajeStr.isEmpty()) {
            for (char c : kilometrajeStr.toCharArray()) {
                if (!Character.isDigit(c)) {
                    JOptionPane.showMessageDialog(null, mensajeError);
                    System.exit(0);
                }
            }
            kilometraje = Integer.parseInt(kilometrajeStr);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError);
            System.exit(0);
        }

        return kilometraje;
    }
}
