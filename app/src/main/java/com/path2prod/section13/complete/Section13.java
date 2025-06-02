package com.path2prod.section13.complete;

import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.path2prod.Person;

public class Section13 {

    public static List<Double> challenge1(){
        DoubleFunction<DoubleFunction<Double>> bmiFn = w -> h -> w /( h * h );

        return Person.buildPersonList()
        .stream()
        .map( p -> bmiFn.apply(p.weight()).apply(p.height()))
        .map( bmi -> Math.floor(bmi * 100) / 100)
        .toList();
    }

    public static List<String> challenge2(){
        Function<Person,String> getName = Person::name;
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        Function<Person,String> upperCaseName = getName.andThen(toUpperCase);
        Function<Person,String> addTittle = upperCaseName.andThen( name -> new StringBuilder("Mr/Mrs ").append(name).toString());

        return Person.buildPersonList()
        .stream()
        .filter( p -> p.age() >= 18)
        .map(addTittle)
        .toList();
    }

}
