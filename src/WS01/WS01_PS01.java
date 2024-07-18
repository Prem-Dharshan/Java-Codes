// 1. Write a java program to convert the temperature expressed in Fahrenheit degree into Celsius
// degree.

package WS01;

import java.util.Scanner;

class FahrenheitToCelsiusConvertor {
    public static void main(String[] args) {

        float fahrenheit, celsius;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the celsius");
            fahrenheit = scan.nextFloat();
        }

        celsius = (float) ((fahrenheit - 32) * 5 / 9);
        System.out.println(fahrenheit + "°F = " + celsius + "°C");
    }
}