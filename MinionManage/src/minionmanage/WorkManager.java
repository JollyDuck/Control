/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

/**
 * Looks after all of the variables for the work assigned in the station.
 *
 * @author dad
 */
public class WorkManager {

    int missileCount;
    int missilesLoaded;
    int missilesFired; // for Highscores
    //TODO: Have an array called missiles that holds all missile data?
    int[] timeForEachTask;

    public WorkManager() {
        missileCount = 5;
        missilesLoaded = 0;
        timeForEachTask = new int[]{0, 5, 3};
    }

    /**
     * Checks to see if the work assigned is possible to do
     *
     * @param workType
     * @param minion
     * @return
     */
    public boolean assignWork(int workType, Minion minion) {
        switch (workType) {
            case 1:
                if (missileCount > 0) {
                    missileCount--;
                    minion.workType = workType;
                    minion.updatePosition();
                    return true;
                }
                break;
            case 2:
                if (missilesLoaded >= 1) {
                    missilesLoaded--;
                    minion.workType = workType;
                    minion.updatePosition();
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * Returns the time required to complete the work of type workType.
     *
     * @param workType
     * @return float of time based on the workType.
     */
    public float workLength(int workType) {
        return timeForEachTask[workType];
    }

    /**
     * Updates variables stored in workManager with the completed work.
     *
     * @param workType
     */
    public void workComplete(int workType) {
        switch (workType) {
            case 1:
                missilesLoaded++;
                break;
            case 2:
                missilesFired++;
                break;
        }
    }
}
