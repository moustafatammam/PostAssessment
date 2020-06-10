package com.projects.android.presentation.mapper;

public interface PresenterMapper<T, V> {

    V mapToPresenterModel(T t);

    T mapFromPresenterModel(V v);
}
