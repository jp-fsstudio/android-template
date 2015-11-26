package com.fsstudio.template;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fsstudio.template.fragments.MainFragmentBuilder;
import com.fsstudio.template.rx.RxActivity;
import com.fsstudio.template.utils.Persistence;
import com.fsstudio.template.utils.StatusBar;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import butterknife.InjectView;
import dagger.Lazy;

public class MainActivity extends RxActivity {
  @Inject Lazy<Persistence> persistence;

  @InjectView(R.id.toolbar) Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    StatusBar.setup(this);
    setSupportActionBar(toolbar);
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.content, new MainFragmentBuilder(R.id.content).build())
          .commit();
    }

  }
}