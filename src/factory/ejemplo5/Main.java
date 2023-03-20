package factory.ejemplo5;

import java.util.Calendar;
import java.util.Random;

abstract class SuperClase {
    abstract void metodo();
}

class SubClaseA extends SuperClase {
    @Override
    public void metodo() {
        System.out.println("Soy de clase A");
    }
}

class SubClaseB extends SuperClase {
    @Override
    public void metodo() {
        System.out.println("Soy de clase B");
    }
}

abstract class ClaseQueUsaAoB {
    // abstract factory method
    abstract SuperClase obtenerObjeto();
}

class ClaseQueUsaA extends ClaseQueUsaAoB {

    @Override
    SuperClase obtenerObjeto() {
        return new SubClaseA();
    }
}

class ClaseQueUsaB extends ClaseQueUsaAoB {

    @Override
    SuperClase obtenerObjeto() {
        return new SubClaseB();
    }
}

public class Main {

    public static void main(String[] args) {
        ClaseQueUsaAoB objetoQueUsaAoB;

        if (new Random().nextBoolean()) {
            objetoQueUsaAoB = new ClaseQueUsaA();
        } else {
            objetoQueUsaAoB = new ClaseQueUsaB();
        }

        objetoQueUsaAoB.obtenerObjeto().metodo();



    }
}
