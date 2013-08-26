/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

/**
 *
 * @author James
 */
public class Minion extends Actor {

    //Work type = 0 == idle.
    //Work type = 1 == Missile
    //Work type = 2 == Fire Missile
    //Work type = 10 = Missile transition
    int workType;
    float workingForThisLong;

    public Minion() {
        workType = 0;
        workingForThisLong = 0;
        initiate(); // from Actor
    }

    public void update(float delta, WorkManager wMan) {
        workingForThisLong += delta;
        if ((int) workingForThisLong >= (int)wMan.workLength(workType)) {
            wMan.workComplete(workType);
            workType = 0;
            workingForThisLong = 0;
        }
        updatePosition();
    }

    public void updatePosition() {
        switch (workType) {
            default:
                position.x = 1;
                break;
            case 1:
                position.x = 0;
                break;
            case 2:
                position.x = 2;
                break;
        }
    }
}
