package com.zhuoyi.tankgame;

import java.util.Vector;

/*
 this class is for enemy tank
 */
public class EnemyTank extends Tank implements Runnable {
    //Use Vector to create multiple Shot for enemyTank
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    //enemyTanks vector is used for check if two tanks are overlapped
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public boolean isTouchEnemyTank() {
        switch (this.getDirection()) { //get current tank's direction
            case 0: //up
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //skip myself
                    // enemyTank is up and down
                    if (enemyTank != this) {
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }

                        }
                    }

                }
                break;
            case 1://right
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //skip myself
                    // enemyTank is up and down
                    if (enemyTank != this) {
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }

                        }
                    }

                }
                break;
            case 2://down
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //skip myself
                    // enemyTank is up and down
                    if (enemyTank != this) {
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }

                        }
                    }

                }
                break;
            case 3://left
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //skip myself
                    // enemyTank is up and down
                    if (enemyTank != this) {
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }

                        }
                    }

                }
                break;
        }
        return false;
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //check if the bullet of enemy tank has died, if yes, then reload
            if (isLive && shots.size() < 10) {
                Shot s = null;
                int flag = (int) (Math.random() * 100);
                if (flag <= 100) {
                    System.out.println("flag: = " + flag);
                    switch (getDirection()) {
                        case 0:
                            s = new Shot(getX() + 20, getY(), 0);
                            break;
                        case 1:
                            s = new Shot(getX() + 60, getY() + 20, 1);
                            break;
                        case 2:
                            s = new Shot(getX() + 20, getY() + 60, 2);
                            break;
                        case 3:
                            s = new Shot(getX(), getY() + 20, 3);
                            break;
                    }
                    shots.add(s);
                    new Thread(s).start();
                }

            }

            //move according the current direction
            switch (getDirection()) {
                case 0: //up
                    for (int i = 0; i < 30; i++) {
                        if(!isTouchEnemyTank()) {
                            moveUp(1);
                        }

                        //sleep 50 ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    break;
                case 1: //right
                    for (int i = 0; i < 30; i++) {
                        if(!isTouchEnemyTank()) {
                            moveRight(1);
                        }

                        //sleep 50 ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    break;
                case 2: //down
                    for (int i = 0; i < 30; i++) {
                        if(!isTouchEnemyTank()) {
                            moveDown(1);
                        }

                        //sleep 50 ms
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3: //left
                    for (int i = 0; i < 30; i++) {
                        if(!isTouchEnemyTank()) {
                            moveLeft(1);
                        }
                        //sleep 50 ms

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    break;
            }


            //randomly change the direction
            //random [0 - 1) -> Math.random()*4 = [0,4)
            setDirection((int) (Math.random() * 4));

            //exit
            if (!isLive) {
                break;
            }
        }
    }
}
