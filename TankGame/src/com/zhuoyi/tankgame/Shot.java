package com.zhuoyi.tankgame;

public class Shot implements Runnable{

    /*
    this class is used for draw the bullets,for each bullet, we create a thread.
     */

    int x; // x coordinate of bullet
    int y; // y coordinate of bullet
    int direction = 0; // direction of bullet
    int speed = 8; // speed of bullet
    boolean isLive = true;

    //constructor
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direction = direct;
    }

    @Override
    public void run() { //shoot action
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //according to the direction to shoot
            switch(direction){
                case 0: //Up
                    y -= speed;
                    break;
                case 1: //Right
                    x += speed;
                    break;
                case 2: //Down
                    y += speed;
                    break;
                case 3: //Left
                    x -= speed;
                    break;
            }
            //test
            System.out.println("x: " + x + " y: " + y);
            //bullet out of the screen, bullet ends
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <=750 && isLive)){
                isLive = false;
                System.out.println("bullet ends");
                break;
            }
            //if bullet hit enemy tank, end it

        }

    }
}
