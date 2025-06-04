package com.path2prod.section14.tdd;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.path2prod.ApiResponse;
import com.path2prod.Person;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Section14 {

        public static List<ApiResponse> challenge1() throws MalformedURLException, URISyntaxException, InterruptedException, ExecutionException{
        List<URL> urls = List.of(
            new URI("http://localhost:8080/user/id/1").toURL(),
            new URI("http://localhost:8080/user/id/1/address").toURL(),
            new URI("http://localhost:8080/user/id/1/contacts").toURL());

            return null;
    }

    public static List<String> challenge2(){
        Path section14path = Path.of("src/main/java/com/path2prod/section14").toAbsolutePath();
       
        if (!Files.exists(section14path) || !Files.isDirectory(section14path)){
            return Collections.emptyList();
        }
        return Collections.emptyList();

    }

    public static List<Person> challenge3(){
        List<Person> persons = Person.buildPersonList();
        return null;
    }

}
