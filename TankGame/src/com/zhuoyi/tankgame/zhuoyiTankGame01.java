package com.zhuoyi.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class zhuoyiTankGame01 extends JFrame {
    //define the panel
    MyPanel mp = null;
    public static void main(String[] args) {
        zhuoyiTankGame01 zhuoyiTankGame01 = new zhuoyiTankGame01();
    }
    public zhuoyiTankGame01(){
        mp = new MyPanel();

        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300,950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //set Listener for close the game
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("hearing the close");
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
