package com.himumsaiddad.rocketlaunches;

import android.app.Application;
import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.himumsaiddad.rocketlaunches.Constants.API_CACHE_MAX_AGE_SECONDS;
import static com.himumsaiddad.rocketlaunches.Constants.BASE_URL;
import static com.himumsaiddad.rocketlaunches.Constants.CACHE_SIZE;

public class App extends Application {

    private static Retrofit retrofit;
    private static Cache cache_directory;

    @Override
    public void onCreate() {
        super.onCreate();
        cache_directory = new Cache(getApplicationContext().getCacheDir(), CACHE_SIZE);
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
     * Return a OkHttp client that will cache all requents for duration and in location set in
     * Constants
     *
     * @return OkHttpClient
     */
    private static OkHttpClient getOkHttpClient(){
        // use custom OkHttp client to
        return new OkHttpClient
                .Builder()
                .cache(cache_directory)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request request = chain.request();
                        request = request.newBuilder().header("Cache-Control", "public, max-age=" + API_CACHE_MAX_AGE_SECONDS).build();
                        return chain.proceed(request);
                    }
                })
                .build();

    }
}
