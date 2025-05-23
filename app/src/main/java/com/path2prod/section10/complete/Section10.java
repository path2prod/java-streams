package com.path2prod.section10.complete;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.path2prod.UserProfile;
import com.path2prod.section10.complete.ValidatorBuilder.ValidationFactory;

public class Section10 {

    public static Optional<String> challenge1_wrong_email(){
        return new ValidationFactory().emailValidator().validate("");
    }

        public static Optional<String> challenge1_valid_email(){
        return new ValidationFactory().emailValidator().validate("valid@email.com");
    }

    public static List<Either<Exception,Integer>> challenge2(){
        return List.of("1","2","three").stream().map(Either.lift(Integer::parseInt)).toList();
    }

    public static List<String> challenge3(){
       return UserProfile.getUsers()
            .stream()
            .flatMap(Optional::stream) 
            .flatMap(profile -> streamOptional(profile.contactDetails()))
            .flatMap(contactInfo -> streamOptional(contactInfo.phoneNumber()))
            .toList();
          
    }

    private static <T> Stream<T> streamOptional(Optional<T> optional) {
        return optional.map(Stream::of).orElseGet(Stream::empty);
    }

}
