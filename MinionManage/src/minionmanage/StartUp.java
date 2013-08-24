/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author James
 */
public class StartUp {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new MainGame("Simple Slick Game"));
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
                        appgc.setVSync(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
