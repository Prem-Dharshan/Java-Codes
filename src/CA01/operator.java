package CA01;

public class operator {

    public static void main(String[] args) {
        // Arithmetic Operators
        int a = 10;
        int b = 5;
        System.out.println("Arithmetic Operators:");
        System.out.println("a + b = " + (a + b)); // Addition
        System.out.println("a - b = " + (a - b)); // Subtraction
        System.out.println("a * b = " + (a * b)); // Multiplication
        System.out.println("a / b = " + (a / b)); // Division
        System.out.println("a % b = " + (a % b)); // Modulus

        // Unary Operators
        int x = 5;
        System.out.println("\nUnary Operators:");
        System.out.println("x = " + x);
        System.out.println("++x = " + (++x)); // Pre-increment
        System.out.println("x++ = " + (x++)); // Post-increment
        System.out.println("x after post-increment = " + x);
        System.out.println("--x = " + (--x)); // Pre-decrement
        System.out.println("x-- = " + (x--)); // Post-decrement
        System.out.println("x after post-decrement = " + x);
        System.out.println("-x = " + (-x)); // Unary minus
        System.out.println("+x = " + (+x)); // Unary plus

        // Relational Operators
        int p = 10;
        int q = 20;
        System.out.println("\nRelational Operators:");
        System.out.println("p == q: " + (p == q)); // Equal to
        System.out.println("p != q: " + (p != q)); // Not equal to
        System.out.println("p > q: " + (p > q)); // Greater than
        System.out.println("p < q: " + (p < q)); // Less than
        System.out.println("p >= q: " + (p >= q)); // Greater than or equal to
        System.out.println("p <= q: " + (p <= q)); // Less than or equal to

        // Logical Operators
        boolean flag1 = true;
        boolean flag2 = false;
        System.out.println("\nLogical Operators:");
        System.out.println("flag1 && flag2: " + (flag1 && flag2)); // Logical AND
        System.out.println("flag1 || flag2: " + (flag1 || flag2)); // Logical OR
        System.out.println("!flag1: " + (!flag1)); // Logical NOT

        // Bitwise Operators
        int m = 5; // 0101 in binary
        int n = 3; // 0011 in binary
        System.out.println("\nBitwise Operators:");
        System.out.println("m & n: " + (m & n)); // Bitwise AND
        System.out.println("m | n: " + (m | n)); // Bitwise OR
        System.out.println("m ^ n: " + (m ^ n)); // Bitwise XOR
        System.out.println("~m: " + (~m)); // Bitwise NOT
        System.out.println("m << 1: " + (m << 1)); // Left shift
        System.out.println("m >> 1: " + (m >> 1)); // Right shift
        System.out.println("m >>> 1: " + (m >>> 1)); // Unsigned right shift

        // Assignment Operators
        int z = 10;
        System.out.println("\nAssignment Operators:");
        z += 5; // Add and assign
        System.out.println("z += 5: " + z);
        z -= 3; // Subtract and assign
        System.out.println("z -= 3: " + z);
        z *= 2; // Multiply and assign
        System.out.println("z *= 2: " + z);
        z /= 4; // Divide and assign
        System.out.println("z /= 4: " + z);
        z %= 3; // Modulus and assign
        System.out.println("z %= 3: " + z);

        // Ternary Operator
        int max = (a > b) ? a : b;
        System.out.println("\nTernary Operator:");
        System.out.println("The maximum of a and b is: " + max);

        // Instanceof Operator
        String str = "Hello";
        System.out.println("\nInstanceof Operator:");
        System.out.println("str instanceof String: " + (str instanceof String));
    }
}

