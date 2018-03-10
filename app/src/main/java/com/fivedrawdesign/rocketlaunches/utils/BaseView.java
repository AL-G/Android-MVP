package com.fivedrawdesign.rocketlaunches.utils;

public interface BaseView<T> {

    /**
     * Set the presenter for this view
     */
    void setPresenter(T presenter);

    /**
     * Get the presenter for this view
     */
    T getPresenter();

}
