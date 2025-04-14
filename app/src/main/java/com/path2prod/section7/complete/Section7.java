package com.path2prod.section7.complete;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Section7 {

    public static String challenge1() {
        Collector<String, StringJoiner, String> coordinatesCollector = Collector.of(
            () -> new StringJoiner(";", "[", "]"),
            formatCoordinates(),
            StringJoiner::merge,
            StringJoiner::toString
        );
        
        return List.of("40.753", "-73.983")
                  .stream()
                  .collect(coordinatesCollector);
    }

    private static BiConsumer<StringJoiner, String> formatCoordinates() {
        return (sj, coord) -> {
            double decimal = Double.parseDouble(coord);
            int degrees = (int) decimal;
            double minutes = Math.abs((decimal - degrees) * 60);
            sj.add(degrees + "° " + String.format("%.2f'", minutes));
        };
    }

    public static Map<String,Double> challenge2() throws IOException{
        try (Stream<String> lines = Files.lines(Path.of("src/main/java/com/path2prod/resources/products.cvs").toAbsolutePath()) ) {
            return lines
            .skip(1)
            .collect(
                Collectors.groupingBy(
                    line -> line.split(",")[1],
                    Collectors.summingDouble( line -> {
                        
                       double total= Double.parseDouble(line.split(",")[2]) * Double.parseDouble(line.split(",")[3]);
                       return BigDecimal.valueOf(total).setScale(2,RoundingMode.CEILING).doubleValue();
                
                    })));
        
                }
    }

    public static List<Entry<String,Long>> challenge3() throws IOException{
        try (Stream<String> lines = Files.lines(Path.of("src/main/java/com/path2prod/resources/ramdon_text.txt").toAbsolutePath()).parallel()) {
            return lines.flatMap(line -> List.of(line.split("\\W+")).stream())
            .filter(word -> !word.isEmpty())
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
            .entrySet()
            .stream()
            .collect(Collectors.groupingBy(Map.Entry::getValue,TreeMap::new,Collectors.toList()))
            .lastEntry()
            .getValue();
        } 
    }

    public static List<Integer> challenge4(){
        return List.of(IntStream.rangeClosed(0, 4).boxed().toList(),IntStream.rangeClosed(5, 10).boxed().toList())
        .stream()
        .flatMap(Collection::stream)
        .toList();
    }

}
