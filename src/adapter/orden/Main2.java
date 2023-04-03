package adapter.orden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Ordenador2 {
    interface Comparador {
        boolean comparar(Coche2 coche1, Coche2 coche2);
    }

    static void ordenar(List<Coche2> coches, Comparador comparador){
        boolean ok = false;
        while (!ok) {
            ok = true;
            for (int i = 1; i < coches.size(); i++) {
                if (comparador.comparar(coches.get(i-1), coches.get(i))) {
                    ok = false;
                    Coche2 swap = coches.get(i);
                    coches.set(i, coches.get(i-1));
                    coches.set(i-1, swap);
                }
            }
        }
    }
}

class Coche2 {
    int velocidad;

    public Coche2() {
        this.velocidad = ThreadLocalRandom.current().nextInt(10);
    }

    @Override
    public String toString() {
        return "{" + velocidad +"}";
    }
}

public class Main2 {
    public static void main(String[] args) {
        List<Coche2> coches = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            coches.add(new Coche2());
        }

        System.out.println(coches);

        Ordenador2.ordenar(coches, new Ordenador2.Comparador() {
            @Override
            public boolean comparar(Coche2 coche1, Coche2 coche2) {
                return coche1.velocidad > coche2.velocidad;
            }
        });

        System.out.println(coches);
    }

}
