package com.company;

public class ChangeSize {
    private static Square[] square;

    public ChangeSize() {
        square = Square.getSguare();
    }

    public void changeSize (int i) // смена размера квадрата
    {
        switch(Math.random() < 0.5 ? 1 : 2) {
            case 1:
                square[i].sizeSquare=square[i].sizeSquare+3;
                break;
            case 2:
                square[i].sizeSquare=square[i].sizeSquare-3;
                break;
        }
        if(square[i].sizeSquare>35)
        {
            square[i].sizeSquare=10;
        }
        if(square[i].sizeSquare<5)
        {
            square[i].sizeSquare=10;
        }
    }
}
