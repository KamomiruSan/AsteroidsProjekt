package com.company.main;

        import com.company.game.AsteroidsGame;
        import com.company.game.Display;

public class Main {

    public static void main(String[] args) {
        AsteroidsGame asteroidsGame = new AsteroidsGame();
        Display display = new Display(asteroidsGame);
        display.start();
    }

}
