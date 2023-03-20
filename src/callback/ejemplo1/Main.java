package callback.ejemplo1;

class Algo {

    interface Callback {
        void call(String valorDeRetorno);
    }

    void hacerAlgo(Callback callback){
        callback.call("algo a retornar");
    }
}

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo();

        algo.hacerAlgo(valorDeRetorno -> System.out.println(valorDeRetorno));


    }
}
