package com.fivedrawdesign.rocketlaunches.details_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fivedrawdesign.rocketlaunches.R;
import com.fivedrawdesign.rocketlaunches.data.model.Launch;
import com.fivedrawdesign.rocketlaunches.utils.BaseLoadingFragment;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fivedrawdesign.rocketlaunches.utils.HelperUtils.isValidLink;

/**
 * Launch details view
 */
public class LaunchDetailsViewFragment extends BaseLoadingFragment implements LaunchDetailsContract.View {

    private LaunchDetailsContract.Presenter presenter;

    @BindView(R.id.launch_details_name)
    TextView launchDetailsName;

    @BindView(R.id.launchDetailsCoordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.launch_details_loading_layout)
    View loadingView;
    @BindView(R.id.launch_details_empty_layout)
    View emptyView;
    @BindView(R.id.launch_details_content_layout)
    ScrollView contentView;

    private View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            root = inflater.inflate(R.layout.launch_details_fragment, container, false);
        }

        super.coordinatorLayout = root.findViewById(R.id.launchDetailsCoordinatorLayout);
        super.loadingView = root.findViewById(R.id.launch_details_loading_layout);
        super.emptyView = root.findViewById(R.id.launch_details_empty_layout);
        super.contentView = root.findViewById(R.id.launch_details_content_layout);

        ButterKnife.bind(this, root);

        setRetainInstance(true);

        return root;
    }

    @Override
    public void setPresenter(LaunchDetailsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayLaunchDetails(Launch launch) {

        // set the actionbar title
        ActionBar actionBar = ((AppCompatActivity) Objects.requireNonNull(getContext())).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.activity_launch_details);
        }

        launchDetailsName.setText(launch.getName());

        hideLoading();

    }

    @Override
    public LaunchDetailsContract.Presenter getPresenter() {
        return presenter;
    }

}
