package callback.calculadora;


class Calculadora {

    static int suma(int... numeros) {
        int resultado = 0;
        for (Integer numero : numeros) resultado += numero; // ¿ y si resultado + numero > Integer.MAX_VALUE ?
        return resultado;
    }

    static int divide(int a, int b) {
        return a/b;  // ¿ y si b es 0 ?
    }
}

public class Main {

    public static void main(String[] args) {
        int resultadoSuma = Calculadora.suma(1, 2, 3, 10, 20);
        System.out.println("La suma es: " + resultadoSuma);

        int resultadoDivision = Calculadora.divide(13, 2);
        System.out.println("La division es: " + resultadoDivision);

        int resultadoOtraSuma = Calculadora.suma(1, 2147483646, 1);
        System.out.println("La suma es: " + resultadoOtraSuma);

        int resultadoOtraDivision = Calculadora.divide(13, 0);
        System.out.println("La division es: " + resultadoOtraDivision);
    }
}
