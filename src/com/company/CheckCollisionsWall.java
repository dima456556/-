package com.company;

public class CheckCollisionsWall {
    private static Square[] square;
    private static final int size = 800;

    public CheckCollisionsWall() {
        square = Square.getSguare();
    }

    public void checkCollisionsWall() { // проверка на столкновения квадрата со стеной
        for (int i = 0; i < this.square.length; i++) {
            if (square[i].pointXSquare + square[i].sizeSquare >= size) {
                square[i].left = true;
                square[i].right = false;
            }
            if (square[i].pointXSquare <= 0) {
                square[i].left = false;
                square[i].right = true;
            }
            if (square[i].pointYSquare + square[i].sizeSquare >= size) {
                square[i].down = false;
                square[i].up = true;
            }
            if (square[i].pointYSquare <= 0) {
                square[i].down = true;
                square[i].up = false;
            }
        }
    }
}
