package com.fivedrawdesign.rocketlaunches.data.repository.di;

import com.fivedrawdesign.rocketlaunches.data.repository.Repository;
import com.fivedrawdesign.rocketlaunches.data.repository.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    Repository provideRepository(){
        return new Repository(new RemoteDataSource());
    }

    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource() {
        return new RemoteDataSource();
    }

}
