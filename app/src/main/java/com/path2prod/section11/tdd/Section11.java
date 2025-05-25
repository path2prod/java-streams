package com.path2prod.section11.tdd;

import java.time.LocalDate;
import java.util.List;

public class Section11 {

    public static List<LocalDate> challenge1(){
       List.of(
            LocalDate.now().plusDays(1),
            LocalDate.now().plusMonths(2),
            LocalDate.now().minusDays(2),
            LocalDate.now().minusMonths(3));

      return null;
    }
}
