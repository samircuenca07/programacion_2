package CICalculadora;

import javax.swing.JOptionPane;

public class ObjCalculadora {

    String operacion;
    double num1;
    int num2;


    public void iniciarCalculadora() {
        JOptionPane.showMessageDialog(null, "¡Bienvenido a la Calculadora!");
        boolean continuar = true;

        while (continuar) {
            try {

                num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número: "));
                num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo número: "));


                operacion = JOptionPane.showInputDialog("Ingrese la operación (+, -, *, /): ");


                double resultado = this.CalculaOperacion();
                JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: entrada no válida. Asegúrese de ingresar números correctos.");
            }


            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (respuesta != JOptionPane.YES_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por usar la calculadora.");
            }
        }
    }


    private double CalculaOperacion() {
        double resultado = 0;
        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede dividir por cero.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operación no válida.");
        }
        return resultado;
    }
}
