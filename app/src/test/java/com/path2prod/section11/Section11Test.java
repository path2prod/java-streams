package com.path2prod.section11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section11.tdd.Section11;

public class Section11Test {

    @Test
    @DisplayName("Process a stream of dates to find the earliest and latest dates")
    void challenge1(){
        List<LocalDate> dates = Section11.challenge1();
        assertEquals(2, dates.size());
        assertEquals(LocalDate.now().minusMonths(3), dates.get(0));
        assertEquals(LocalDate.now().plusMonths(2), dates.get(1));
    }

}
