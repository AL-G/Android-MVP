package com.fivedrawdesign.rocketlaunches.data.source.di;

import com.fivedrawdesign.rocketlaunches.data.source.LaunchesRepository;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {LaunchesRepositoryModule.class})
public interface LaunchesRepositoryComponent {
    LaunchesRepository provideLaunchesRepository();
}
