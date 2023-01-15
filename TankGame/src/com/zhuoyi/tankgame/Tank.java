package com.zhuoyi.tankgame;

public class Tank {
    private int x; //Tank's x-axis coordinates
    private int y; //Tank's y-axis coordinates
    private int direction; //Tank's direction
    private int speed = 5;
    private int heroSpeed = 10;

    boolean isLive = true;

    //method for moving the tank Up Right Down Left
    public void moveUp(int tankNum){ //hero: tankNum 0    enemyTank: tankNum 1
        if(tankNum == 1) {
            if (getY() > 0) {
                y -= speed;
            }
        }else{
            if (getY() > 0) {
                y -= heroSpeed;
            }
        }
    }
    public void moveRight(int tankNum){

        if(tankNum == 1) {
            if(getX() + 60 < 1000) {
                x += speed;
            }
        }else{
            if(getX() + 60 < 1000) {
                x += heroSpeed;
            }
        }
    }
    public void moveDown(int tankNum){

        if(tankNum == 1) {
            if (getY() + 60 < 750) {
                y += speed;
            }
        }else{
            if (getY() + 60 < 750) {
                y += heroSpeed;
            }
        }
    }
    public void moveLeft(int tankNum){
        if(tankNum == 1) {
            if (getX() > 0) {
                x -= speed;
            }
        }else{
            if (getX() > 0) {
                x -= heroSpeed;
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
