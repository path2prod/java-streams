package com.path2prod.section14.complete;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import com.path2prod.ApiResponse;
import com.path2prod.Person;
import com.path2prod.section14.Sensitive;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Section14 {

    public static List<ApiResponse> challenge1() throws MalformedURLException, URISyntaxException, InterruptedException, ExecutionException{
        List<URL> urls = List.of(
            new URI("http://localhost:8080/user/id/1").toURL(),
            new URI("http://localhost:8080/user/id/1/address").toURL(),
            new URI("http://localhost:8080/user/id/1/contacts").toURL());

            return fetchAndProcessUrls(urls).get();
    }

    private static CompletableFuture<List<ApiResponse>> fetchAndProcessUrls(List<URL> urls){
        List<CompletableFuture<ApiResponse>> futures = urls.stream().map( url -> 
                     fetchUrl(url)
                    .handle((content, error) -> {
                        if (error != null) {
                            log.error("Error processing url {}: {}", url, error.getMessage());
                            return new ApiResponse(null, "Failed to process: " + error.getMessage());
                        } else {
                            log.info("Processed url {}", url);
                            return new ApiResponse(content, null);
                        }
                    }))
                    .toList();


        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
            .thenApply(_ -> futures.stream()
                .map(CompletableFuture::join)
                .toList());
    }

    private static CompletableFuture<String> fetchUrl(URL url){
        try{
            HttpRequest request = HttpRequest.newBuilder()
            .uri(url.toURI())
            .header("Content-Type", "application/json")
            .timeout(Duration.ofSeconds(30))
            .GET()
            .build();
        
        return HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(res -> {
                    int statusCode = res.statusCode();
                    if (statusCode >= 200 && statusCode < 300) {
                        return res.body();
                    } else {
                        throw new RuntimeException("HTTP error " + statusCode + " for URL: " + url);
                    }
                });
        }catch(URISyntaxException e){
            return CompletableFuture.failedFuture(e);
        }
    }

    public static List<String> challenge2() throws IOException{
        Path section14path = Path.of("src/main/java/com/path2prod/section14").toAbsolutePath();
       
        if (!Files.exists(section14path) || !Files.isDirectory(section14path)){
            return Collections.emptyList();
        }

       try (Stream<Path> paths = Files.walk(section14path)){
                    return paths.filter(Files::isRegularFile)
                    .map( file -> file.getParent().getFileName().toString() + '-' + file.getFileName().toString())
                    .toList();
       }

    }

    public static List<Person> challenge3(){
        return Person.buildPersonList()
            .stream()
            .map( p -> maskSensitiveFields(p) )
            .toList();
    }

    private static Person maskSensitiveFields(Person p) {
        try {
            Field[] fields = Person.class.getDeclaredFields();

            Object[] args = Arrays.stream(fields)
                .filter(f -> !Modifier.isStatic(f.getModifiers()))
                .map(f -> {
                    f.setAccessible(true);
                    try {
                        Object value = f.get(p);
                        return f.isAnnotationPresent(Sensitive.class) ? "*****" : value;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to read field: " + f.getName(), e);
                    }
                })
                .toArray();

            Constructor<Person> constructor = Person.class.getDeclaredConstructor(
                int.class, String.class, double.class, double.class
            );

            return constructor.newInstance(args);

        } catch (Exception e) {
            throw new RuntimeException("Failed to mask sensitive fields", e);
        }
    }


}
