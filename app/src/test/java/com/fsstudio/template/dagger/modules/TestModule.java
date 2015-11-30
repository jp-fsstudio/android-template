package com.fsstudio.template.dagger.modules;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import dagger.Module;

@Module
public class TestModule extends AppModule {

    public TestModule(@NotNull Application application) {
        super(application);
    }
}
