package com.xyphias.trackpenpalreplies.foundational;

public record Failure<E, V>(E error) implements Result<E, V> {}
