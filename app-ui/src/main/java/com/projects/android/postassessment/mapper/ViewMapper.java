package com.projects.android.postassessment.mapper;

public interface ViewMapper<T, V> {

    V mapFromViewPost(T t);

    T mapToViewUser(V v);
}
