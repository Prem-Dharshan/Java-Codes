# Java Worksheet 05

## Classes, Objects, Interfaces, and Packages

1. **Create a Room class**  
   Design a class named `Room` with attributes: `roomno`, `roomtype`, and `roomarea`. Implement methods `setData` and `displayData` to manipulate the data.  
   [Answer](WS05_PS01.java)

2. **Create a Rectangle class**  
   Design a class named `Rectangle` with attributes `length` and `width`, each defaulting to 1. Provide methods to calculate the rectangle’s perimeter and area. Include set and get methods for both `length` and `width`, ensuring that they are floating-point numbers between 0.0 and 20.0. Write a program to test the `Rectangle` class.  
   [Answer](WS05_PS02.java)

3. **Create a Player class**  
   Design a class named `Player` with private attributes: `String name`, `int age`, `String country`. Include appropriate getters and setters. Provide a default constructor and a 3-argument constructor (name, age, country). Override the `toString` method to display the player details.  
   [Answer](WS05_PS03.java)

4. **Create a Complex class**  
   Design a class named `Complex` for performing arithmetic with complex numbers of the form `realPart + imaginaryPart * i`. Implement methods for adding, subtracting, and printing complex numbers. Include constructors for initialization with and without parameters.  
   [Answer](WS05_PS04.java)

5. **Create a BloodData class**  
   Design a class named `BloodData` that includes fields for blood type and Rh factor. Implement a default constructor and an overloaded constructor. Include getters and setters for each field. Create a `Patient` class with fields for ID number, age, and `BloodData`. Implement constructors and getters for `Patient`. Create an application to test these classes.  
   [Answer](WS05_PS05.java)

6. **Design a Stack class**  
   Create a `Stack` class with methods: `empty()`, `peek()`, `push(value: int)`, `pop()`, and `getSize()`. Implement both default and parameterized constructors.  
   [Answer](WS05_PS06.java)

7. **Create Customer and Invoice classes**  
   Design a `Customer` class and an `Invoice` class that contains an instance of `Customer`. Implement methods for managing customer details and calculating invoice amounts after discounts. Develop a test driver class with the `main()` method to test these classes.  
   [Answer](WS05_PS07.java)

8. **Create a PaymentProcessor interface**  
   Design an interface named `PaymentProcessor` with methods for processing payments, validating credit cards, and generating receipts. Implement this interface in `CreditCard` and `PayPal` classes. Develop a program to simulate the payment process for online purchases.  
   [Answer](WS05_PS08.java)

9. **Create an Element abstract class**  
   Design an abstract class named `Element` with properties: symbol, atomic number, and atomic weight. Implement a constructor and getters. Include an abstract method `describeElement()`. Create `MetalElement` and `NonMetalElement` classes that extend `Element` and override `describeElement()`. Write an application to create and display an array of these elements.  
   [Answer](WS05_PS09.java)

10. **Create packages and classes**
    - **General Package**: Create a `Person` class.
    - **StudentDetail Package**: Create `Student` and `Exam` classes, extending `Person` and `Student` respectively.
    - **FacultyDetail Package**: Create a `Faculty` class extending `Person`.
    - **Test Package**: Create a driver class `WS05_PS10` to test `Exam` and `Faculty` classes.  
      [Answer](Test/WS05_PS10.java)

---
