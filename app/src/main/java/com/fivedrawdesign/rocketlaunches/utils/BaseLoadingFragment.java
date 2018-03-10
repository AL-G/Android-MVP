package com.fivedrawdesign.rocketlaunches.utils;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Base fragment with methods to display Snackbar messages, loading indicator or empty state.
 * Inheriting fragments should inflate a view with a root Coordinator layout, content, loading and
 * empty views.
 * Notes: displayEmpty, displayLoading, hideLoading and displayMessage should be declared in view
 * interfaces.
 */
public class BaseLoadingFragment extends Fragment {

    protected CoordinatorLayout coordinatorLayout;
    protected View loadingView;
    protected View emptyView;
    protected View contentView;

    public void displayEmpty() {
        loadingView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }

    public void displayLoading() {
        loadingView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        contentView.setVisibility(View.GONE);
    }

    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
    }

    public void displayMessage(String message) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

}
