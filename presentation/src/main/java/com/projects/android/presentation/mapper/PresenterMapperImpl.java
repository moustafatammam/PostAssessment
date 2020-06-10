package com.projects.android.presentation.mapper;

import com.projects.android.domain.model.Post;
import com.projects.android.presentation.model.PresenterPost;

import javax.inject.Inject;

public class PresenterMapperImpl implements PresenterMapper<Post, PresenterPost>{

    @Inject
    public PresenterMapperImpl() {
    }

    @Override
    public PresenterPost mapToPresenterModel(Post post) {
        return new PresenterPost(post.getId(), post.getTitle(), post.getBody());
    }

    @Override
    public Post mapFromPresenterModel(PresenterPost presenterPost) {
        return new Post(presenterPost.getId(), presenterPost.getTitle(), presenterPost.getBody());
    }
}
