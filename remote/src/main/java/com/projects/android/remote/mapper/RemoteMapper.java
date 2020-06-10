package com.projects.android.remote.mapper;

public interface RemoteMapper<T, V> {

    V mapFromRemoteModel(T t);

    T mapToRemoteModel(V v);
}
