package com.xyphias.trackpenpalreplies.foundational;

sealed public interface Result<E, V> permits Failure, Success {}
