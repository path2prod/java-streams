package com.path2prod.section10.tdd;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.path2prod.UserProfile;

public class Section10 {

        public static Optional<String> challenge1_wrong_email(){
        String emailToValidate="";
        return null;
    }

        public static Optional<String> challenge1_valid_email(){
        String emailToValidate="valid@email.com";  
        return null;  
    }

    public static List<Either<Exception,Integer>> challenge2(){
        List.of("1","2","three");
        return null;
    }

    public static List<String> challenge3(){
       List<Optional<UserProfile>> users = UserProfile.getUsers();
       return null;     
    }

}
