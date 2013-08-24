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
        workingForThisLong = 0f;
    }

    public void update(float delta) {
        workingForThisLong += delta;
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
