package com.projects.android.remote.mapper;

import com.projects.android.data.model.DataPost;
import com.projects.android.remote.model.RemotePost;

import javax.inject.Inject;

public class RemoteMapperImpl implements RemoteMapper<RemotePost, DataPost> {

    @Inject
    RemoteMapperImpl() {
    }

    @Override
    public DataPost mapFromRemoteModel(RemotePost remotePost) {
        return new DataPost(remotePost.getId(), remotePost.getTitle(), remotePost.getBody());
    }

    @Override
    public RemotePost mapToRemoteModel(DataPost dataPost) {
        return new RemotePost(dataPost.getId(), dataPost.getTitle(), dataPost.getBody());
    }
}
