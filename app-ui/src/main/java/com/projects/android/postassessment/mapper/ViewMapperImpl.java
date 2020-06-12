package com.projects.android.postassessment.mapper;

import com.projects.android.domain.model.Post;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.presentation.model.PresenterPost;

import javax.inject.Inject;

public class ViewMapperImpl implements ViewMapper<ViewPost, PresenterPost> {

    @Inject
    public ViewMapperImpl() {
    }

    @Override
    public PresenterPost mapFromViewPost(ViewPost viewPost) {
        return new PresenterPost(viewPost.getId(), viewPost.getTitle(), viewPost.getBody());
    }

    @Override
    public ViewPost mapToViewUser(PresenterPost presenterPost) {
        return new ViewPost(presenterPost.getId(), presenterPost.getTitle(), presenterPost.getBody());
    }
}
