package factory.ejemplo3;

import java.util.Random;

abstract class SuperClase {
    abstract void metodo();

    abstract SuperClase obtenerObjeto(String clase);
}

class SubClaseA extends SuperClase {
    @Override
    public void metodo() {
        System.out.println("Soy de clase A");
    }

    @Override
    SuperClase obtenerObjeto(String clase) {
        return new SubClaseA();
    }
}

class SubClaseB extends SuperClase {
    @Override
    public void metodo() {
        System.out.println("Soy de clase B");
    }

    @Override
    SuperClase obtenerObjeto(String clase) {
        return new SubClaseB();
    }
}


public class Main {

    public static void main(String[] args) {
        SuperClase objeto;

        if (new Random().nextBoolean()) {
            objeto = new SubClaseA();
        } else {
            objeto = new SubClaseB();
        }

        objeto.metodo();
    }
}
