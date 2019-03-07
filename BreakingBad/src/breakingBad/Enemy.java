/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakingBad;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Alberto García Viegas A00822649 | Melba Geraldine Consuelos Fernández A01410921
 */
public class Enemy extends Item {
    
    private int width;                      // to store the width of the bricks
    private int height;                     // to store the height of the bricks
    private Game game;              // to store the game
    private boolean destroyed;     // to store if the brick has been hit
    
    /**
     * to create direction, width, height, directionX, and directionY and set the enemy is not moving
     * @param x to set the x of the enemy
     * @param y to set the y of the enemy
     * @param width to set the width of the enemy
     * @param height  to set the height of the enemy
     * @param game to set the game of the enemy
     */
    public Enemy(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.destroyed = false;
    }


    /**
     * To get the width of the enemy
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the enemy
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * To know if the brick has been hit
     * @return an <code>boolean</code> value of the state of the brick
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * To set the width of the enemy
     * @param width to set the width of the enemy
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * To set the height of the enemy
     * @param height to set the height of the enemy
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * To set if the brick has been hit
     * @param destroyed 
     */
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
    
    // Carga la información del objeto desde un string
    /**
     * To set the value of destroyed from the file that was loaded
     * @param datos to set all the variables
     */
    public void loadFromString(String[] datos){
        this.destroyed = (Integer.parseInt(datos[0]) == 1 ? true : false);
    }
    
    /**
     * To get all the variable that need to be stored in the file as a string
     * @return an <code>String</code> value with all the information of the variables
     */
    public String toString(){
        return ((destroyed ? "1":"0"));
    }
    
    /**
     * To get the rectangle of the brick
     * @return an <code>Rectangle</code> value with the rectangle of the brick
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.brick, getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {
        // this function exists so all abstracts methods from Item are overriden
    }
    
}
