package minionmanage;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MainGame extends BasicGame {

    MinionManager minionManager;

    public MainGame(String gamename) {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        Minion[] setup = {new Minion(), new Minion(), new Minion()};
        minionManager = new MinionManager(setup);
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_1)) {
            minionManager.assignWork(1);
        }

        minionManager.updateMinions(i);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawString("Howdy!", 110, 110);
        g.drawRect(50, 50, 50, 50);
        g.drawRect(150, 50, 50, 50);
        g.drawRect(250, 50, 50, 50);
        g.drawString(Integer.toString(minionManager.howManyWork()), 200, 200);
        minionManager.drawMinions(g);
    }
}