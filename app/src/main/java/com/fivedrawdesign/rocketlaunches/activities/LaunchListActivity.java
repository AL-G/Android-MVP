package com.fivedrawdesign.rocketlaunches.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fivedrawdesign.rocketlaunches.R;
import com.fivedrawdesign.rocketlaunches.details_screen.LaunchDetailsContract;
import com.fivedrawdesign.rocketlaunches.details_screen.LaunchDetailsViewFragment;
import com.fivedrawdesign.rocketlaunches.list_screen.LaunchListContract;
import com.fivedrawdesign.rocketlaunches.list_screen.LaunchListPresenter;
import com.fivedrawdesign.rocketlaunches.list_screen.LaunchListViewFragment;
import com.fivedrawdesign.rocketlaunches.utils.HelperUtils;

import static com.fivedrawdesign.rocketlaunches.Constants.LAUNCH_DETAILS_FRAGMENT_TAG;
import static com.fivedrawdesign.rocketlaunches.Constants.LAUNCH_LIST_FRAGMENT_TAG;

/**
 * Activity to display launches
 */
public class LaunchListActivity extends AppCompatActivity {

    private LaunchListContract.Presenter presenter;

    private LaunchDetailsContract.Presenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_list_activity);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        // find the retained fragment on activity restarts
        LaunchListViewFragment viewFragment = (LaunchListViewFragment)
                getSupportFragmentManager().findFragmentByTag(LAUNCH_LIST_FRAGMENT_TAG);

        // create the fragment and data the first time
        if (viewFragment == null) {
            viewFragment = new LaunchListViewFragment();
            HelperUtils.addFragmentToActivity(
                    getSupportFragmentManager(), viewFragment, R.id.launches_frame,
                    LAUNCH_LIST_FRAGMENT_TAG);
            getSupportFragmentManager().executePendingTransactions();

        }

        // create the presenter and (re)attach view
        presenter = new LaunchListPresenter(viewFragment);

        // find the retained fragment on activity restarts
        LaunchDetailsViewFragment detailsViewFragment = (LaunchDetailsViewFragment)
                getSupportFragmentManager().findFragmentByTag(LAUNCH_DETAILS_FRAGMENT_TAG);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            reinitializeTitleBar();
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            onBackPressed();
        }
        return true;
    }

    private void reinitializeTitleBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle(R.string.activity_launch_list);
        }
    }

}

