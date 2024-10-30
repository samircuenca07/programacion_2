//Ejercicio 1:Se requiere tener un ejercicio para realizar el cálculo del área y perímetro de las figuras triangulo,
//cuadrado y el rectángulo. Los datos deben ser ingresados utilizando el println y el BufferedReader.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CalArea {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String opcion;

        System.out.println("¡Bienvenido al programa de cálculo de áreas y perímetros de figuras geométricas!");

        do {
            System.out.println("\n¿Qué figura deseas calcular?");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Rectángulo");
            System.out.print("Elige una opción (1-3): ");

            try {
                opcion = lector.readLine();

                switch (opcion) {
                    case "1": // Cálculo para el Triángulo
                        System.out.println("\nIngrese la base del triángulo:");
                        double baseTriangulo = Double.parseDouble(lector.readLine());
                        System.out.println("Ingrese la altura del triángulo:");
                        double alturaTriangulo = Double.parseDouble(lector.readLine());
                        double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                        double perimetroTriangulo = baseTriangulo * 3; // Suponemos un triángulo equilátero
                        System.out.println("Área del triángulo: " + areaTriangulo);
                        System.out.println("Perímetro del triángulo (equilátero): " + perimetroTriangulo);
                        break;

                    case "2": // Cálculo para el Cuadrado
                        System.out.println("\nIngrese la medida de un lado del cuadrado:");
                        double ladoCuadrado = Double.parseDouble(lector.readLine());
                        double areaCuadrado = ladoCuadrado * ladoCuadrado;
                        double perimetroCuadrado = 4 * ladoCuadrado;
                        System.out.println("Área del cuadrado: " + areaCuadrado);
                        System.out.println("Perímetro del cuadrado: " + perimetroCuadrado);
                        break;

                    case "3": // Cálculo para el Rectángulo
                        System.out.println("\nIngrese el largo del rectángulo:");
                        double largoRectangulo = Double.parseDouble(lector.readLine());
                        System.out.println("Ingrese el ancho del rectángulo:");
                        double anchoRectangulo = Double.parseDouble(lector.readLine());
                        double areaRectangulo = largoRectangulo * anchoRectangulo;
                        double perimetroRectangulo = 2 * (largoRectangulo + anchoRectangulo);
                        System.out.println("Área del rectángulo: " + areaRectangulo);
                        System.out.println("Perímetro del rectángulo: " + perimetroRectangulo);
                        break;

                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }

                System.out.println("\n¿Deseas calcular otra figura? (s/n): ");
                opcion = lector.readLine();

            } catch (IOException e) {
                System.out.println("Ocurrió un error en la entrada de datos.");
                opcion = "n"; // Para salir del bucle si ocurre un error
            }

        } while (opcion.equalsIgnoreCase("s"));

        System.out.println("¡Gracias por usar el programa!");
    }
}
