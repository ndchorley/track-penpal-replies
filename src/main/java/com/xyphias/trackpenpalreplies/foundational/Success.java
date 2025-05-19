package com.xyphias.trackpenpalreplies.foundational;

public record Success<E, V>(V value) implements Result<E, V> {}
