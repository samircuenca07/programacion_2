package CICalculadora;

import java.util.Scanner;

public class CICalculadora {

    public static void main(String[] args) {
        // Declarar variables
        String nombre, apellido;
        int num1, num2;
        double resultado;
        String operacion;
        Scanner sc = new Scanner(System.in);

        System.out.println("Buenos días");

        // Ingreso de nombre y apellido
        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese su apellido: ");
        apellido = sc.nextLine();
        System.out.println("El nombre es: " + nombre + "\nSu apellido es: " + apellido);

        boolean continuar = true;

        while (continuar) {
            // Solicitar los números
            System.out.print("\nIngrese el número 1: ");
            num1 = sc.nextInt();
            System.out.print("Ingrese el número 2: ");
            num2 = sc.nextInt();

            // Elegir la operación
            System.out.println("\nSeleccione la operación que desea realizar: ");
            System.out.println("+ : Sumar");
            System.out.println("- : Restar");
            System.out.println("* : Multiplicar");
            System.out.println("/ : Dividir");
            System.out.print("Ingrese la operación: ");
            operacion = sc.next();

            // Realizar la operación
            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    System.out.println("El resultado de la suma es: " + resultado);
                    break;

                case "-":
                    resultado = num1 - num2;
                    System.out.println("El resultado de la resta es: " + resultado);
                    break;

                case "*":
                    resultado = num1 * num2;
                    System.out.println("El resultado de la multiplicación es: " + resultado);
                    break;

                case "/":
                    if (num2 != 0) {
                        resultado = (double) num1 / num2;
                        System.out.println("El resultado de la división es: " + resultado);
                    } else {
                        System.out.println("No es posible dividir por 0");
                    }
                    break;

                default:
                    System.out.println("Operación no válida. Intente nuevamente.");
            }

            // Preguntar si desea continuar
            System.out.print("\n¿Desea realizar otra operación? (s/n): ");
            String respuesta = sc.next();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("Gracias por usar la calculadora.");
        sc.close();
    }
}
