package com.path2prod;

import java.util.List;

import com.path2prod.section14.Sensitive;

public record Person(int age, @Sensitive String name,double height, double weight) {
      private static final double DEFAULT_HEIGHT = 0.0;
      private static final double DEFAULT_WEIGHT = 0.0;

      public Person(int age,String name){
        this(age,name,DEFAULT_HEIGHT,DEFAULT_WEIGHT);
      }

         public static List<Person> buildPersonList(){
            return List.of(
                new Person(18, "just-eighteen",1.78,86),
                new Person(15, "less-eighteen",1.90,78),
                new Person(34,"over-eighteen",1.60,52));
    }
}
