package com.projects.android.presentation.mapper;

/**
 *
 * @param <T> the model post of the domain layer
 * @param <V> the model post of the presentation layer
 */
public interface PresenterMapper<T, V> {

    V mapToPresenterModel(T t);

    T mapFromPresenterModel(V v);
}
