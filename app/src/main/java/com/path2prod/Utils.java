package com.path2prod;

import java.util.List;

public class Utils {

   public static List<Person> buildPersonList(){
        return List.of(new Person(18, "just-eighteen"),new Person(15, "less-eighteen"),new Person(34,"over-eighteen"));
    }

    public static List<Product> buildProductList(){
        return List.of(new Product(2.4,"product1"),new Product(5.0, "product2"),new Product(3.4,"product3"));
    }

    public static List<Employee> buildEmployeeList(){
        return List.of(
        new Employee("d1", "person-d1-3"),
        new Employee("d1", "person-d1-1"),
        new Employee("d2", "person-d2-1"),
        new Employee("d1", "person-d1-2"),
        new Employee("d2", "person-d2-2"),
        new Employee("d3", "person-d3-1"));
    }

    public static List<Student> buildStudents(){
        return List.of(
        new Student("student1", 0),
        new Student("student2", 65),
        new Student("student3", 99),
        new Student("student4", 60),
        new Student("student5", 29),
        new Student("student6", 45),
        new Student("student7", 56),
        new Student("student8", 38),
        new Student("student9", 77)
        );
    }
}
