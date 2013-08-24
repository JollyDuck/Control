/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

import org.newdawn.slick.Graphics;

/**
 *
 * @author dad
 */
public class MinionManager {

    Minion[] minions = null;

    //TODO: create a clever way to create minions based on their number.
    public MinionManager(Minion[] array) {
        minions = array;
    }

    public void assignWork(int workType) {
        boolean assignedWork = false;
        for (int i = 0; i < minions.length; i++) {
            if (minions[i].workType == 0 && !assignedWork) {
                minions[i].workType = workType;
                minions[i].updatePosition();
                assignedWork = true;
            }
        }
        if (!assignedWork) {
            System.out.println("no work assigned");
        }
    }

    public int howManyWork() {
        int c = 0;
        for (int i = 0; i < minions.length; i++) {
            if (minions[i].workType != 0) {
                c++;
            }
        }
        return c;
    }

    public void updateMinions(float delta) {
        for (int i = 0; i < minions.length; i++) {
            minions[i].update(delta);
        }
    }

    public void drawMinions(Graphics g) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < minions.length; i++) {
            switch (Integer.parseInt(Float.toString(minions[i].position.x))) {
                case 0:
                    a++;
                    break;
                case 1:
                    b++;
                    break;
                default:
                    c++;
                    break;
            }
            g.drawString(Integer.toString(b), 50, 50);
            g.drawString(Integer.toString(a), 150, 50);
            g.drawString(Integer.toString(c), 250, 50);
            g.drawString("Oli Paintball", 200, 250);
        }
    }
}