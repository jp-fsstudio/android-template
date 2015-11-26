package com.fsstudio.template.fragments;

import android.os.Bundle;
import com.fsstudio.template.R;
import com.fsstudio.template.module.HomeAsUpModule;
import com.fsstudio.template.rx.RxPreferenceFragment;


public class PrefsFragment extends RxPreferenceFragment {
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activity().setTitle(R.string.settings);
    addPreferencesFromResource(R.xml.prefs);
    addCallbackListener(new HomeAsUpModule(activity(), this));
  }
}
