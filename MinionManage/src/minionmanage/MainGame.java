package minionmanage;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MainGame extends BasicGame {

    MinionManager minionManager;
    WorkManager workManager; //can work manager be integrated into minionManager?

    public MainGame(String gamename) {
        super(gamename);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        Minion[] setup = {new Minion(), new Minion(), new Minion()};
        minionManager = new MinionManager(setup);
        workManager = new WorkManager();
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_1)) {
            minionManager.assignWork(1, workManager);
        }
        else if (input.isKeyPressed(Input.KEY_2)){
            minionManager.assignWork(2, workManager);
        }

        minionManager.updateMinions(i, workManager);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.drawRect(50, 50, 50, 50);
        g.drawRect(150, 50, 50, 50);
        g.drawRect(250, 50, 50, 50);
        minionManager.drawMinions(g);
        codingDraw(g);

    }

    public void codingDraw(Graphics g) {
        g.drawString("Minions working: " + Integer.toString(minionManager.howManyWork()), 10, 200);
        g.drawString("Missile Count: " + Integer.toString(workManager.missileCount), 10, 214);
        g.drawString("Missiles Loaded: " + Integer.toString(workManager.missilesLoaded), 10, 228);
        g.drawString("Missiles Fired: " + Integer.toString(workManager.missilesFired), 10, 242);

    }
}