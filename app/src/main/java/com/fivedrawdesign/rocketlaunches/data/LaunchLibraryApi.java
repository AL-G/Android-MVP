package com.fivedrawdesign.rocketlaunches.data;

import com.fivedrawdesign.rocketlaunches.data.model.Launches;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Retrofit Api interface for LaunchLibrary
 */
public interface LaunchLibraryApi {

    // Get the next {quantity} of launches
    @GET("launch/next/{number_of_launches}")
    Single<Launches> getLaunches(@Path("number_of_launches") String quantity);

}
