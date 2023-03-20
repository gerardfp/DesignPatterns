package singleton.gamemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

class GameManagerNoSync {
    private static GameManagerNoSync instance;
    private int score;

    private GameManagerNoSync() {
        score = 0;
    }

    public static GameManagerNoSync getInstance() {
        if (instance == null) {
            instance = new GameManagerNoSync();
        }
        return instance;
    }

    public void incrementScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

}

class GamePart implements Callable<Void> {
    @Override
    public Void call() {
        GameManagerNoSync.getInstance().incrementScore(10);
        return null;
    }
}

public class MainNoSync {
    public static void main(String[] args) throws InterruptedException {
        List<GamePart> gameParts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            gameParts.add(new GamePart());
        }

        Executors.newFixedThreadPool(50).invokeAll(gameParts);

        System.out.println(GameManagerNoSync.getInstance().getScore());
    }
}
