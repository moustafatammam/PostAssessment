package com.projects.android.postassessment.userInterface.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.FragmentEditPostBinding;
import com.projects.android.postassessment.mapper.ViewMapperImpl;
import com.projects.android.postassessment.model.ViewPost;
import com.projects.android.presentation.ViewModelFactory;
import com.projects.android.presentation.viewModel.GetAllPostsViewModel;
import com.projects.android.presentation.viewModel.UpdatePostViewModel;

import java.lang.reflect.Field;
import java.util.Objects;

import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class EditPostFragment extends BottomSheetDialogFragment {

    private FragmentEditPostBinding fragmentEditPostBinding;

    private Button updateButton;
    private EditText titleEditBox;
    private EditText bodyEditText;
    private Button closeButton;
    private int updateId;

    private UpdatePostViewModel mUpdatePostViewModel;
    private ViewModelFactory mViewModelFactory;
    private ViewMapperImpl mViewMapperImpl;

    @Inject
    public EditPostFragment(ViewModelFactory mViewModelFactory, ViewMapperImpl mViewMapperImpl) {
        this.mViewModelFactory = mViewModelFactory;
        this.mViewMapperImpl = mViewMapperImpl;
    }

    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        bottomSheetDialog.setContentView(R.layout.fragment_edit_post);

        try {
            Field behaviorField = bottomSheetDialog.getClass().getDeclaredField("behavior");
            behaviorField.setAccessible(true);
            final BottomSheetBehavior behavior = (BottomSheetBehavior) behaviorField.get(bottomSheetDialog);
            behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING){
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
        fragmentEditPostBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_post, container, false);
        return fragmentEditPostBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateId = EditPostFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getUpdateId();
        setupViews();
        mUpdatePostViewModel = new ViewModelProvider(this, mViewModelFactory).get(UpdatePostViewModel.class);

        View touchOutside = getDialog().getWindow()
                .getDecorView()
                .findViewById(com.google.android.material.R.id.touch_outside);

        touchOutside.setOnClickListener(null);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_editPostFragment_to_postListFragment);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupUpdateData();
            }
        });


    }

    private void setupViews() {
        updateButton = fragmentEditPostBinding.createButton;
        closeButton = fragmentEditPostBinding.exitEditScreenButton;
        titleEditBox = fragmentEditPostBinding.createTitle;
        bodyEditText = fragmentEditPostBinding.createBody;
    }

    private void setupUpdateData() {
        titleEditBox.setError(null);
        bodyEditText.setError(null);

        boolean cancel = false;
        View focusView = null;

        String titleText = titleEditBox.getText().toString();

        if (titleText.isEmpty()) {
            titleEditBox.setError("Title can not be empty");
            focusView = titleEditBox;
            cancel = true;
        }
        String bodyText = bodyEditText.getText().toString();
        if (bodyText.isEmpty()) {
            bodyEditText.setError("Description can not be empty");
            focusView = bodyEditText;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();

        } else {
            ViewPost viewPost = new ViewPost(updateId, titleText, bodyText);

            if(isInternetAvailable(getContext())) //returns true if internet available
            {
                updateTask(viewPost);
                Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_editPostFragment_to_postListFragment);
            }
            else
            {
                Navigation.findNavController(getActivity(), R.id.nav_host).navigate(R.id.action_editPostFragment_to_postListFragment);
                Toast.makeText(getContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void updateTask(ViewPost viewPost) {
        mUpdatePostViewModel.updatePost(mViewMapperImpl.mapFromViewPost(viewPost)).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static boolean isInternetAvailable(Context context)
    {
        NetworkInfo info = (NetworkInfo) ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null)
        {
            Log.d(TAG,"no internet connection");
            return false;
        }
        else
        {
            if(info.isConnected())
            {
                Log.d(TAG," internet connection available...");
                return true;
            }
            else
            {
                Log.d(TAG," internet connection");
                return true;
            }

        }
    }
}
