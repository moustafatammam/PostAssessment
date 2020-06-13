package com.projects.android.postassessment.userInterface.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.projects.android.postassessment.R;
import com.projects.android.postassessment.databinding.ActivityMainBinding;
import com.projects.android.postassessment.userInterface.InjectingFragmentFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    ActivityMainBinding activityMainBinding;


    @Inject
    InjectingFragmentFactory injectingFragmentFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        getSupportFragmentManager().setFragmentFactory(injectingFragmentFactory);
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host);

        NavigationUI.setupActionBarWithNavController(this, navController);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_24px);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}
