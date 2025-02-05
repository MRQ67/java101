package com.qadi;

import java.awt.*;
import javax.swing.*;

public class Gui {
    private static void createWindow() {
        JFrame frame = new JFrame("Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createWindow();
    }
}
