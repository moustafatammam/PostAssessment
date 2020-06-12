package com.projects.android.postassessment.userInterface.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentEditPostBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel;
import com.projects.android.presentation.viewModel.UpdatePostViewModel;

import java.util.Objects;

import javax.inject.Inject;

public class EditPostFragment extends BottomSheetDialogFragment {

    private FragmentEditPostBinding fragmentEditPostBinding;

    private Button updateButton;
    private EditText titleEditBox;
    private EditText bodyEditText;
    private int updateId;

    private UpdatePostViewModel mUpdatePostViewModel;
    private ViewModelFactory mViewModelFactory;
    private ViewMapperImpl mViewMapperImpl;

    @Inject
    public EditPostFragment(ViewModelFactory mViewModelFactory, ViewMapperImpl mViewMapperImpl) {
        this.mViewModelFactory = mViewModelFactory;
        this.mViewMapperImpl = mViewMapperImpl;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentEditPostBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_post, container, false);
        return fragmentEditPostBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateId = EditPostFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getUpdateId();
        setupViews();

        mUpdatePostViewModel = new ViewModelProvider(this, mViewModelFactory).get(UpdatePostViewModel.class);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupUpdateData();
            }
        });
    }

    private void setupViews(){
        updateButton = fragmentEditPostBinding.createButton;
        titleEditBox = fragmentEditPostBinding.createTitle;
        bodyEditText = fragmentEditPostBinding.createBody;
    }

    private void setupUpdateData(){
        titleEditBox.setError(null);
        bodyEditText.setError(null);

        boolean cancel = false;
        View focusView = null;

        String titleText = titleEditBox.getText().toString();

        if(titleText.isEmpty()){
            titleEditBox.setError("Title can not be empty");
            focusView = titleEditBox;
            cancel = true;
        }
        String bodyText = bodyEditText.getText().toString();
        if(bodyText.isEmpty()){
            bodyEditText.setError("Description can not be empty");
            focusView = bodyEditText;
            cancel = true;
        }

        if (cancel){
            focusView.requestFocus();

        }else{
            ViewPost viewPost = new ViewPost(updateId,titleText, bodyText);
            updateTask(viewPost);
            Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_editPostFragment_to_postListFragment);
        }
    }

    private void updateTask(ViewPost viewPost){
        mUpdatePostViewModel.updatePost(mViewMapperImpl.mapFromViewPost(viewPost)).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
