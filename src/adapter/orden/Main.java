package adapter.orden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Ordenador {
    static void ordenar(List<Coche> coches){
        boolean ok = false;
        while (!ok) {
            ok = true;
            for (int i = 1; i < coches.size(); i++) {
                if (coches.get(i-1).velocidad > coches.get(i).velocidad) {
                    ok = false;
                    Coche swap = coches.get(i);
                    coches.set(i, coches.get(i-1));
                    coches.set(i-1, swap);
                }
            }
        }
    }
}

class Coche {
    int velocidad;

    public Coche() {
        this.velocidad = ThreadLocalRandom.current().nextInt(10);
    }

    @Override
    public String toString() {
        return "{" + velocidad +"}";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Coche> coches = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            coches.add(new Coche());
        }

        System.out.println(coches);

        Ordenador.ordenar(coches);

        System.out.println(coches);
    }

}
