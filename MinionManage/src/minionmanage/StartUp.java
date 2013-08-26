/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

import java.awt.DisplayMode;
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

    //TODO: show resolution setup.
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;

    public StartUp(String s) {
        super(s);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new StartUp("Simple Slick Game"));
            appgc.setDisplayMode(WIDTH, HEIGHT, true);
            appgc.setVSync(true);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(WeaponsState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new MainMenu(1));
        this.addState(new WeaponsState(10));
    }
}
