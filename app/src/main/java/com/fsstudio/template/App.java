package com.fsstudio.template;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.fsstudio.template.dagger.components.AppComponent;
import com.fsstudio.template.dagger.components.DaggerAppComponent;
import com.fsstudio.template.dagger.modules.AppModule;
import com.fsstudio.template.utils.Lists;
import com.fsstudio.template.utils.TimberCrashReportingTree;

import io.fabric.sdk.android.Fabric;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import timber.log.Timber;

public class App extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        Timber.plant(BuildConfig.DEBUG
                ? new Timber.DebugTree()
                : new TimberCrashReportingTree());
        component = getDaggerComponent();
    }

    public AppComponent getDaggerComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        return component;
    }

}
