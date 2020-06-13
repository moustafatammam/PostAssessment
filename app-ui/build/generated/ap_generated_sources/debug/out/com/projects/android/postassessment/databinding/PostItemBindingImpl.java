package com.projects.android.postassessment.databinding;
import com.projects.android.postassessment.R;
import com.projects.android.postassessment.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class PostItemBindingImpl extends PostItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.edit_post_button, 3);
        sViewsWithIds.put(R.id.delete_post_button, 4);
        sViewsWithIds.put(R.id.constraint_item_layout, 5);
        sViewsWithIds.put(R.id.item_list_handle, 6);
        sViewsWithIds.put(R.id.guideline, 7);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PostItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private PostItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.ImageButton) bindings[4]
            , (android.widget.ImageButton) bindings[3]
            , (androidx.constraintlayout.widget.Guideline) bindings[7]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (com.chauthai.swipereveallayout.SwipeRevealLayout) bindings[0]
            );
        this.postBody.setTag(null);
        this.postTitle.setTag(null);
        this.swipeReveal.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewpost == variableId) {
            setViewpost((com.projects.android.postassessment.model.ViewPost) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewpost(@Nullable com.projects.android.postassessment.model.ViewPost Viewpost) {
        this.mViewpost = Viewpost;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewpost);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewpostTitle = null;
        java.lang.String viewpostBody = null;
        com.projects.android.postassessment.model.ViewPost viewpost = mViewpost;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewpost != null) {
                    // read viewpost.title
                    viewpostTitle = viewpost.getTitle();
                    // read viewpost.body
                    viewpostBody = viewpost.getBody();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.postBody, viewpostBody);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.postTitle, viewpostTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewpost
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}