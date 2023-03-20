package singleton.gamemanager;

class GameManager {
    private static GameManager instance;
    private int score;
    private int level;
    private boolean isSoundOn;

    private GameManager() {
        score = 0;
        level = 1;
        isSoundOn = true;
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public synchronized void incrementScore(int points) {
        score += points;
    }

    public synchronized void advanceLevel() {
        level++;
    }

    public synchronized int getScore() {
        return score;
    }

    public synchronized int getLevel() {
        return level;
    }

    public synchronized boolean isSoundOn() {
        return isSoundOn;
    }

    public synchronized void setSoundOn(boolean isSoundOn) {
        this.isSoundOn = isSoundOn;
    }

    public synchronized void saveGame() {
        // write game state to file or database
    }

    public synchronized void loadGame() {
        // read game state from file or database
    }

    public synchronized void startGame() {
        // start the game
    }

    public synchronized void stopGame() {
        // stop the game
    }
}

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.getInstance();
        gameManager.startGame();

        // game loop
        while (true) {
            // update game state
            gameManager.incrementScore(10);
            if (gameManager.getScore() >= 100) {
                gameManager.advanceLevel();
            }
            if (gameManager.getScore() < 0) break;
        }

        gameManager.saveGame();
        gameManager.stopGame();
    }
}
