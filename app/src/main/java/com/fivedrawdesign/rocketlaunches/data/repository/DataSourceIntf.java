package com.fivedrawdesign.rocketlaunches.data.repository;

import android.support.annotation.NonNull;

import com.fivedrawdesign.rocketlaunches.data.model.Launch;

import java.util.List;

public interface DataSourceIntf {

    interface LoadLaunchesCallback {

        void onLaunchesLoaded(List<Launch> launches);

        void onDataNotAvailable();
    }

    interface GetLaunchCallback {

        void onLaunchLoaded(Launch launches);

        void onDataNotAvailable();
    }

    void getLaunches(@NonNull LoadLaunchesCallback callback);

}
