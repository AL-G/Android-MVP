package com.fivedrawdesign.rocketlaunches.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.fivedrawdesign.rocketlaunches.data.model.Launch;
import com.fivedrawdesign.rocketlaunches.data.repository.Config;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface LaunchesDao {

    @Query("SELECT * FROM " + Config.LAUNCH_TABLE_NAME)
    Flowable<List<Launch>> getAllLaunches();

    @Query("SELECT * FROM " + Config.LAUNCH_TABLE_NAME + " WHERE id == :id")
    Flowable<Launch> getLaunchById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Launch launch);

    @Query("DELETE FROM " + Config.LAUNCH_TABLE_NAME)
    void deleteAll();

}
