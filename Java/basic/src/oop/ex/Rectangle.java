package oop.ex;

public class Rectangle {
    int width = 0;
    int height = 0;
    void calculateArea(){
        int area = width * height;
        System.out.println("넓이: " + area);
    }
    void calculatePerimeter(){
        int perimeter =  2 * (width + height);
        System.out.println("둘레 길이: " + perimeter);
    }

    void isSquare(){
        boolean square = (width == height);
        System.out.println("정사각형 여부: " + square);
    }
}
