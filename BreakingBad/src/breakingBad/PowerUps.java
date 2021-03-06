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
public class PowerUps extends Item{
    private int width;
    private int height;
    private int speed;
    private int direction;
    private int type;
    private Game game;
    private Animation animateFlasks;
    private boolean destroyed;
    
    /**
     * to create direction, width, height, type, speed, animation, and game and set the power ups are not moving
     * @param x
     * @param y
     * @param width
     * @param height
     * @param speed
     * @param direction
     * @param type
     * @param game 
     */
    public PowerUps (int x, int y, int width, int height, int speed ,int direction, int type, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
        this.type = type;
        this.game = game;
        this.animateFlasks = new Animation(Assets.flasks,100);
        this.destroyed = false;
    }

    /**
     * To get the width of the power up
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the power up
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * To get the speed of the power up
     * @return an <code>int</code> value with the speed
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * To get the direction of the power up
     * @return an <code>int</code> value with the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * To get the direction of the power up
     * @return an <code>int</code> value with the direction
     */
    public int getType() {
        return type;
    }
     
    /**
     * To know if the power up has been destroyed
     * @return an <code>boolean</code> value of the state of the power up
     */
    public boolean isDestroyed() {
        return destroyed;
    }

   /**
     * To set the width of the power up
     * @param width to set the width of the power up
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * To set the height of the power up
     * @param height to set the height of the power up
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * To set the speed of the power up
     * @param speed to set the speed of the power up
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * To set the direction of the power up
     * @param direction to set the direction of the power up
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    /**
     * To set the type of power up
     * @param type to set the type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * To know if the power up has been destroyed
     * @param destroyed to set destroyed
     */
    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

       /**
     * To get a rectangle with the position, width, and height of the power up
     * @return an <code>Rectangle</code> rectangle with the given position, width, and height
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    // Carga la información del objeto desde un string
    /**
     * To set the value of the position in the x axis and the direction of the power up from the file that was loaded
     * @param datos to set all the variables
     */
   
    public void loadFromString(String[] datos){
        this.x = Integer.parseInt(datos[0]);
        this.direction = Integer.parseInt(datos[1]);
        this.destroyed = (Integer.parseInt(datos[2]) == 1 ? true : false);
    }
    
    /**
     * To get all the variable that need to be stored in the file as a string
     * @return an <code>String</code> value with all the information of the variables
     */
    
    public String toString(){
        return (x+" "+direction + " " + (destroyed ? "1" : "0"));
    }
    
    
    @Override
    public void tick() {
        // updates the position of the power ups
        setX(getX() + getSpeed() * getDirection());
        
        //animates the flask
        this.animateFlasks.tick();
        
        // checks that the object does not goes out of the bounds
        if (getX() + getWidth() >= game.getWidth()) {
                setDirection(-1);
            }
            else if (getX() <= 0) {
                setDirection(1);
            }
    }

    @Override
    public void render(Graphics g) {
        // checks which type of power up it is to know which asset to draw
        if (type == 1) {
            g.drawImage(animateFlasks.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.drawImage(Assets.pollos, getX(), getY(), getWidth(), getHeight(), null);
        }
        
    }
    
}
