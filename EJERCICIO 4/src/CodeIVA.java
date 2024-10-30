//EJERCICIO 4

import javax.swing.JOptionPane;

public class CodeIVA {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de cálculo de IVA");

        // INGRESO NOMBRE DEL PRODUCTO
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");

        // INGRESO PRECIO
        double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));

        // PREGUNTA DEL IVA
        int tieneIva = JOptionPane.showConfirmDialog(null, "¿El producto tiene IVA?", "IVA", JOptionPane.YES_NO_OPTION);

        double valorIva = 0;
        double totalPagar = precioProducto;

        // VERIFICACION IVA
        if (tieneIva == JOptionPane.YES_OPTION) {
            // Determinar el porcentaje de IVA según el precio del producto
            if (precioProducto <= 500) {
                valorIva = precioProducto * 0.12;
            } else if (precioProducto <= 1500) {
                valorIva = precioProducto * 0.14;
            } else {
                valorIva = precioProducto * 0.15;
            }
            // Calcular el total con IVA
            totalPagar = precioProducto + valorIva;
        }

        // RESULTADOS FINALES
        JOptionPane.showMessageDialog(null, "Producto: " + nombreProducto +
                "\nPrecio original: $" + precioProducto +
                "\nIVA aplicado: $" + valorIva +
                "\nTotal a pagar: $" + totalPagar);
    }
}
