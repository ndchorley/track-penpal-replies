package com.xyphias.trackpenpalreplies.infrastructure;

public record Failure<E, V>(E error) implements Result<E, V> {}
