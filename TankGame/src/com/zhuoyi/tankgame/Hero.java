package com.zhuoyi.tankgame;
/*
    this class is for my own Tank
*/

import java.util.Vector;

public class Hero extends Tank {
    /*
    this class is for my own Tank
     */
    //clear a Shot object
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemy(){
        //we can only have max 5 bullets
        if(shots.size() == 5){
            return;
        }
        //instance shot object to shoot
        switch (getDirection()){
            case 0: //up
                shot = new Shot(getX()+20,getY(),0);
                break;
            case 1: //right
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2: //down
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3: //left
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        shots.add(shot);
        //start the shot thread
        new Thread(shot).start();

    }
}
