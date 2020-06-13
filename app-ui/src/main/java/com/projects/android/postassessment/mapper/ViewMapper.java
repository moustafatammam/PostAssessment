package com.projects.android.postassessment.mapper;

/**
 *
 * @param <T> the model post of the ui layer
 * @param <V> the model post of the presentation layer
 */
public interface ViewMapper<T, V> {

    V mapFromViewPost(T t);

    T mapToViewUser(V v);
}
