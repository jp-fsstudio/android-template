package com.fsstudio.template.fragments;

import android.support.v4.app.FragmentManager;
import com.fsstudio.template.R;
import com.fsstudio.template.rx.RxActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class PrefsFragmentTest {
  PrefsFragment fragment;

  @Before public void setUp() throws Exception {
    final FragmentManager fm = Robolectric.buildActivity(RxActivity.class)
        .create()
        .get()
        .getSupportFragmentManager();
    fragment = new PrefsFragment();
    fm.beginTransaction()
        .add(android.R.id.content, fragment)
        .commit();
  }

  @Test public void testOnCreate() throws Exception {
    assertThat(fragment.getActivity().getTitle())
        .isEqualTo(RuntimeEnvironment.application.getString(R.string.settings));
    assertThat(fragment.getPreferenceScreen()).isNotNull();
    assertThat(fragment.hasOptionsMenu()).isTrue();
  }
}
