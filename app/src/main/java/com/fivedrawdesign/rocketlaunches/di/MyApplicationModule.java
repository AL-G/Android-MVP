package com.fivedrawdesign.rocketlaunches.di;

import com.fivedrawdesign.rocketlaunches.activities.LaunchListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MyApplicationModule {

    @ContributesAndroidInjector
    abstract LaunchListActivity contributeActivityInjector();

}
