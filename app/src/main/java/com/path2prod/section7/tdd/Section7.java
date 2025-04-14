package com.path2prod.section7.tdd;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Section7 {

     public static String challenge1() {
        List.of("40.753", "-73.983");
        return "";
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
        Files.lines(Path.of("src/main/java/com/path2prod/resources/products.cvs").toAbsolutePath());
        return null;
    }

    public static List<Entry<String,Long>> challenge3() throws IOException{
        Files.lines(Path.of("src/main/java/com/path2prod/resources/ramdon_text.txt").toAbsolutePath();
        return null;
    }

    public static List<Integer> challenge4(){
        List.of(IntStream.rangeClosed(0, 4).boxed().toList(),IntStream.rangeClosed(5, 10).boxed().toList());
        return null;
    }

}
