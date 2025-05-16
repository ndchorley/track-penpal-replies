package com.xyphias.trackpenpalreplies.infrastructure;

public record Success<E, V>(V value) implements Result<E, V> {}
