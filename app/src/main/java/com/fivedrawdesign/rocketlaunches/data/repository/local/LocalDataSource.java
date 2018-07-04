package com.fivedrawdesign.rocketlaunches.data.repository.local;

import com.fivedrawdesign.rocketlaunches.data.database.LaunchesDao;
import com.fivedrawdesign.rocketlaunches.data.model.Launch;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class LocalDataSource {

    private LaunchesDao launchesDao;

    @Inject
    public LocalDataSource(LaunchesDao launchesDao) {
        this.launchesDao = launchesDao;
    }

    public Flowable<List<Launch>> getLaunches(boolean forceRemote) {
        return launchesDao.getAllLaunches();
    }

    public void clearData() {
        launchesDao.deleteAll();
    }

}
