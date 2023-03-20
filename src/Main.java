import java.util.StringJoiner;

interface Statable {
    int obtenirVida();
    int obtenirPoder();
}

interface Atacable {
    void rebreAtac(Atacador atacador);
    int obtenirVida();
}

interface Atacador {
    void atacar(Atacable atacable);
    int obtenirPoder();
}

interface AtacadorAtacable extends Atacable, Atacador {}

class Player implements AtacadorAtacable {
    int poder = 10;
    int vida = 10;

    @Override
    public void atacar(Atacable atacable) {
        poder--;
        atacable.rebreAtac(this);
    }

    @Override
    public int obtenirPoder() {
        return poder;
    }

    @Override
    public void rebreAtac(Atacador atacador) {
        this.poder -= atacador.obtenirPoder();
        if (poder < 0) {
            vida += poder;
            poder = 0;
        }
    }

    @Override
    public int obtenirVida() {
        return vida;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]").add("poder=" + poder).add("vida=" + vida).toString();
    }
}

class Enemic1 implements AtacadorAtacable {
    int vida = 10;
    int poder = 10;

    @Override
    public void rebreAtac(Atacador atacador) {
        this.vida -= atacador.obtenirPoder();
        this.poder += atacador.obtenirPoder();
    }

    @Override
    public int obtenirVida() {
        return vida;
    }

    @Override
    public void atacar(Atacable atacable) {
        this.poder--;
        atacable.rebreAtac(this);
    }

    @Override
    public int obtenirPoder() {
        return poder;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Enemic1.class.getSimpleName() + "[", "]").add("vida=" + vida).add("poder=" + poder).toString();
    }
}

class Enemic2 implements Atacable {
    int vida = 10;

    @Override
    public void rebreAtac(Atacador atacador) {
        this.vida -= atacador.obtenirPoder();
    }

    @Override
    public int obtenirVida() {
        return vida;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Enemic2.class.getSimpleName() + "[", "]").add("vida=" + vida).toString();
    }
}

class Enemic3 implements Atacador {
    @Override
    public void atacar(Atacable atacable) {
        atacable.rebreAtac(this);
    }

    @Override
    public int obtenirPoder() {
        return 1;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Enemic3.class.getSimpleName() + "[", "]").toString();
    }
}

class Stats {
    static void print(AtacadorAtacable atacadorAtacable) {
        System.out.println(atacadorAtacable.getClass().getSimpleName());
        print((Atacable) atacadorAtacable);
        print((Atacador) atacadorAtacable);
    }

    static void print(Atacador atacador) {
        System.out.println("\uD83D\uDCAA".repeat(atacador.obtenirPoder()));
    }

    static void print(Atacable atacable) {
        System.out.println("❤️".repeat(atacable.obtenirVida()));
    }
}


class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Enemic1 enemic1 = new Enemic1();
        Enemic2 enemic2 = new Enemic2();
        Enemic3 enemic3 = new Enemic3();


        Stats.print(player);

        System.out.println("********** PLAYER ataca a ENEMIC1 ************");
        player.atacar(enemic1);

        Stats.print(player);
        Stats.print(enemic1);


    }
}
