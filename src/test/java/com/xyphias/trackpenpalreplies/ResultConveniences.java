package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.foundational.Failure;
import com.xyphias.trackpenpalreplies.foundational.Result;
import com.xyphias.trackpenpalreplies.foundational.Success;

public class ResultConveniences {
    public static <E, T> T successful(Result<E, T> result) {
        return switch (result) {
            case Success(T value) -> value;
            case Failure(E error) -> 
                    throw new IllegalStateException("Expected a Success, but found a Failure: " + error);
        };
    }
}
