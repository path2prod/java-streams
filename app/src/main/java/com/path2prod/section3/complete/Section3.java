package com.path2prod.section3.complete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Gatherers;

import com.path2prod.Employee;
import com.path2prod.Product;
import com.path2prod.Utils;

public class Section3 {

    @SuppressWarnings("preview")
    public static Map<String,List<Employee>> challenge1(){

           return Utils.buildEmployeeList().stream()
                     .gather(
                         Gatherers.fold(
                             HashMap<String,List<Employee>>::new,
                             (map, employee) -> {
                                 map.computeIfAbsent(employee.department(), _ -> new ArrayList<Employee>())
                                    .add(employee);
                                 return map;
                             }
                         )).findFirst().orElseThrow(() -> new RuntimeException("no data present"));
    }


    public static Map<String,List<Employee>> challenge2(){
           return Utils.buildEmployeeList().stream().collect(Collectors.groupingBy(Employee::department));
    }

    public static Map<Boolean,Long> challenge3(){
        return Utils.buildStudents().stream().collect(Collectors.partitioningBy(student -> student.score() >= 60, Collectors.counting()));
    }

    public static double challenge4(){
        return List.of(1,2,3,4,5,6,7,8,9,10).stream().collect(Collectors.averagingInt(num -> num));
    }

    public static List<Product> challenge5(){
        return Utils.buildProductList().stream().sorted(Comparator.comparingDouble(Product::price).reversed()).limit(2).toList();
    }

    public static String challenge6(){
        return List.of("This","is","challenge","6").stream().collect(Collectors.joining(" "));
    }

}
