package com.fsstudio.template.dagger.components;


import android.support.v4.app.FragmentActivity;

import com.fsstudio.template.MainActivity;
import com.fsstudio.template.dagger.ActivityScope;
import com.fsstudio.template.dagger.modules.MainModule;
import com.fsstudio.template.fragments.MainFragment;

import dagger.Component;

@ActivityScope
@Component(
    dependencies = {
        AppComponent.class
    },
    modules = {
        MainModule.class
    }
)
public interface MainComponent {
    void inject(MainActivity activity);
    void inject(MainFragment fragment);

    FragmentActivity activity();
}
