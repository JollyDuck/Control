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
    int workType;
    float workingForThisLong;

    public Minion() {
        workType = 0;
        workingForThisLong = 0;
        initiate(); // from Actor
    }

    public void update(float delta) {
        if (workType != 0) {
            workingForThisLong += delta;
        }
        if ((int) workingForThisLong >= 5) {
            workType = 0;
            workingForThisLong=0;
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
