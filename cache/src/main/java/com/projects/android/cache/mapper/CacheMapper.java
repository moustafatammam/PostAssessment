package com.projects.android.cache.mapper;

public interface CacheMapper<T, V> {

    V mapFromCached(T t);

    T mapToCached(V v);
}
