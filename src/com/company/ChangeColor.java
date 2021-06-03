package com.company;

public class ChangeColor {
    private static Square[] square;

    public ChangeColor() {
        square = Square.getSguare();
    }

    public void changeColor(int i) { // смена цвета
        square[i].color = square[i].color + 1;
        if (square[i].color > 6) {
            square[i].color = 0;
        }
    }
}
