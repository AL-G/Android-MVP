package com.himumsaiddad.rocketlaunches.contracts;

import com.himumsaiddad.rocketlaunches.presenters.BasePresenter;
import com.himumsaiddad.rocketlaunches.views.BaseView;
import com.himumsaiddad.rocketlaunches.data.model.Launch;

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
