package WS10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class EmployeeManagement {

    public static void main() {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("USA", "John", 25, 1));
        employees.addAll(
                Arrays.asList(
                        new Employee("USA", "Alice", 30, 2),
                        new Employee("UK", "Bob", 45, 3),
                        new Employee("USA", "Charlie", 55, 4),
                        new Employee("USA", "David", 60, 5),
                        new Employee("UK", "Eve", 35, 6),
                        new Employee("India", "Frank", 70, 7),
                        new Employee("USA", "George", 50, 8),
                        new Employee("UK", "Harry", 55, 9),
                        new Employee("USA", "Ivy", 45, 10),
                        new Employee("India", "Jack", 51, 11),
                        new Employee("India", "Kane", 25, 12),
                        new Employee("India", "Lily", 35, 13)
                )
        );

        // 1. Find employees with age over 50
        List<Employee> employeesOver50 = employees.stream()
                .filter(emp -> emp.age > 50)
                .toList();

        System.out.println("Employees over 50 years old:");
        employeesOver50.forEach(System.out::println);

        // 2. Print employees from USA
        List<Employee> employeesFromUSA = employees.stream()
                .filter(emp -> "USA".equals(emp.country))
                .toList();

        System.out.println("\nEmployees from USA:");
        employeesFromUSA.forEach(System.out::println);

        // 3. Sort employees by country
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(emp -> emp.country))
                .toList();

        System.out.println("\nEmployees sorted by country:");
        sortedEmployees.forEach(System.out::println);
    }
}

class Employee {
    int id;
    int age;
    String name;
    String country;

    public Employee(String country, String name, int age, int id) {
        this.country = country;
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', age=" + age + ", country='" + country + "'}";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
