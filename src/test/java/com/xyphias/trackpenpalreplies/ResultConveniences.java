package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.foundational.Failure;
import com.xyphias.trackpenpalreplies.foundational.Result;
import com.xyphias.trackpenpalreplies.foundational.Success;

public class ResultConveniences {
    public static <E, V> V successful(Result<E, V> result) {
        return switch (result) {
            case Success(V value) -> value;
            case Failure(E error) -> 
                    throw new IllegalStateException("Expected a Success, but found a Failure: " + error);
        };
    }
}
