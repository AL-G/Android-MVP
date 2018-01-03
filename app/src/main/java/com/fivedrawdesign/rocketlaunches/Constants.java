package com.fivedrawdesign.rocketlaunches;

/**
 * Application constants
 */
 public final class Constants {

    // API base path
    static final String BASE_URL = " https://launchlibrary.net/1.3/";
    // API request cache size in bytes
    static final int CACHE_SIZE = 10 * 1024 * 1024; // 10MB
    // Cached API request maximum age
    static final int API_CACHE_MAX_AGE_SECONDS = 60;

    // Number of launches to retrieve
    public static final String LAUNCH_QUANTITY = "50";

    // Fragment tags
    public static final String LAUNCH_LIST_FRAGMENT_TAG = "launch_list_fragment";
    public static final String LAUNCH_DETAILS_FRAGMENT_TAG = "launch_details_fragment";

}
