package builder.ejemplo1;

class Algo {
    String esto;
    String otro;
    int aquello;

    static class Builder {
        String esto;
        String otro;
        int aquello;

        Builder setEsto(String esto) {
            this.esto = esto;
            return this;
        }

        Builder setOtro(String otro) {
            this.otro = otro;
            return this;
        }

        Builder setAquello(int aquello) {
            this.aquello = aquello;
            return this;
        }

        Algo build(){
            Algo algo = new Algo();
            algo.esto = this.esto;
            algo.otro = this.otro;
            algo.aquello = this.aquello;
            return algo;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Algo algo = new Algo.Builder()
                .setEsto("valorParaEsto")
                .setAquello(123241)
                .setOtro("valorParaOtro")
                .build();
    }
}
