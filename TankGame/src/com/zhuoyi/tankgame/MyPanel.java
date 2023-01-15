package com.zhuoyi.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/*
    this class is for drawing the panel
 */


public class MyPanel extends JPanel implements KeyListener,Runnable {
    //create my own Tank
    Hero hero = null;
    //define enemy Tank
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //we use 3 image for showing the explosion of the tank
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel(){
        hero = new Hero(500,500);
        //initialize enemy tanks
        for(int i = 0; i< enemyTankSize; i++){
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setDirection(2);
            //start the thread to make the enemyTank move
            new Thread(enemyTank).start();
            //give a bullet to an enemyTank
            //Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            //put this bullet into the enemyTanks Vector for managing
            //enemyTank.shots.add(shot);
            //start shot object
            //new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        //initialize the 3 images
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));
    }
    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("Number of tanks destroyed",1020,30);
        drawTank(1020,60,g,0,0);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNum() + "",1080,100);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        showInfo(g);

        //draw hero Tank
        if(hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        }

        //draw Hero's bullet
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if(shot != null && shot.isLive == true){
                //g.fill3DRect(hero.shot.x, hero.shot.y,1,1,false);
                g.draw3DRect(shot.x, shot.y,2,2,false);
            } else{ //if this shot is invalid, then remove it from the vector
                hero.shots.remove(shot);
            }
        }


        //draw bombs if there is one in the Vector
        for(int i = 0; i < bombs.size();i++){
            Bomb bomb = bombs.get(i);
            //according to the life of Bomb to draw the images
            if(bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            }else{
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            //if bomb's life equals to 0, them remove it from the vector
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }



        //draw enemyTank
        for(int i = 0; i< enemyTanks.size(); i++) {
            //get instance of enemyTank
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) { //draw the tank only if the tank is alive
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
                //draw all enemyTank's bullets
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //get that bullet
                    Shot shot = enemyTank.shots.get(j);
                    //paint it
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        //this bullet is died, we remove that bullet
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    //drawTank - used to draw the tank

    /**
     *
     * @param x x-axis coordinates
     * @param y y-axis coordinates
     * @param g paint
     * @param direction tank's direction
     * @param type type of tank
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type){
        switch (type){
            case 0: //our tank
                g.setColor(Color.cyan);
                break;
            case 1: //enemy tank
                g.setColor(Color.yellow);
                break;
        }
        //based on direction, we draw the tank
        // 0 - UP
        // 1 - RIGHT
        // 2 - DOWN
        // 3 - LEFT
        switch(direction){
            case 0: // 0 - tanks aims to UP
                g.fill3DRect(x,y,10,60,false);//draw left-size wheel
                g.fill3DRect(x+30,y,10,60,false);//draw right-size wheel
                g.fill3DRect(x+10,y+10,20,40,false);//draw tank center
                g.fillOval(x+10,y+20,20,20);//draw circle cover
                g.drawLine(x+20,y+30,x+20,y);//draw barrel
                break;
            case 1:// 1 - tanks aims to RIGHT
                g.fill3DRect(x,y,60,10,false);//draw left-size wheel
                g.fill3DRect(x,y+30,60,10,false);//draw right-size wheel
                g.fill3DRect(x+10,y+10,40,20,false);//draw tank center
                g.fillOval(x+20,y+10,20,20);//draw circle cover
                g.drawLine(x+30,y+20,x+60,y+20);//draw barrel
                break;
            case 2:
                g.fill3DRect(x,y,10,60,false);//draw left-size wheel
                g.fill3DRect(x+30,y,10,60,false);//draw right-size wheel
                g.fill3DRect(x+10,y+10,20,40,false);//draw tank center
                g.fillOval(x+10,y+20,20,20);//draw circle cover
                g.drawLine(x+20,y+30,x+20,y+60);//draw barrel
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);//draw left-size wheel
                g.fill3DRect(x,y+30,60,10,false);//draw right-size wheel
                g.fill3DRect(x+10,y+10,40,20,false);//draw tank center
                g.fillOval(x+20,y+10,20,20);//draw circle cover
                g.drawLine(x+30,y+20,x,y+20);//draw barrel
                break;

            default:
                System.out.println("not done yet");

        }

    }

    //method to check if the bullet hit the enemy's tank
    public void hitEnemyTank(Shot s, EnemyTank enemyTank){
        //check if hit
        switch (enemyTank.getDirection()){
            case 0: //up
            case 2: //down
               if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 &&
                  s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60){
                   s.isLive = false;
                   enemyTank.isLive = false;
                   //remove the enemyTank from the vector when it is hit
                   enemyTanks.remove(enemyTank);
                   Recorder.addAllEnemyTankNum();
                   //instance Bomb object, add to Vector
                   Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                   bombs.add(bomb);
               }
               break;
            case 1: //right
            case 3: //left
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 &&
                        s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //remove the enemyTank from the vector when it is hit
                    enemyTanks.remove(enemyTank);
                    Recorder.addAllEnemyTankNum();
                    //instance Bomb object, add to Vector
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }

    }
    public void hitHero(){ //check if our tank be hit
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot s = enemyTank.shots.get(j);
                //check if hit
                if(hero.isLive && s.isLive){
                    switch (hero.getDirection()){
                        case 0: //up
                        case 2: //down
                            if(s.x > hero.getX() && s.x < hero.getX() + 40 &&
                                    s.y > hero.getY() && s.y < hero.getY() + 60){
                                s.isLive = false;
                                hero.isLive = false;
                                //instance Bomb object, add to Vector
                                Bomb bomb = new Bomb(hero.getX(),hero.getY());
                                bombs.add(bomb);
                            }
                            break;
                        case 1: //right
                        case 3: //left
                            if(s.x > hero.getX() && s.x < hero.getX() + 60 &&
                                    s.y > hero.getY() && s.y < hero.getY() + 40){
                                s.isLive = false;
                                hero.isLive = false;
                                //instance Bomb object, add to Vector
                                Bomb bomb = new Bomb(hero.getX(),hero.getY());
                                bombs.add(bomb);
                            }
                            break;
                    }

                }
                
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //deal with w a s d key press to let tank move
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){ //press W
            //change the direction of  the tank to Up
            hero.setDirection(0);
            //move Up
            hero.moveUp(0);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //change the direction of  the tank to Right
            hero.setDirection(1);
            //move Right
            hero.moveRight(0);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //change the direction of  the tank to Down
            hero.setDirection(2);
            //move Down
            hero.moveDown(0);
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            //change the direction of  the tank to Left
            hero.setDirection(3);
            //move Left
            hero.moveLeft(0);
        }
        //Player press 'J' to shoot
        if(e.getKeyCode() == KeyEvent.VK_J){
            System.out.println("player press 'J");
            hero.shotEnemy();

        }
        //redraw the panel
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //every 100 ms, repaint the panel
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //check if bullet hit enemyTank
            for (int i = 0; i < hero.shots.size(); i++) {
                Shot shot = hero.shots.get(i);
                if (shot != null && shot.isLive) {
                    for (int j = 0; j < enemyTanks.size(); j++) {
                        EnemyTank enemyTank = enemyTanks.get(j);
                        hitEnemyTank(shot, enemyTank);
                    }
                }
            }
            //check if enemy tank hit hero
            hitHero();

            this.repaint();
        }
    }
}
