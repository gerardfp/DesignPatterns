package observer.ejemplo1;

import java.util.ArrayList;
import java.util.List;

class NotificadorDeEvento {
    interface ObservadorDeEvento {
        void cuandoSucedaElEvento();
    }
    List<ObservadorDeEvento> observadoresDeEvento = new ArrayList<>();

    void suscribirAEvento(ObservadorDeEvento observadorDeEvento) {
        observadoresDeEvento.add(observadorDeEvento);
    }

    void sucederEvento(){
        for (ObservadorDeEvento observadorDeEvento: observadoresDeEvento) {
            observadorDeEvento.cuandoSucedaElEvento();
        }
    }
}

class ObservadorDeEvento1 implements NotificadorDeEvento.ObservadorDeEvento {

    @Override
    public void cuandoSucedaElEvento() {
        System.out.println("Accion 1");
    }
}

class ObservadorDeEvento2 implements NotificadorDeEvento.ObservadorDeEvento {

    @Override
    public void cuandoSucedaElEvento() {
        System.out.println("Accion 2");
    }
}

public class Main {
    public static void main(String[] args) {
        NotificadorDeEvento notificadorDeEvento = new NotificadorDeEvento();

        ObservadorDeEvento1 observadorDeEvento1 = new ObservadorDeEvento1();
        notificadorDeEvento.suscribirAEvento(observadorDeEvento1);

        ObservadorDeEvento2 observadorDeEvento2 = new ObservadorDeEvento2();
        notificadorDeEvento.suscribirAEvento(observadorDeEvento2);

        notificadorDeEvento.sucederEvento();
    }
}
