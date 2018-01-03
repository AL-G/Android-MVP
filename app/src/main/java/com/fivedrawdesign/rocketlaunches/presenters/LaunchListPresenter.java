package com.fivedrawdesign.rocketlaunches.presenters;

import android.support.annotation.NonNull;

import com.fivedrawdesign.rocketlaunches.App;
import com.fivedrawdesign.rocketlaunches.data.LaunchLibraryApi;
import com.fivedrawdesign.rocketlaunches.data.model.Launches;
import com.fivedrawdesign.rocketlaunches.contracts.LaunchListContract;
import com.fivedrawdesign.rocketlaunches.views.LaunchListViewFragment;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.fivedrawdesign.rocketlaunches.Constants.LAUNCH_QUANTITY;

/**
 * Presenter for the launch list activity
 */
public class LaunchListPresenter implements LaunchListContract.Presenter {

    private final LaunchListContract.View view;

    public LaunchListPresenter(@NonNull LaunchListViewFragment view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void getLaunches() {

        view.displayLoading();

        App.getRestAdapter().create(LaunchLibraryApi.class).getLaunches(LAUNCH_QUANTITY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Launches>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(@io.reactivex.annotations.NonNull Launches result) {
                        view.displayLaunches(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        handleError(e);
                    }

                });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleError(Throwable throwable) {
        view.displayEmpty();
        view.displayMessage(throwable.getLocalizedMessage());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        getLaunches();
    }

}
