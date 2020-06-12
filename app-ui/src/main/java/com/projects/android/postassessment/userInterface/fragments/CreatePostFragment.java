package com.projects.android.postassessment.userInterface.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.projects.android.cache.PostCacheImpl;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentCreatePostBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.viewModel.AddPostViewModel;

import javax.inject.Inject;

public class CreatePostFragment extends BottomSheetDialogFragment {

    private FragmentCreatePostBinding fragmentCreatePostBinding;

    private Button createButton;
    private EditText titleCreateEditeText;
    private EditText bodyCreateEditeText;

    private AddPostViewModel mAddPostViewModel;
    private ViewModelFactory mViewModelFactory;
    private ViewMapperImpl mViewMapperImpl;

    int count;


    @Inject
    public CreatePostFragment(ViewModelFactory mViewModelFactory, ViewMapperImpl mViewMapperImpl) {
        this.mViewModelFactory = mViewModelFactory;
        this.mViewMapperImpl = mViewMapperImpl;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentCreatePostBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_post, container, false);
        return fragmentCreatePostBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupViews();

        mAddPostViewModel = new ViewModelProvider(this, mViewModelFactory).get(AddPostViewModel.class);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupUpdateData();
            }
        });

        count();
    }

    private void setupViews(){
        createButton = fragmentCreatePostBinding.createButton;
        titleCreateEditeText = fragmentCreatePostBinding.createTitle;
        bodyCreateEditeText = fragmentCreatePostBinding.createBody;
    }

    private void setupUpdateData(){
        titleCreateEditeText.setError(null);
        bodyCreateEditeText.setError(null);

        boolean cancel = false;
        View focusView = null;

        String titleText = titleCreateEditeText.getText().toString();

        if(titleText.isEmpty()){
            titleCreateEditeText.setError("Title can not be empty");
            focusView = titleCreateEditeText;
            cancel = true;
        }
        String bodyText = bodyCreateEditeText.getText().toString();
        if(bodyText.isEmpty()){
            bodyCreateEditeText.setError("Description can not be empty");
            focusView = bodyCreateEditeText;
            cancel = true;
        }

        if (cancel){
            focusView.requestFocus();

        }else{
            Log.d("asjgask", Integer.toString(count) );
            ViewPost viewPost = new ViewPost(++count, titleText, bodyText);
            addPost(viewPost);
            Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_createPostFragment_to_postListFragment);
        }
    }
    private void setCount(int count){
        this.count = count;
    }

    public void count(){
        mAddPostViewModel.getGetCountLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                setCount(integer);

            }
        });
    }
    private void addPost(ViewPost viewPost){
        mAddPostViewModel.addPost(mViewMapperImpl.mapFromViewPost(viewPost)).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("viewmodel", s);
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
