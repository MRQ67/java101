package com.qadi;

import jaco.mp3.player.MP3Player;
import java.io.File;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.print("Enter the time in seconds: ");
        Scanner input = new Scanner(System.in);
        int inputTime = input.nextInt();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Times up!");
                playSound("D:\\IntelliJ_Projects\\java101\\src\\com\\qadi\\Alarm_Sound.mp3");
                timer.cancel();
            }
        };
        timer.schedule(task, inputTime * 1000L);

    }
    public static void playSound(String soundFilePath) {
        try {
            File f = new File(soundFilePath);

            MP3Player mp3Player = new MP3Player(f);
            mp3Player.play();

            while (!mp3Player.isStopped()) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}


