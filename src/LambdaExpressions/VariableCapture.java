package LambdaExpressions;

public class VariableCapture {
    public static void main(String[] args) {
        // Local variable that can be captured by the lambda
        int num = 10;  // This is an "effectively final" variable

    MyFunc myLambda =
        (n) -> {
            // This use of 'num' is allowed since it is effectively final
            System.out.println("This is a lambda expression: " + num);
            return num + n;
        };

        // Error: Modifying 'num' here would break its effectively final status
//         num++;

        System.out.println(myLambda.func(5)); // Output: 15
    }
}

interface MyFunc {
    int func(int n);
}
