package com.fivedrawdesign.rocketlaunches.details_screen;

import com.fivedrawdesign.rocketlaunches.data.model.Launch;
import com.fivedrawdesign.rocketlaunches.utils.BasePresenter;
import com.fivedrawdesign.rocketlaunches.utils.BaseView;

/**
 * This specifies the contract between the view (LaunchDetailsViewfragment) and the presenter
 * (LaunchDetailsPresenter)
 */
public interface LaunchDetailsContract {

    interface View extends BaseView<Presenter> {

        /**
         * Create the view for launch
         * @param launch Launch object
         */
        void displayLaunchDetails(Launch launch);

        /**
         * Get presenter
         * @return LaunchDetailsContract.Presenter
         */
        LaunchDetailsContract.Presenter getPresenter();

        /**
         * Displays loading view and hides other views
         */
        void displayLoading();

        /**
         * Displays a view showing no data message and hides other views
         */
        void displayEmpty();

    }

    interface Presenter extends BasePresenter {

        /**
         * Pass the launch details to view to display
         * @param launch Launch object
         */
        void displayLaunch(Launch launch);

    }
}
