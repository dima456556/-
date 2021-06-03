package com.company;

import javax.swing.*;

public class Window extends JFrame // наследуем класс JFrame
{
    public void addWindow() {
        setTitle("Квадраты");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(815,845);
        setLocation(600,300);
        add( new GameSquare());
        setVisible(true);
    }
}
