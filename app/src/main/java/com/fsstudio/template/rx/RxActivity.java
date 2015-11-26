package com.fsstudio.template.rx;

import android.os.Bundle;

import com.f2prateek.dart.Dart;
import com.fsstudio.template.base.ModularActionBarActivity;

import butterknife.ButterKnife;


public class RxActivity extends ModularActionBarActivity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Dart.inject(this);
  }

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.inject(this);
  }
}
