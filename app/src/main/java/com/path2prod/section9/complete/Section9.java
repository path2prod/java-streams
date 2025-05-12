package com.path2prod.section9.complete;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.path2prod.Basket;
import com.path2prod.BasketItem;
import com.path2prod.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Section9 {

    public static List<Number> challenge1() {
        return List.of("1", "-1", "invalid", "two", "2.0")
                .stream()
                .map(n -> {
                    try {
                        return Optional.of(Integer.parseInt(n));
                    } catch (NumberFormatException e) {
                        try {
                            return Optional.of(Double.parseDouble(n));
                        } catch (NumberFormatException e1) {
                            return Optional.<Number>empty();
                        }
                    }
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public static List<Product> challenge2() {
        String p0 = """
                {"productName": "product0", "price": 0.3}
                """;

        String p1 = """
                {"name": "product1", "price": 2.3}
                """;

        String p2 = """
                {"name": "product2", "price": 5}
                """;

        String p3 = """
                {"displayName": "product3", "price": 5.1}
                """;

        ObjectMapper mapper = new ObjectMapper();
        Collection<Exception> exceptions = new ConcurrentLinkedQueue<>();

        List<Product> products = List.of(p0, p1, p2, p3)
                .parallelStream()
                .map(p -> {
                    try {
                        return Optional.of(mapper.readValue(p, Product.class));
                    } catch (Exception e) {
                        exceptions.add(e);
                        return Optional.<Product>empty();
                    }
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        exceptions.forEach(e -> log.error("error on product", e));

        return products;
    }

    public static Basket challenge3(){
        ObjectMapper mapper = new ObjectMapper();

        List<BasketItem> itemsOnstock = List.of(
            new BasketItem(new Product(2.5, "p1"), 3),
            new BasketItem(new Product(7.5, "p2"), 4),
            new BasketItem(new Product(1, "p3"), 1),
            new BasketItem(new Product(4.5, "p4"), 600)
        )
        .parallelStream()
        .map( basketItem -> {
            try {
                
                 HttpClient client = HttpClient.newHttpClient();
                 HttpRequest request = HttpRequest.newBuilder()
                 .timeout(Duration.ofSeconds(1))
                 .header("Content-Type", "application/json")
                 .uri(URI.create(String.format("http://localhost:8080/product/%s",basketItem.product().name())))
                 .GET()
                 .build();

                 JsonNode res = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply( t -> {
                    try {
                        return mapper.readTree(t);
                    } catch (JsonProcessingException e) {
                        throw new CompletionException(e);
                    } 
                })
                .get();

                int stock = res.get("stock").asInt();
                return Optional.of(stock < basketItem.quantity() ? new BasketItem(basketItem.product(), stock) :basketItem );


            } catch (Exception e) {
                return Optional.<BasketItem>empty();
            }
        })
        .filter(Optional::isPresent)
        .map(Optional::get)
        .toList();


        return new Basket(itemsOnstock);
    }
}
