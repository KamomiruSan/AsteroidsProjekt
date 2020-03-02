package com.company.game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;


public class HUD extends Obj {
    
    private Font font = new Font("Arial", Font.PLAIN, 30);
    private Font font2 = new Font("Arial", Font.PLAIN, 20);

    private String startText = "Pro hru zmáčkni space";
    private String gameOverText = "GAME OVER";
    
    private boolean titleState;
    private boolean gameOverState;
    private boolean allShotsDestroyed;
    
    private long gameOverStartTime;
    
    public HUD(AsteroidsGame game) {
        super(game);
        createShipShape();
    }

    private void createShipShape() {
        Polygon shipShape = new Polygon();
        shipShape.addPoint(0, -10);
        shipShape.addPoint(5, 10);
        shipShape.addPoint(-5, 10);
        shape = shipShape;
    }

    @Override
    public void updateTitle() {
        if (Keyboard.keyDown[KeyEvent.VK_SPACE]) {
            game.start();
        }
    }

    @Override
    public void updateGameOver() {
        allShotsDestroyed = game.checkAllObjectsDestroyed(Shot.class);
        if (!allShotsDestroyed) {
            gameOverStartTime = System.currentTimeMillis();
            return;
        }
        
        long gameOverTime = System.currentTimeMillis() - gameOverStartTime;
        if (gameOverTime > 10000) {
            game.updateHiscore();
            game.backToTitle();
        }
    }
    
    @Override
    public void draw(Graphics2D g) {
        AffineTransform at = g.getTransform();
        g.setColor(Color.WHITE);

        g.setFont(font);
        g.drawString("" + game.getScore(), 15, 35);


        if (gameOverState && allShotsDestroyed) {
            int gameOverWidth = g.getFontMetrics().stringWidth(gameOverText);
            int gameOverX = (game.getWidth() - gameOverWidth) / 2;
            g.drawString(gameOverText, gameOverX, game.getHeight() / 2);
        }


        g.setFont(font2);
        int hiscoreWidth = g.getFontMetrics().stringWidth("" + game.getHiscore());
        int hiscoreX = (game.getWidth() - hiscoreWidth) / 2;
        g.drawString("" + game.getHiscore(), hiscoreX, 30);


        if (titleState && (System.currentTimeMillis() / 300) % 2 == 0) {
            int startWidth = g.getFontMetrics().stringWidth(startText);
            int startX = (game.getWidth() - startWidth) / 2;
            g.drawString(startText, startX, game.getHeight() / 2);
        }


        g.translate(20, 60);
        for (int l = 0; l < game.getLives(); l++) {
            g.draw(shape);
            g.translate(10, 00);
        }
        
        g.setTransform(at);
    }

    public void StateChanged(AsteroidsGame.State newState) {
        titleState = newState == AsteroidsGame.State.TITLE;
        gameOverState = newState == AsteroidsGame.State.GAME_OVER;
        if (gameOverState) {
            gameOverStartTime = System.currentTimeMillis();
            allShotsDestroyed = false;
        }
    }
    
}
