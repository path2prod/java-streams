package com.path2prod.section11.complete;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Section11 {

    public static List<LocalDate> challenge1(){
       return List.of(
            LocalDate.now().plusDays(1),
            LocalDate.now().plusMonths(2),
            LocalDate.now().minusDays(2),
            LocalDate.now().minusMonths(3))
            .stream()
            .collect(
                Collectors.teeing(Collectors.minBy(LocalDate::compareTo), Collectors.maxBy(LocalDate::compareTo), (maybeMix,maybeMax) -> List.of(maybeMix.orElse(null),maybeMax.orElse(null))));
    }

}
