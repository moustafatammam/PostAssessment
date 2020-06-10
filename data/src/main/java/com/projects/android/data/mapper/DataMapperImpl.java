package com.projects.android.data.mapper;

import com.projects.android.data.model.DataPost;
import com.projects.android.domain.model.Post;

import javax.inject.Inject;

//a mapper to convert models from data layer to domain layer and the opposite
public class DataMapperImpl implements DataMapper<DataPost, Post> {

    @Inject
    DataMapperImpl() {
    }


    @Override
    public Post mapFromDataModel(DataPost dataPost) {
        return new Post(dataPost.getId(), dataPost.getTitle(), dataPost.getBody());
    }

    @Override
    public DataPost mapToDataModel(Post post) {
        return new DataPost(post.getId(), post.getTitle(), post.getBody());
    }
}
