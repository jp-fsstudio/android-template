package com.fsstudio.template.dagger.modules;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.fsstudio.template.dagger.ActivityScope;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    private final FragmentActivity activity;

    public MainModule(FragmentActivity activity) {
        this.activity = activity;
    }

    public MainModule(Fragment fragment) {
        this.activity = fragment.getActivity();
    }

    @Provides @ActivityScope FragmentActivity providesActivity() {
        return activity;
    }

}
