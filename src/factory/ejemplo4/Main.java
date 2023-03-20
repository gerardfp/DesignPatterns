package factory.ejemplo4;

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

abstract class AbstractFactory {
    abstract SuperClase obtenerObjeto();
}

class FactoryA extends AbstractFactory {

    @Override
    SuperClase obtenerObjeto() {
        return new SubClaseA();
    }
}

class FactoryB extends AbstractFactory {

    @Override
    SuperClase obtenerObjeto() {
        return new SubClaseB();
    }
}

class ClaseQueUsaAoB {
    static SuperClase obtenerObjeto(AbstractFactory abstractFactory){
        return abstractFactory.obtenerObjeto();
    }
}

public class Main {

    public static void main(String[] args) {
        AbstractFactory abstractFactory;

        if (new Random().nextBoolean()) {
            abstractFactory = new FactoryA();
        } else {
            abstractFactory = new FactoryB();
        }

        SuperClase objeto = ClaseQueUsaAoB.obtenerObjeto(abstractFactory);
        objeto.metodo();
    }
}
