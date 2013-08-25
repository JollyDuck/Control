package minionmanage;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class WeaponsState extends BasicGameState {

    MinionManager minionManager;
    WorkManager workManager; //can work manager be integrated into minionManager?
    int stateID = 0;

    @Override
    public int getID() {
        return stateID;
    }

    public WeaponsState(int it) {
        stateID = it;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Minion[] setup = {new Minion(), new Minion(), new Minion()};
        minionManager = new MinionManager(setup);
        workManager = new WorkManager();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawRect(50, 50, 50, 50);
        g.drawRect(150, 50, 50, 50);
        g.drawRect(250, 50, 50, 50);
        minionManager.drawMinions(g);
        codingDraw(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyPressed(Input.KEY_1)) {
            minionManager.assignWork(1, workManager);
        } else if (input.isKeyPressed(Input.KEY_2)) {
            minionManager.assignWork(2, workManager);
        }
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            gc.exit();
        }

        minionManager.updateMinions(i, workManager);
    }

    public void codingDraw(Graphics g) {
        g.drawString("Minions working: " + Integer.toString(minionManager.howManyWork()), 10, 200);
        g.drawString("Missile Count: " + Integer.toString(workManager.missileCount), 10, 214);
        g.drawString("Missiles Loaded: " + Integer.toString(workManager.missilesLoaded), 10, 228);
        g.drawString("Missiles Fired: " + Integer.toString(workManager.missilesFired), 10, 242);

    }
}