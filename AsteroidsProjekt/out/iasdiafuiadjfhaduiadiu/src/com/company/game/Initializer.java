package com.company.game;


import com.company.game.AsteroidsGame;
import com.company.game.Obj;

public class Initializer extends Obj {
    
    private long startTime;
    
    public Initializer(AsteroidsGame game) {
        super(game);
        startTime = System.currentTimeMillis();
    }

    @Override
    public void updateInitializing() {
        if (System.currentTimeMillis() - startTime > 100) {
            game.setState(AsteroidsGame.State.TITLE);
        }
    }
    
}
