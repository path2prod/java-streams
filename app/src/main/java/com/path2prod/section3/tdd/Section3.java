package com.path2prod.section3.tdd;

import java.util.List;
import java.util.Map;

import com.path2prod.Employee;
import com.path2prod.Product;
import com.path2prod.Utils;

public class Section3 {

        @SuppressWarnings("preview")
    public static Map<String,List<Employee>> challenge1(){
        Utils.buildEmployeeList().stream();
        return null; 
    }


    public static Map<String,List<Employee>> challenge2(){
        Utils.buildEmployeeList().stream();
        return null;     }

    public static Map<Boolean,Long> challenge3(){
        Utils.buildStudents().stream();
        return null; 
    }

    public static double challenge4(){
        List.of(1,2,3,4,5,6,7,8,9,10).stream();
        return 0.0;
    }

    public static List<Product> challenge5(){
        return Utils.buildProductList().stream().toList();
    }

    public static String challenge6(){
        List.of("This","is","challenge","6").stream();
        return "";
    }

}
