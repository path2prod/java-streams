package com.path2prod.section10.complete;

import java.util.function.Function;

public class Either<L,R> {
    private final L error;
    private final R result;

    private Either(L error, R result){
        this.error = error;
        this.result = result;
    }

    public R getResult(){
        return this.result;
    }

    public L getError(){
        return this.error;
    }

    public static <L,R> Either<L,R> ofError(L error){
        return new Either<>(error, null);
    }

    public static <L,R> Either<L,R> ofSuccess(R result){
        return new Either<>(null, result);
    }

    public boolean isSuccess(){
        return this.result!=null && this.error==null;
    }
    
    public static <T, R> Function<T, Either<Exception, R>> lift(Function<T, R> function) {
        return t -> {
            try {
                return Either.ofSuccess(function.apply(t));
            } catch (Exception e) {
                return Either.ofError(e);
            }
        };
    }

}
