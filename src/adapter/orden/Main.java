package adapter.orden;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Ordenador {
    static void ordenar(List<Personaje> personajes){
        boolean ok = true;
        while (ok) {
            for (int i = 1; i < personajes.size(); i++) {
                if (personajes.get(i-1).velocidad < personajes.get(i).velocidad) {
                    ok = false;
                    Personaje swap = personajes.get(i);
                    personajes.set(i, personajes.get(i-1));
                    personajes.set(i-1, swap);
                }
            }
        }
    }
}

class Personaje {
    int fuerza, velocidad;

    public Personaje() {
        this.fuerza = ThreadLocalRandom.current().nextInt(10);
        this.velocidad = ThreadLocalRandom.current().nextInt(10);
    }

    @Override
    public String toString() {
        return "{" + fuerza + "," + velocidad +"}";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Personaje> personajes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personajes.add(new Personaje());
        }

        Ordenador.ordenar(personajes);

//        personajes.sort(new Comparator<Personaje>() {
//            @Override
//            public int compare(Personaje personaje, Personaje t1) {
//                return personaje.velocidad + personaje.fuerza;
//            }
//        });

        System.out.println(personajes);
    }

}
