package com.projects.android.remote.mapper;

/**
 *
 * @param <T> the model post of the remote layer
 * @param <V> the model post of the data layer
 */
public interface RemoteMapper<T, V> {

    V mapFromRemoteModel(T t);

    T mapToRemoteModel(V v);
}
