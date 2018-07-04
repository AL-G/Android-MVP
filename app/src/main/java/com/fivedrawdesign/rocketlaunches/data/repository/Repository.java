package com.fivedrawdesign.rocketlaunches.data.repository;

import android.support.annotation.NonNull;

import com.fivedrawdesign.rocketlaunches.data.model.Launch;
import com.fivedrawdesign.rocketlaunches.data.repository.remote.RemoteDataSource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository implements DataSourceIntf {

    public RemoteDataSource mLaunchesRemoteDataSource;

    public List<Launch> mCachedLaunches;

    @Inject
    public Repository(RemoteDataSource s) {
        mCachedLaunches = new ArrayList<Launch>();
        mLaunchesRemoteDataSource = new RemoteDataSource();
    }

    public List<Launch> getCachedLaunches() {
        return mCachedLaunches;
    }

    /**
     * Gets launches from remote data source
     * <p>
     * Note: {@link LoadLaunchesCallback#onDataNotAvailable()} is fired if all data sources fail to
     * get the data.
     */
    @Override
    public void getLaunches(@NonNull final LoadLaunchesCallback callback) {

        mLaunchesRemoteDataSource.getLaunches(new LoadLaunchesCallback() {
            @Override
            public void onLaunchesLoaded(List<Launch> launches) {
                mCachedLaunches.clear();
                mCachedLaunches.addAll(launches);
                callback.onLaunchesLoaded(launches);
            }

            @Override
            public void onDataNotAvailable() {


            }
        });
    }

}
