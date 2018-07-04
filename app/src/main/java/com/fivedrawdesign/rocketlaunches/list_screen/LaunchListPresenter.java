package com.fivedrawdesign.rocketlaunches.list_screen;

import android.support.annotation.NonNull;

import com.fivedrawdesign.rocketlaunches.data.model.Launch;
import com.fivedrawdesign.rocketlaunches.data.repository.DataSourceIntf;
import com.fivedrawdesign.rocketlaunches.data.repository.Repository;
import com.fivedrawdesign.rocketlaunches.data.repository.di.DaggerRepositoryComponent;
import com.fivedrawdesign.rocketlaunches.data.repository.di.RepositoryComponent;
import com.fivedrawdesign.rocketlaunches.data.repository.di.RepositoryModule;

import java.util.List;

import javax.inject.Inject;

/**
 * Presenter for the launch list activity
 */
public class LaunchListPresenter implements LaunchListContract.Presenter {

    @Inject
    public Repository mLaunchesRepository;

    private final LaunchListContract.View view;

    public LaunchListPresenter(@NonNull LaunchListViewFragment view) {

        RepositoryComponent component = DaggerRepositoryComponent.builder().repositoryModule(new RepositoryModule()).build();
        mLaunchesRepository = component.provideRepository();

        this.view = view;
        this.view.setPresenter(this);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getLaunches(DataSourceIntf.LoadLaunchesCallback callback) {

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

        mLaunchesRepository.getLaunches(new DataSourceIntf.LoadLaunchesCallback() {
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
