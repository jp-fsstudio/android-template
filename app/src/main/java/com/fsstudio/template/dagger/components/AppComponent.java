package com.fsstudio.template.dagger.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsstudio.template.App;
import com.fsstudio.template.dagger.modules.AppModule;
import com.fsstudio.template.utils.DatabaseHelper;
import com.fsstudio.template.utils.Persistence;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);
    App application();
    Persistence persistanse();
    OkHttpClient okHttpClient();
    ObjectMapper objectMapper();
    DatabaseHelper bdHelper();
    Picasso picasso();

}
