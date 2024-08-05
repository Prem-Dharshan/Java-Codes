// 4. Create a class called Complex for performing arithmetic with complex numbers. Complex
// numbers have the form
// realPart + imaginaryPart * i, where i is √−1
// Write a program to test your class. Use floating-point variables to represent the private data of
// the class. Provide a constructor that enables an object of this class to be initialized when it’s
// declared. Provide a no-argument constructor with default values in case no initializers are
// provided. Provide public methods that perform the following operations:
//  a) Add two Complex numbers: The real parts are added together and the imaginary parts are
//     added together.
//  b) Subtract two Complex numbers: The real part of the right operand is subtracted from the
//     real part of the left operand, and the imaginary part of the right operand is subtracted from the
//     imaginary part of the left operand.
//  c) Print Complex numbers in the form (realPart, imaginaryPart).

package WS05;

public class WS05_PS04 {

    public static void main(String[] args) {
        Complex num1 = new Complex();
        System.out.println("Default Constructor: " + num1);

        num1.setData(5F, 10F);
        System.out.println("After Setting Data:\nNum 1: " + num1);

        Complex num2 = new Complex(10, 5);
        System.out.println("After Initialising:\nNum 2: " + num2);

        System.out.println(num1 + " + " + num2 + " = " + Complex.add(num1, num2));
        System.out.println(num2 + " - " + num1 + " = " + Complex.subtract(num1, num2));

        return;
    }
}

class Complex {

    Float real;
    Float img;

    public Complex() {
        this.real = null;
        this.img = null;
    }

    public Complex(float real, float img) {
        this.real = real;
        this.img = img;
    }

    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.real + c2.real, c1.img + c2.img);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        return new Complex(c2.real - c1.real, c2.img - c1.img);
    }

    public void setData(Float real, Float img) {
        this.real = real;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Complex number (" + this.real + ", " + this.img + "i)" ;
    }
}