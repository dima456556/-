package com.company;

public class Move {
    private static Square[] square;
    private CheckCollisionsSquare CCS;

    public Move() {
        square = Square.getSguare();
        CCS = new CheckCollisionsSquare();
    }

    public void move() { // движение квадратов
        for (int i = 0; i < this.square.length; i++) {
            if (square[i].left) {
                square[i].pointXSquare -= 1;
            }
            if (square[i].right) {
                square[i].pointXSquare += 1;
            }
            if (square[i].up) {
                square[i].pointYSquare -= 1;
            }
            if (square[i].down) {
                square[i].pointYSquare += 1;
            }
            CCS.checkCollisionsSquare(); // проверка на столкновения квадратов
        }
    }
}
