package factory.ejemplo2;

import java.util.Random;

abstract class SuperClase {
    abstract void metodo();

    static SuperClase obtenerObjeto(String clase) {
        switch (clase) {
            case "claseA":
                return new SubClaseA();
            case "claseB":
                return new SubClaseB();
        }
        return null; // better return something...
    }
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


public class Main {

    public static void main(String[] args) {
        SuperClase objeto;

        if (new Random().nextBoolean()) {
            objeto = SuperClase.obtenerObjeto("claseA");
        } else {
            objeto = SuperClase.obtenerObjeto("claseB");
        }

        objeto.metodo();
    }
}
