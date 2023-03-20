package observer.guessevent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Game {
    interface OnWinListener {
        void onWin(int numIntents);
    }

    List<OnWinListener> onWinListeners = new ArrayList<>();

    void start(){
        int guess = ThreadLocalRandom.current().nextInt(10);
        Scanner scanner = new Scanner(System.in);
        int tries = 1;
        while(true) {
            int num = scanner.nextInt();
            if (num == guess) break;
            tries++;
        }

        for (OnWinListener onWinListener : onWinListeners)
            onWinListener.onWin(tries);
    }

    void addOnWinListener(OnWinListener onWinListener) {
        onWinListeners.add(onWinListener);
    }
}

class Confetti implements Game.OnWinListener {

    @Override
    public void onWin(int num) {
        System.out.println("\uD83C\uDF89");
    }
}

class ScoreSaver implements Game.OnWinListener {

    @Override
    public void onWin(int numIntents) {
        try { Files.writeString(Path.of("scores.txt"), "intentos:" + numIntents); } catch (IOException ignored) {}
    }
}

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        Confetti confetti = new Confetti();
        ScoreSaver scoreSaver = new ScoreSaver();

        game.addOnWinListener(confetti);
        game.addOnWinListener(scoreSaver);

        game.start();
    }
}
