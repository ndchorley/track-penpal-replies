package com.xyphias.trackpenpalreplies.infrastructure;

sealed public interface Result<E, V> permits Failure, Success {}
