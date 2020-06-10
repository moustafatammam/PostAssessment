package com.projects.android.data.mapper;

//this interface implementation should map different models from different layers
public interface DataMapper<T, V> {

    V mapFromDataModel(T t);

    T mapToDataModel(V v);
}
