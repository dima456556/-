package com.company;

// импортируем классы
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSquare extends JPanel implements ActionListener { //имплементирую интерфейс
    private static final int size = 800; // размер поля
    private Timer timer; // таймер
    private static Square[] square; // массив квадратов
    private Move MOVE;
    private CheckCollisionsWall CCW;

    public class Thread1 extends Thread {
        public void run() {
            MOVE.move(); // движение квадратов
        }
    }

    public class Thread2 extends Thread {
        public void run() {
            CCW.checkCollisionsWall(); // Проверка на столкновения
        }
    }

    public GameSquare() { // Конструктор класса GameField
        initGame();
        MOVE = new Move();
        CCW = new CheckCollisionsWall();
    }

    public void initGame() { // начало игры
        setBackground(Color.black); // цвет поля
        square = Square.getSguare();
        timer = new Timer(10, this);
        timer.start(); // запускаю таймер
    }

    @Override
    protected void paintComponent(Graphics g) { // метод для отрисовки компонентов
        super.paintComponent(g);
        for (int i = 0; i < this.square.length; i++) {
            switch (square[i].color) {
                case 0:
                    g.setColor(Color.RED);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
                case 1:
                    g.setColor(Color.orange);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
                case 2:
                    g.setColor(Color.yellow);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
                case 3:
                    g.setColor(Color.green);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
                case 4:
                    g.setColor(Color.cyan);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
                case 5:
                    g.setColor(Color.blue);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
                case 6:
                    g.setColor(Color.magenta);
                    g.fillRect(square[i].pointXSquare, square[i].pointYSquare, square[i].sizeSquare, square[i].sizeSquare);
                    break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { // метод вызывается по таймеру
        Thread1 t1 = new Thread1();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        Thread2 t2 = new Thread2();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        repaint(); // перерисовка
    }
}