package com.qadi;

import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlarmGUI extends JFrame {
    private JTextField timeField;
    private JButton startButton;
    private JLabel statusLabel;
    private Timer countdownTimer;  // Swing timer for countdown
    private int remainingSeconds;

    public AlarmGUI() {
        super("Alarm Timer");
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter time (seconds): "));
        timeField = new JTextField(10);
        inputPanel.add(timeField);
        startButton = new JButton("Start Timer");
        inputPanel.add(startButton);
        add(inputPanel, BorderLayout.NORTH);

        // Status label
        statusLabel = new JLabel("Timer not started.", SwingConstants.CENTER);
        add(statusLabel, BorderLayout.CENTER);

        // Button action
        startButton.addActionListener(e -> startTimer());

        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    private void startTimer() {
        try {
            remainingSeconds = Integer.parseInt(timeField.getText().trim());
            if (remainingSeconds <= 0) {
                statusLabel.setText("Enter a positive number.");
                return;
            }
            startButton.setEnabled(false);
            statusLabel.setText("Time remaining: " + remainingSeconds + " seconds.");

            // Create a Swing timer that fires every second
            countdownTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    remainingSeconds--;
                    if (remainingSeconds > 0) {
                        statusLabel.setText("Time remaining: " + remainingSeconds + " seconds.");
                    } else {
                        countdownTimer.stop();
                        statusLabel.setText("Times up!, Your Alarm is Ringing");
                        // Play sound on a separate thread so UI doesn't freeze
                        new Thread(() -> playSound("D:\\Downloads\\Music\\lh44.mp3")).start();
                        startButton.setEnabled(true);
                    }
                }
            });
            countdownTimer.start();
        } catch (NumberFormatException ex) {
            statusLabel.setText("Please enter a valid number.");
        }
    }

    public void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            if (!soundFile.exists()) {
                System.err.println("File not found: " + soundFilePath);
                return;
            }
            MP3Player mp3Player = new MP3Player(soundFile);
            mp3Player.play();

            // Wait until the sound finishes playing
            while (!mp3Player.isStopped()) {
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlarmGUI alarm = new AlarmGUI();
            alarm.setVisible(true);
        });
    }
}
