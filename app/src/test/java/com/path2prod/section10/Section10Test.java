package com.path2prod.section10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.path2prod.section10.complete.Either;
import com.path2prod.section10.tdd.Section10;

public class Section10Test {

    @Test
    @DisplayName("Creating a data validator that returns Optional results for different validation rules")
    void challenge1_wrong_email(){
        Optional<String> maybeErrors = Section10.challenge1_wrong_email();
        Assertions.assertTrue(maybeErrors.isPresent());
    }

    @Test
    @DisplayName("Creating a data validator that returns Optional results for different validation rules")
    void challenge1_valid_email(){
        Optional<String> maybeErrors = Section10.challenge1_valid_email();
        Assertions.assertFalse(maybeErrors.isPresent());
    }

    @Test
    @DisplayName("Build An Either pattern implementation for functional error handling implementing a lift pattern.")
    void challenge2(){
        List<Either<Exception,Integer>> result = Section10.challenge2();
        assertEquals(3, result.size());
        assertEquals(1, result.get(0).getResult());
        assertEquals(2, result.get(1).getResult());
    
    }

    @Test
    @DisplayName("Extract all valid phone numbers from profiles that have contact information")
    void challenge3(){
        List<String> phoneNumbers = Section10.challenge3();
        assertEquals(1, phoneNumbers.size());
        assertEquals("07777777777", phoneNumbers.get(0));
    }
}
