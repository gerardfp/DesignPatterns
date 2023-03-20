package factory.ejemplo1;

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

class Factory {
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

public class Main {

    public static void main(String[] args) {
        SuperClase objeto;

        if (new Random().nextBoolean()) {
            objeto = Factory.obtenerObjeto("claseA");
        } else {
            objeto = Factory.obtenerObjeto("claseB");
        }

        objeto.metodo();
    }
}
