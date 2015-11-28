package com.fsstudio.template.fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fsstudio.template.App;
import com.fsstudio.template.R;
import com.fsstudio.template.dagger.components.DaggerMainComponent;
import com.fsstudio.template.dagger.modules.MainModule;
import com.fsstudio.template.rx.RxFragment;
import com.fsstudio.template.utils.DatabaseHelper;
import com.fsstudio.template.utils.HomeAsUp;
import com.hannesdorfmann.fragmentargs.annotation.Arg;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import dagger.Lazy;


public class MainFragment extends RxFragment {
    @Inject Lazy<Picasso>        picasso;
    @Inject Lazy<DatabaseHelper> databaseHelper;

    @Arg @IdRes int container;

    @InjectView(R.id.image) ImageView image;

    @Override public View onCreateView(LayoutInflater inflater,
                                       ViewGroup container,
                                       Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        activity().setTitle(R.string.app_name);
        setHasOptionsMenu(true);
        HomeAsUp.disable(activity());

        picasso.get()
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Android_robot.png/646px-Android_robot.png")
            .fit()
            .into(image);
    }

    private void inject() {
        DaggerMainComponent.builder()
            .appComponent(((App)getActivity().getApplication()).getDaggerComponent())
            .mainModule(new MainModule(this))
            .build()
            .inject(this);
    }

    @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_main, menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_settings:
        getFragmentManager().beginTransaction()
            .replace(container, new PrefsFragment())
            .addToBackStack(null)
            .commit();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
