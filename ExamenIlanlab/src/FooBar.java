import java.util.Scanner;

public class FooBar {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Variable para almacenar el número ingresado
        int numero;

        do {
            // Solicitar al usuario que ingrese un número
            System.out.print("Ingrese un número entero positivo (ingrese 0 para salir): ");
            numero = scanner.nextInt();

            // Verificar si el número es positivo y aplicar las condiciones
            if (numero > 0) {
                if (numero % 3 == 0 && numero % 5 == 0) {
                    System.out.println("FooBar");
                } else if (numero % 3 == 0) {
                    System.out.println("Foo");
                } else if (numero % 5 == 0) {
                    System.out.println("Bar");
                } else {
                    System.out.println(numero);
                }
            } else if (numero != 0) {
                System.out.println("Por favor, ingrese un número entero positivo.");
            }

        } while (numero != 0);

        // Cerrar el objeto Scanner después de su uso
        scanner.close();
    }
}