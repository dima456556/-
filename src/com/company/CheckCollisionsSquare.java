package com.company;

public class CheckCollisionsSquare {
    private static Square[] square;
    private ChangeColor CC;
    private ChangeSize CS;

    public CheckCollisionsSquare() {
        square = Square.getSguare();
        CC = new ChangeColor();
        CS = new ChangeSize();
    }

    public void checkCollisionsSquare() { // проверка на столкновения квадратов
        for (int i = 0; i < this.square.length; i++) {
            for (int j = 0; j < this.square.length; j++) {
                if (i != j) {
                    boolean flag = false;
                    if (square[i].left) {
                        if (square[i].pointXSquare == square[j].pointXSquare + square[j].sizeSquare) {
                            if (square[i].sizeSquare >= square[j].sizeSquare) {
                                for (int k = square[i].pointYSquare; k < square[i].pointYSquare + square[i].sizeSquare; k++) {
                                    if (k == square[j].pointYSquare || k == square[j].pointYSquare + square[j].sizeSquare) {
                                        flag = true;
                                    }
                                }
                            }
                            if (square[i].sizeSquare < square[j].sizeSquare) {
                                for (int k = square[j].pointYSquare; k < square[j].pointYSquare + square[j].sizeSquare; k++) {
                                    if (k == square[i].pointYSquare || k == square[i].pointYSquare + square[i].sizeSquare) {
                                        flag = true;
                                    }
                                }
                            }
                            if (flag) {
                                CC.changeColor(i);
                                CC.changeColor(j);
                                CS.changeSize(i);
                                CS.changeSize(j);
                                square[i].pointXSquare = square[i].pointXSquare+3;
                                square[i].left = false;
                                square[i].right = true;
                                if (square[j].up || square[j].down) {
                                    square[j].down = false;
                                    square[j].up = false;
                                    square[j].left = true;
                                }
                            }
                        }
                    } else {
                        flag = false;
                        if (square[i].right) {
                            if (square[i].pointXSquare + square[i].sizeSquare == square[j].pointXSquare) {
                                if (square[i].sizeSquare >= square[j].sizeSquare) {
                                    for (int k = square[i].pointYSquare; k < square[i].pointYSquare + square[i].sizeSquare; k++) {
                                        if (k == square[j].pointYSquare || k == square[j].pointYSquare + square[j].sizeSquare) {
                                            flag = true;
                                        }
                                    }
                                }
                                if (square[i].sizeSquare < square[j].sizeSquare) {
                                    for (int k = square[j].pointYSquare; k < square[j].pointYSquare + square[j].sizeSquare; k++) {
                                        if (k == square[i].pointYSquare || k == square[i].pointYSquare + square[i].sizeSquare) {
                                            flag = true;
                                        }
                                    }
                                }
                            }
                        }
                        if (flag) {
                            CC.changeColor(i);
                            CC.changeColor(j);
                            CS.changeSize(i);
                            CS.changeSize(j);
                            square[i].pointXSquare = square[i].pointXSquare-3;
                            square[i].left = true;
                            square[i].right = false;
                            if (square[j].up || square[j].down) {
                                square[j].down = false;
                                square[j].up = false;
                                square[j].right = true;
                            }
                        }
                    }
                    if (square[i].up) {
                        flag = false;
                        if (square[i].pointYSquare == square[j].pointYSquare + square[j].sizeSquare) {
                            if (square[i].sizeSquare >= square[j].sizeSquare) {
                                for (int k = square[i].pointXSquare; k < square[i].pointXSquare + square[i].sizeSquare; k++) {
                                    if (k == square[j].pointXSquare || k == square[j].pointXSquare + square[j].sizeSquare) {
                                        flag = true;
                                    }
                                }
                            }
                            if (square[i].sizeSquare < square[j].sizeSquare) {
                                for (int k = square[j].pointXSquare; k < square[j].pointXSquare + square[j].sizeSquare; k++) {
                                    if (k == square[i].pointXSquare || k == square[i].pointXSquare + square[i].sizeSquare) {
                                        flag = true;
                                    }
                                }
                            }
                            if (flag) {
                                CC.changeColor(i);
                                CC.changeColor(j);
                                CS.changeSize(i);
                                CS.changeSize(j);
                                square[i].pointYSquare = square[i].pointYSquare+3;
                                square[i].up = false;
                                square[i].down = true;
                                if (square[j].left || square[j].right) {
                                    square[j].left = false;
                                    square[j].right = false;
                                    square[j].up = true;
                                }
                            }
                        }
                    } else {
                        if (square[i].down) {
                            flag = false;
                            if (square[i].pointYSquare + square[i].sizeSquare == square[j].pointYSquare) {
                                if (square[i].sizeSquare >= square[j].sizeSquare) {
                                    for (int k = square[i].pointXSquare; k < square[i].pointXSquare + square[i].sizeSquare; k++) {
                                        if (k == square[j].pointXSquare || k == square[j].pointXSquare + square[j].sizeSquare) {
                                            flag = true;
                                        }
                                    }
                                }
                                if (square[i].sizeSquare < square[j].sizeSquare) {
                                    for (int k = square[j].pointXSquare; k < square[j].pointXSquare + square[j].sizeSquare; k++) {
                                        if (k == square[i].pointXSquare || k == square[i].pointXSquare + square[i].sizeSquare) {
                                            flag = true;
                                        }
                                    }
                                }
                            }
                            if (flag) {
                                CC.changeColor(i);
                                CC.changeColor(j);
                                CS.changeSize(i);
                                CS.changeSize(j);
                                square[i].pointYSquare = square[i].pointYSquare-3;
                                square[i].down = false;
                                square[i].up = true;
                                if (square[j].left || square[j].right) {
                                    square[j].left = false;
                                    square[j].right = false;
                                    square[j].down = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
