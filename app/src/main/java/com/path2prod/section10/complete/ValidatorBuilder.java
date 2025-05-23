package com.path2prod.section10.complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;


public class ValidatorBuilder<T> {

    List<Validator<T>> validators = new ArrayList<>();

    ValidatorBuilder<T> with(Predicate<T> rule, String message){
        validators.add( value -> rule.test(value) ? Optional.empty() : Optional.of(message));
        return this;
    }

    public Validator<T> build(){
        return value -> 
            validators
            .stream()
            .map( validator -> validator.validate(value))
            .filter(Optional::isPresent)
            .findFirst()
            .orElse(Optional.empty());
    }

    public Validator<T> buildWithAllErrors() {
        return value -> {
            List<String> errors = validators.stream()
                    .map(validator -> validator.validate(value))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            return errors.isEmpty() 
                    ? Optional.empty() 
                    : Optional.of(String.join(", ", errors));
        };
    }

    Optional<String> validate(T value){
        return validators.stream().map(rule -> rule.validate(value)).filter(Optional::isPresent).findFirst().orElse(Optional.empty());

    }

   public static class ValidationFactory{
        private final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        private final String PASSWORD_REGEX ="^[a-zA-Z\\d]+$";

        public Validator<String> emailValidator(){
            return new ValidatorBuilder<String>()
            .with(StringUtils::isNotBlank,"email can not be blank")
            .with(value -> value != null && value.matches(EMAIL_REGEX),"email has invalid format")
            .buildWithAllErrors();
        }

        public Validator<String> passwordValidator(){
            return new ValidatorBuilder<String>()
            .with(StringUtils::isNotBlank,"password can not be blank")
            .with( value -> value != null && value.length() <= 8, "password must be min 8")
            .with( value -> value != null && value.length() >= 16, "password must be max 16")
            .with( value -> value != null && value.matches(PASSWORD_REGEX),"password must contains letters and numbers only")
            .buildWithAllErrors();
        }
       
    }

}
