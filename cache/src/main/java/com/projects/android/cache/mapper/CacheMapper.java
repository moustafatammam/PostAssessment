package com.projects.android.cache.mapper;

/**
 *
 * @param <T> the model post of the cache layer
 * @param <V> the model post of the data layer
 */
public interface CacheMapper<T, V> {

    V mapFromCached(T t);

    T mapToCached(V v);
}
