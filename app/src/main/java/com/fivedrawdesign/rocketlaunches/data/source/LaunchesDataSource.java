package com.fivedrawdesign.rocketlaunches.data.source;

import android.support.annotation.NonNull;

import com.fivedrawdesign.rocketlaunches.data.entities.Launch;

import java.util.List;

public interface LaunchesDataSource {

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
