package com.projects.android.data.mapper;

/**
 *
 * @param <T> the model post of the data layer
 * @param <V> the model post of the domain layer
 */
public interface DataMapper<T, V> {

    V mapFromDataModel(T t);

    T mapToDataModel(V v);
}
