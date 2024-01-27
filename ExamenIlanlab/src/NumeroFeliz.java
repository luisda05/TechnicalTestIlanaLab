
public class NumeroFeliz {
	
    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(es_numero_feliz(19)); // True
        System.out.println(es_numero_feliz(4));  // False
    }

    // Función para determinar si un número es feliz
    public static boolean es_numero_feliz(int n) {
    	// Utilizamos un conjunto para detectar ciclos infinitos
        java.util.Set<Integer> ciclos = new java.util.HashSet<>();

        // Mientras el número no sea 1 y no esté en el conjunto de ciclos
        while (n != 1 && !ciclos.contains(n)) {
            // Añadimos el número al conjunto de ciclos
            ciclos.add(n);

            // Reemplazamos el número por la suma de los cuadrados de sus dígitos
            n = sumar_cuadrados_digitos(n);
        }

        // Devolvemos true si el número es 1, indicando que es un número feliz
        return n == 1;
    }

    // Función auxiliar para calcular la suma de los cuadrados de los dígitos de un número
    private static int sumar_cuadrados_digitos(int num) {
        // Inicializamos una variable para almacenar la suma de los cuadrados
        int suma = 0;

        // Mientras el número sea mayor que 0
        while (num > 0) {
            // Obtenemos el último dígito del número a la derecha
            int digito = num % 10;

            // Sumamos el cuadrado del dígito a la suma total
            suma += digito * digito;

            // Eliminamos el último dígito del número
            num /= 10;
        }

        // Devolvemos la suma de los cuadrados de los dígitos
        return suma;
    }
}