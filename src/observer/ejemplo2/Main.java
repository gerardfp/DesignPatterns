package observer.ejemplo2;

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


public class Main {
    public static void main(String[] args) {
        NotificadorDeEvento notificadorDeEvento = new NotificadorDeEvento();

        notificadorDeEvento.suscribirAEvento(new NotificadorDeEvento.ObservadorDeEvento() {
            @Override
            public void cuandoSucedaElEvento() {
                System.out.println("Accion 1");
            }
        });

        notificadorDeEvento.suscribirAEvento(new NotificadorDeEvento.ObservadorDeEvento() {
            @Override
            public void cuandoSucedaElEvento() {
                System.out.println("Accion 2");
            }
        });

        notificadorDeEvento.sucederEvento();
    }
}
