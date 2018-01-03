package com.himumsaiddad.rocketlaunches.presenters;

import android.support.annotation.NonNull;

import com.himumsaiddad.rocketlaunches.data.model.Launch;
import com.himumsaiddad.rocketlaunches.contracts.LaunchDetailsContract;
import com.himumsaiddad.rocketlaunches.views.LaunchDetailsViewFragment;

/**
 * Presenter for the launch details activity
 */
public class LaunchDetailsPresenter implements LaunchDetailsContract.Presenter {

    private final LaunchDetailsContract.View view;

    public LaunchDetailsPresenter(@NonNull LaunchDetailsViewFragment view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayLaunch(Launch launch) {
        if(launch == null){
            view.displayEmpty();
        } else {
            view.displayLoading();
            view.displayLaunchDetails(launch);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
    }

}
