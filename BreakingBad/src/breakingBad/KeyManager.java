/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakingBad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author antoniomejorado
 */
public class KeyManager implements KeyListener {

    public boolean left;    // flag to move left the player
    public boolean right;   // flag to move right the player
    public boolean pause;   // flag to pause the game
    public boolean save;    // flag to save the game
    public boolean load;    // flag to load the game
    public boolean restart;     // flag to restart the game
    public boolean lastPause;   // flag to know the state of the pause on the previous tick
    public boolean lastSave;    // flag to know the state of the save on the previous tick
    public boolean lastLoad;    // flag to know the state of the load on the previous tick
    public boolean lastRestart; // flag to know the state of the restart on the previous tick
    public boolean moveBall;    // flag to move the ball
    
    private boolean keys[];  // to store all the flags for every key
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        keys[e.getKeyCode()] = false;
    }
    
    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        /**
         * checks if in the last tick the keys 'p', 'g', 'c', and 'r' were pressed and if in the current tick they were released
         * if this is true the corresponding flag of the key is true, else it is false
         */
        if (lastPause && !keys[KeyEvent.VK_P]) {
            pause = true;
        } else {
            pause = false;
        }
        
        if (lastSave && !keys[KeyEvent.VK_G]) {
            save = true;
        } else {
            save = false;
        }
        
        if (lastLoad  && !keys[KeyEvent.VK_C]) {
            load = true;
        } else {
            load = false;
        }
        
        if (lastRestart  && !keys[KeyEvent.VK_R]) {
            restart = true;
        } else {
            restart = false;
        }
        
        lastPause = keys[KeyEvent.VK_P];
        lastSave = keys[KeyEvent.VK_G];
        lastLoad  = keys[KeyEvent.VK_C];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        lastRestart = keys[KeyEvent.VK_R];
        moveBall = keys[KeyEvent.VK_SPACE];
    }
}
