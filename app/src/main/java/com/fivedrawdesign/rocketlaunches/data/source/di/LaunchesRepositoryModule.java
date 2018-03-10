package com.fivedrawdesign.rocketlaunches.data.source.di;

import com.fivedrawdesign.rocketlaunches.data.source.LaunchesRepository;
import com.fivedrawdesign.rocketlaunches.data.source.remote.LaunchesRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LaunchesRepositoryModule {

    @Provides
    @Singleton
    LaunchesRepository provideLaunchesRepository(){
        return new LaunchesRepository(new LaunchesRemoteDataSource());
    }

    @Provides
    @Singleton
    LaunchesRemoteDataSource provideLaunchesRemoteDataSource() {
        return new LaunchesRemoteDataSource();
    }
}
