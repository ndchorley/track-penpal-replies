package com.xyphias.trackpenpalreplies;

import com.xyphias.trackpenpalreplies.foundational.Failure;
import com.xyphias.trackpenpalreplies.foundational.Result;
import com.xyphias.trackpenpalreplies.foundational.Success;

public class ResultConveniences {
    public static <T> T successful(Result<String, T> result) {
        return switch (result) {
            case Success(T value) -> value;
            case Failure(_) -> 
                    throw new IllegalStateException("Expected a Success, but found a Failure");
        };
    }
}
