/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakingBad;

import java.awt.image.BufferedImage;

/**
 *
 * @author antoniomejorado
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage paddle;     // to store the player image
    public static BufferedImage pollos;
    public static BufferedImage blueFlask;
    public static BufferedImage blueFlask_left;
    public static BufferedImage blueFlask_right;
    public static BufferedImage ball;
    public static BufferedImage brick;
    //public static SoundClip bomb;           // to store the sound of the bomb
    //to store flask color
    public static BufferedImage flasks[];
// 
    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/desert.jpg");
        paddle = ImageLoader.loadImage("/images/paddle.png");
        pollos = ImageLoader.loadImage("/images/breakingbad-lospolloshermanosrug.png");
        blueFlask = ImageLoader.loadImage("/images/blueflask.png");
        blueFlask_left = ImageLoader.loadImage("/images/blueflask_left.png");
        blueFlask_right = ImageLoader.loadImage("/images/blueflask_right.png");
        ball = ImageLoader.loadImage("/images/ball.png");
        brick = ImageLoader.loadImage("/images/brick.png");
        //bomb = new SoundClip("/images/mono.wav");
<<<<<<< HEAD
        colorF = ImageLoader.loadImage("/images/flask_spritesheet.jpg");
        
        //creating array of images
//        SpreadSheet spritesheet = new SpreadSheet(colorF);
//        colors = new BufferedImage[9];
        
        //cropping pictures from the sheet into the array
//        for(int i = 0; i < 9; i++){
//            colors[i] = spritesheet.crop(i*64, 0, 64, 64);
//        }
//        SpreadSheet spritesheet = new SpreadSheet(colorF);
//        colors = new BufferedImage[3];
=======
        flasks = new BufferedImage[3];
        
        for(int i = 0; i < 3; i++){
            flasks[0] = blueFlask;
            flasks[1] = blueFlask_left;
            flasks[2] = blueFlask_right;
        }
        
        
>>>>>>> 0e369e62f37317538b515bdff4c79e35631595b8
    }
    
}


