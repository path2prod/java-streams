package com.path2prod.section14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.path2prod.ApiResponse;
import com.path2prod.Person;
import com.path2prod.section14.tdd.Section14;

@WireMockTest(httpPort = 8080)
public class Section14Test {


    @Test
    @DisplayName("Use streams with CompletableFuture to process data asynchronously")
    void challenge1() throws MalformedURLException, URISyntaxException, InterruptedException, ExecutionException{
        List<ApiResponse> responses = Section14.challenge1();
        assertEquals(3, responses.size());
        assertNotNull(responses.get(0).content());
        assertNotNull(responses.get(1).content());
        assertNotNull(responses.get(2).error());
    }

    @Test
    @DisplayName("Integrate streams with Java NIO to process files efficiently")
    void challenge2() throws IOException{
        List<String> files = Section14.challenge2();
        assertEquals(3, files.size());
        assertEquals("complete-Section14.java", files.get(0));
        assertEquals("section14-Sensitive.java", files.get(1));
        assertEquals("tdd-Section14.java", files.get(2));
    }

    @Test
    @DisplayName("Mask sensitive fields using reflection")
    void challenge3(){
        List<Person> maskedPersons = Section14.challenge3();
        assertEquals(3, maskedPersons.size());
        assertEquals("*****", maskedPersons.get(0).name());
        assertEquals("*****", maskedPersons.get(1).name());
        assertEquals("*****", maskedPersons.get(2).name());
    }
}
