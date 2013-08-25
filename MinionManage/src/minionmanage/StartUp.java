/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author James
 */
public class StartUp extends StateBasedGame {
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    
    public StartUp(String s) {
        super(s);
    }
    
    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new StartUp("Simple Slick Game"));
            appgc.setDisplayMode(WIDTH, HEIGHT, false);
            appgc.setVSync(true);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new MainGame(1));
    }
}
