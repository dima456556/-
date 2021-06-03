package com.company;

import java.util.Scanner;

public class Square {
    int pointXSquare; // располение квадрата на поле x;
    int pointYSquare ; // расположение квадрата на поле y;
    int maxSizeSquare=35; // max размер квадрата;
    int sizeSquare ; // размер квадрата
    int color; // цвет
    private final int SIZE = 800; // размер поля
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    private final static int maxSguare = 100; // max кол-во квадратов
    private static Square[] square;

    private Square () {
        sizeSquare= ((int) (Math.random() * maxSizeSquare)); // генерируем размер квадрата
        color = (int)(Math.random() * 6);
        if (sizeSquare<10) {
            sizeSquare=10;
        }
        pointXSquare=((int)(Math.random()*SIZE-maxSizeSquare)+10); //генерируем расположение квадрата по x
        pointYSquare= ((int) (Math.random() * SIZE-maxSizeSquare)+10); //генерируем расположение квадрата по y
        if((pointXSquare<0)||(pointYSquare<0)) {
            pointXSquare=1; pointYSquare=1; }
        switch ( (int)(Math.random() * 3)) {
            case 0:
                left = true;
                break;
            case 1:
                right=true;
                break;
            case 2:
                up=true;
                break;
            case 3:
                down=true;
                break;
            default:
                break;
        }
    }

    public static Square [] getSguare() {
        if(square==null) {
            int a=returnNumber();
            square= new Square[a]; }
        for (int i = 0; i <square.length ; i++) { // инициализирую квадраты
            square[i]= new Square();
        }
        return square;
    }

    public static int returnNumber() { // функция возвращает число введенное пользователем
        System.out.println("Введите кол-во квадратов (не более 100)");
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
        int i ;
        if(sc.hasNextInt()) { // возвращает истинну если с потока ввода можно считать целое число
            i=sc.nextInt(); // считывает целое число с потока ввода и сохраняем в переменную
            if (i==0||i>maxSguare) {
                i= (int)(Math.random() * maxSguare-1)+1;
            }
        }
        else {
            System.out.println("Вы ввели не целое число");
            i=returnNumber();
        }
        return i;
    }
}
