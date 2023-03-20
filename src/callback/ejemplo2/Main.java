package callback.ejemplo2;

import java.util.Random;

class Algo {

    interface Callback {
        void retornoUnString(String valorDeRetorno);
        void retornoUnInt(int valorDeRetorno);
        void retornoUnBoolean(boolean valorDeRetorno);
        void retornoUnError(String valorDeRetorno);
    }

    void hacerAlgo(Callback callback){
        if (new Random().nextBoolean()) {
            callback.retornoUnString("algo a retornar");
        } else if (new Random().nextBoolean()) {
            callback.retornoUnInt(324342);
        } else if (new Random().nextBoolean()) {
            callback.retornoUnBoolean(true);
        } else if (new Random().nextBoolean()) {
            callback.retornoUnError("Error xyz");
        } else {
            // no retorna nada
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();

        algo.hacerAlgo(new Algo.Callback() {
            @Override
            public void retornoUnString(String valorDeRetorno) {
                System.out.println("El resultado es: " + valorDeRetorno);
            }

            @Override
            public void retornoUnInt(int valorDeRetorno) {
                System.out.println("El resultado es: " + valorDeRetorno);
            }

            @Override
            public void retornoUnBoolean(boolean valorDeRetorno) {
                System.out.println("El resultado es: " + valorDeRetorno);
            }

            @Override
            public void retornoUnError(String valorDeRetorno) {
                System.out.println("Ha habido un error: " + valorDeRetorno);
            }
        });
    }
}
