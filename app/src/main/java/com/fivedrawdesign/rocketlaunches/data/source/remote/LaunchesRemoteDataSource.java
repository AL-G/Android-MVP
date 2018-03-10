package com.fivedrawdesign.rocketlaunches.data.source.remote;

import android.support.annotation.NonNull;

import com.fivedrawdesign.rocketlaunches.data.entities.Launches;
import com.fivedrawdesign.rocketlaunches.data.source.LaunchesDataSource;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.fivedrawdesign.rocketlaunches.Constants.BASE_URL;
import static com.fivedrawdesign.rocketlaunches.Constants.LAUNCH_QUANTITY;


public class LaunchesRemoteDataSource implements LaunchesDataSource {

    private static Retrofit retrofit;

    @Inject
    public LaunchesRemoteDataSource() {
        retrofit = getRestAdapter();
    }

    @Override
    public void getLaunches(final @NonNull LoadLaunchesCallback callback) {

        getRestAdapter().create(LaunchLibraryApi.class).getLaunches(LAUNCH_QUANTITY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Launches>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(@io.reactivex.annotations.NonNull Launches result) {
                        callback.onLaunchesLoaded(result.getLaunches());
                    }

                    @Override
                    public void onError(Throwable e) {

                        //handleError(e);
                        callback.onDataNotAvailable();
                    }

                });
    }

    /**
     * Get Retrofit object for Api requests
     *
     * @return Retrofit
     */
    public static Retrofit getRestAdapter() {

        if (retrofit == null) {


            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();

        }

        return retrofit;
    }

    /**
     * Return a OkHttp client
     *
     * @return OkHttpClient
     */
    private static OkHttpClient getOkHttpClient() {
        // use custom OkHttp client to
        return new OkHttpClient.Builder().build();

    }
}
