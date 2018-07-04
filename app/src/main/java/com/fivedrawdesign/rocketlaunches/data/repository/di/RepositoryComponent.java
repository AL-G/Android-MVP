package com.fivedrawdesign.rocketlaunches.data.repository.di;

import com.fivedrawdesign.rocketlaunches.data.repository.Repository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RepositoryModule.class})
public interface RepositoryComponent {
    Repository provideRepository();
}
