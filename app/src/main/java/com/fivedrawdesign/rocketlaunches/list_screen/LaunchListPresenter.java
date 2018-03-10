package com.fivedrawdesign.rocketlaunches.list_screen;

import android.support.annotation.NonNull;
import android.util.Log;

import com.fivedrawdesign.rocketlaunches.data.entities.Launch;
import com.fivedrawdesign.rocketlaunches.data.source.LaunchesDataSource;
import com.fivedrawdesign.rocketlaunches.data.source.LaunchesRepository;
import com.fivedrawdesign.rocketlaunches.data.source.di.DaggerLaunchesRepositoryComponent;
import com.fivedrawdesign.rocketlaunches.data.source.di.LaunchesRepositoryComponent;
import com.fivedrawdesign.rocketlaunches.data.source.di.LaunchesRepositoryModule;

import java.util.List;

import javax.inject.Inject;

/**
 * Presenter for the launch list activity
 */
public class LaunchListPresenter implements LaunchListContract.Presenter {

    @Inject
    public LaunchesRepository mLaunchesRepository;

    private final LaunchListContract.View view;

    public LaunchListPresenter(@NonNull LaunchListViewFragment view) {

        LaunchesRepositoryComponent component = DaggerLaunchesRepositoryComponent.builder().launchesRepositoryModule(new LaunchesRepositoryModule()).build();
        mLaunchesRepository = component.provideLaunchesRepository();
       // this.mLaunchesRepository = launchesRepository;
        this.view = view;
        this.view.setPresenter(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getLaunches(LaunchesDataSource.LoadLaunchesCallback callback) {

        mLaunchesRepository.getLaunches(callback);

    }

    @Override
    public List<Launch> getCachedLaunches() {
        return mLaunchesRepository.getCachedLaunches();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void handleError(Throwable throwable) {
        view.displayEmpty();
        view.displayMessage(throwable.getLocalizedMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {

        mLaunchesRepository.getLaunches(new LaunchesDataSource.LoadLaunchesCallback() {
            @Override
            public void onLaunchesLoaded(List<Launch> launches) {
                view.displayLaunches(launches);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

}
