package com.fsstudio.template;

import com.fsstudio.template.dagger.components.AppComponent;
import com.fsstudio.template.dagger.components.DaggerAppComponent;
import com.fsstudio.template.dagger.modules.AppModule;
import com.fsstudio.template.dagger.modules.TestModule;
import com.fsstudio.template.utils.Lists;

import java.util.List;

import org.jetbrains.annotations.NotNull;

/**
 * Created by adelnizamutdinov on 22/12/14
 */
public class TestApp extends App {

    @Override
    public AppComponent getDaggerComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder().appModule(new TestModule(this)).build();
        }
        return component;
    }
}
