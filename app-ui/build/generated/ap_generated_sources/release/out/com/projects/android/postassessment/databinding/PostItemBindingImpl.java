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
        sViewsWithIds.put(R.id.delete_post_button, 3);
        sViewsWithIds.put(R.id.edit_post_button, 4);
        sViewsWithIds.put(R.id.item_list_handle, 5);
    }
    // views
    @NonNull
    private final com.chauthai.swipereveallayout.SwipeRevealLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PostItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private PostItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[4]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (com.chauthai.swipereveallayout.SwipeRevealLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.postBody.setTag(null);
        this.postTitle.setTag(null);
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