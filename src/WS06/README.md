# Java Programming Lab - Problem Sheet 6: Exception Handling

## Problems and Solutions

1. **Array Size Validation**
    - **Problem**: Write a program to check whether the given array size is negative or not using try and catch blocks.
    - **Solution**: [Solution File](./WS06_PS01.java)

2. **Multiple Catch Statements**
    - **Problem**: Write a program to demonstrate multiple catch statements in a program.
    - **Solution**: [Solution File](./WS06_PS02.java)

3. **Subclass Exception Precedence**
    - **Problem**: Illustrate subclass exception precedence over a base class in exception handling.
    - **Solution**: [Solution File](./WS06_PS03.java)

4. **Division with Error Handling**
    - **Problem**: Write a program to divide two numbers. Create a function called `doDivision()` to perform the division. Handle `ArithmeticException`, `ArrayIndexOutOfBoundsException`, and `NumberFormatException` in the `main()` method.
    - **Solution**: [Solution File](./WS06_PS04.java)

5. **Student Details with Array Index Handling**
    - **Problem**: Display the name and roll number of 10 students. Handle `ArrayIndexOutOfBoundsException` to prevent illegal termination of the program.
    - **Solution**: [Solution File](./WS06_PS05.java)

6. **User-Defined Exception: `NoMatchException`**
    - **Problem**: Create a user-defined exception class called `NoMatchException`. Write a constructor that takes a string argument and a method to print the stored string. Use this exception if a user-entered string is not equal to `"India"`.
    - **Solution**: [Solution File](./WS06_PS06.java)

7. **Score Validation with Custom Exception**
    - **Problem**: Display a series of student IDs and ask the user to enter a numeric test score. Create a `ScoreException` class and throw it if the score is not valid (greater than 100). Catch the exception, display a message, and store a score of 0 for invalid entries.
    - **Solution**: [Solution File](./WS06_PS07.java)

8. **Password Validation with Custom Exception: `WeakPasswordException`**
    - **Problem**: Validate a password input with the following criteria:
        - Minimum 10 characters and maximum 20 characters.
        - At least one digit.
        - At least one special character.
        - At least one letter.
    - **Solution**: [Solution File](./WS06_PS08.java)

---
