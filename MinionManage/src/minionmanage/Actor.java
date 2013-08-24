/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minionmanage;

import org.lwjgl.util.vector.Vector2f;

/**
 *
 * @author James
 */
public abstract class Actor {

    Vector2f position;

    public void initiate() {
        position = new Vector2f();
        position.x = 1;
    }
    //public abstract void method(Image myImage, Vector2f myVector);
}