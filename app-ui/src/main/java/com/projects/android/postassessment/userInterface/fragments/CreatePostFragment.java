package com.projects.android.postassessment.userInterface.fragments;


import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentCreatePostBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.viewModel.AddPostViewModel;

import java.lang.reflect.Field;

import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CreatePostFragment extends BottomSheetDialogFragment {

    private FragmentCreatePostBinding fragmentCreatePostBinding;

    private Button createButton;
    private EditText titleCreateEditeText;
    private EditText bodyCreateEditeText;

    private Button closeButton;
    private View touchOutside;

    private AddPostViewModel mAddPostViewModel;
    private ViewModelFactory mViewModelFactory;
    private ViewMapperImpl mViewMapperImpl;

    int count;


    @Inject
    public CreatePostFragment(ViewModelFactory mViewModelFactory, ViewMapperImpl mViewMapperImpl) {
        this.mViewModelFactory = mViewModelFactory;
        this.mViewMapperImpl = mViewMapperImpl;
    }

    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        bottomSheetDialog.setContentView(R.layout.fragment_create_post);
        try {
            Field behaviorField = bottomSheetDialog.getClass().getDeclaredField("behavior");
            behaviorField.setAccessible(true);
            final BottomSheetBehavior behavior = (BottomSheetBehavior) behaviorField.get(bottomSheetDialog);
            behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                }
            });
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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

        closeButton.setOnClickListener(view -> Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_createPostFragment_to_postListFragment));

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupUpdateData();
            }
        });
        count();
    }

    private void setupViews() {
        touchOutside = getDialog().getWindow()
                .getDecorView()
                .findViewById(com.google.android.material.R.id.touch_outside);
        touchOutside.setOnClickListener(null);
        createButton = fragmentCreatePostBinding.createButton;
        closeButton = fragmentCreatePostBinding.exitEditScreenButton;
        titleCreateEditeText = fragmentCreatePostBinding.createTitle;
        bodyCreateEditeText = fragmentCreatePostBinding.createBody;
    }

    private void setupUpdateData() {
        titleCreateEditeText.setError(null);
        bodyCreateEditeText.setError(null);

        boolean cancel = false;
        View focusView = null;

        String titleText = titleCreateEditeText.getText().toString();

        if (titleText.isEmpty()) {
            titleCreateEditeText.setError("Title can not be empty");
            focusView = titleCreateEditeText;
            cancel = true;
        }
        String bodyText = bodyCreateEditeText.getText().toString();
        if (bodyText.isEmpty()) {
            bodyCreateEditeText.setError("Description can not be empty");
            focusView = bodyCreateEditeText;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();

        } else {
            ViewPost viewPost = new ViewPost(++count, titleText, bodyText);

            if (isInternetAvailable(getContext())) {
                //returns true if internet available
                addPost(viewPost);
                Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_createPostFragment_to_postListFragment);
            } else {
                Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_createPostFragment_to_postListFragment);
                Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void setCount(int count) {
        this.count = count;
    }


    public void count() {
        mAddPostViewModel.getGetCountLiveData().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                setCount(integer);
            }
        });
    }

    private void addPost(ViewPost viewPost) {
        mAddPostViewModel.addPost(mViewMapperImpl.mapFromViewPost(viewPost)).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static boolean isInternetAvailable(Context context) {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info == null) {
            Log.d(TAG, "no internet connection");
            return false;
        } else {
            if (info.isConnected()) {
                Log.d(TAG, " internet connection available...");
                return true;
            } else {
                Log.d(TAG, " internet connection");
                return true;
            }
        }
    }
}
