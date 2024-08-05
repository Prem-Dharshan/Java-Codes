// 2. Create a class Rectangle with attributes length and width, each of which defaults to 1. Provide
// methods that calculate the rectangle’s perimeter and area. It has set and get methods for both
// length and width. The set methods should verify that length and width are each floating-point
// numbers larger than 0.0 and less than 20.0. Write a program to test class Rectangle.

package WS05;

import java.util.Arrays;

public class WS05_PS02 {
    public static void main(String[] args) {

        Rectangle rect = new Rectangle(10, 10);
        System.out.println(rect);

        try {
            rect.setLength(0);
            rect.setWidth(21);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}

class Rectangle {

    private float length = 1;
    private float width = 1;

    public Rectangle(float length, float width) {
        setLength(length);
        setWidth(width);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if (length <= 0.0 || length >= 20.0) {
            throw new IllegalArgumentException("Length must be greater than 0 and less than 20");
        }
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if (width <= 0.0 || width >= 20.0) {
            throw new IllegalArgumentException("Width must be greater than 0 and less than 20");
        }
        this.width = width;
    }

    public float calculatePerimeter() {
        return 2 * (length + width);
    }

    public float calculateArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", perimeter=" + calculatePerimeter() +
                ", area=" + calculateArea() +
                '}';
    }
}
