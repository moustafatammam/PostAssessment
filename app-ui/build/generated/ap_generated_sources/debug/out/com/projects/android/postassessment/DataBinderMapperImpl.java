package com.projects.android.postassessment;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.projects.android.postassessment.databinding.ActivityMainBindingImpl;
import com.projects.android.postassessment.databinding.FragmentCreatePostBindingImpl;
import com.projects.android.postassessment.databinding.FragmentEditPostBindingImpl;
import com.projects.android.postassessment.databinding.FragmentPostDetailsBindingImpl;
import com.projects.android.postassessment.databinding.FragmentPostListBindingImpl;
import com.projects.android.postassessment.databinding.PostItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;

@Generated("Android Data Binding")
public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_FRAGMENTCREATEPOST = 2;

  private static final int LAYOUT_FRAGMENTEDITPOST = 3;

  private static final int LAYOUT_FRAGMENTPOSTDETAILS = 4;

  private static final int LAYOUT_FRAGMENTPOSTLIST = 5;

  private static final int LAYOUT_POSTITEM = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.projects.android.postassessment.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.projects.android.postassessment.R.layout.fragment_create_post, LAYOUT_FRAGMENTCREATEPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.projects.android.postassessment.R.layout.fragment_edit_post, LAYOUT_FRAGMENTEDITPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.projects.android.postassessment.R.layout.fragment_post_details, LAYOUT_FRAGMENTPOSTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.projects.android.postassessment.R.layout.fragment_post_list, LAYOUT_FRAGMENTPOSTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.projects.android.postassessment.R.layout.post_item, LAYOUT_POSTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCREATEPOST: {
          if ("layout/fragment_create_post_0".equals(tag)) {
            return new FragmentCreatePostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_create_post is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEDITPOST: {
          if ("layout/fragment_edit_post_0".equals(tag)) {
            return new FragmentEditPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_edit_post is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPOSTDETAILS: {
          if ("layout/fragment_post_details_0".equals(tag)) {
            return new FragmentPostDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_post_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPOSTLIST: {
          if ("layout/fragment_post_list_0".equals(tag)) {
            return new FragmentPostListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_post_list is invalid. Received: " + tag);
        }
        case  LAYOUT_POSTITEM: {
          if ("layout/post_item_0".equals(tag)) {
            return new PostItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for post_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewpost");
      sKeys.put(2, "postDetailsViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_main_0", com.projects.android.postassessment.R.layout.activity_main);
      sKeys.put("layout/fragment_create_post_0", com.projects.android.postassessment.R.layout.fragment_create_post);
      sKeys.put("layout/fragment_edit_post_0", com.projects.android.postassessment.R.layout.fragment_edit_post);
      sKeys.put("layout/fragment_post_details_0", com.projects.android.postassessment.R.layout.fragment_post_details);
      sKeys.put("layout/fragment_post_list_0", com.projects.android.postassessment.R.layout.fragment_post_list);
      sKeys.put("layout/post_item_0", com.projects.android.postassessment.R.layout.post_item);
    }
  }
}
