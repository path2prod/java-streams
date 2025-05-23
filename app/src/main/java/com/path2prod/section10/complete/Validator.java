package com.path2prod.section10.complete;

import java.util.Optional;

@FunctionalInterface
public interface Validator<T> {
    Optional<String> validate(T value);
}
