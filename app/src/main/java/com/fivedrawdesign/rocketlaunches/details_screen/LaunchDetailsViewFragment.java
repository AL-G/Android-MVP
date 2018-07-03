package com.fivedrawdesign.rocketlaunches.details_screen;

import android.os.Bundle;
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
import com.fivedrawdesign.rocketlaunches.data.entities.Launch;
import com.fivedrawdesign.rocketlaunches.data.entities.Pad;
import com.fivedrawdesign.rocketlaunches.utils.BaseLoadingFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fivedrawdesign.rocketlaunches.utils.HelperUtils.isValidLink;

/**
 * Launch details view
 */
public class LaunchDetailsViewFragment extends BaseLoadingFragment implements LaunchDetailsContract.View {

    private LaunchDetailsContract.Presenter presenter;

    @BindView(R.id.rocket_name)
    TextView rocketName;
    @BindView(R.id.rocket_configuration)
    TextView rocketConf;
    @BindView(R.id.rocket_family_name)
    TextView rocketFamilyName;
    @BindView(R.id.rocket_wiki_url)
    TextView rocketWikiUrl;
    @BindView(R.id.rocket_image)
    ImageView rocketImage;
    @BindView(R.id.launch_pads)
    LinearLayout launchPads;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
        ActionBar actionBar = ((AppCompatActivity) getContext()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.activity_launch_details);
        }

        rocketName.setText(getString(R.string.rocket_name, launch.getRocket().getName()));
        rocketConf.setText(getString(R.string.rocket_conf, launch.getRocket().getConfiguration()));
        //rocketFamilyName.setText(getString(R.string.rocket_family, launch.getRocket().getFamilyname()));

        if (isValidLink(launch.getRocket().getWikiURL())) {
            rocketWikiUrl.setText(Html.fromHtml(getString(R.string.rocket_wiki, launch.getRocket().getWikiURL())));
            rocketWikiUrl.setVisibility(View.VISIBLE);
        } else {
            rocketWikiUrl.setVisibility(View.GONE);
        }

        Picasso.with(getContext())
                .load(launch.getRocket().getImageURL())
                .placeholder(R.drawable.ic_rocket_grey_96dp)
                .into(rocketImage);

        for (Pad pad : launch.getLocation().getPads()) {

            View view = getLayoutInflater().inflate(R.layout.launch_pad_item, launchPads);

            ((TextView) view.findViewById(R.id.pad_name)).setText(getString(R.string.pad_name, pad.getName()));

//            TextView infoUrl = view.findViewById(R.id.pad_info_url);
//            if (isValidLink(pad.getInfoURL())) {
//                infoUrl.setText(Html.fromHtml(getString(R.string.pad_info, pad.getInfoURL())));
//                infoUrl.setVisibility(View.VISIBLE);
//            } else {
//                infoUrl.setVisibility(View.GONE);
//            }

            TextView wikiUrl = view.findViewById(R.id.pad_wiki_url);
            if (isValidLink(pad.getWikiURL())) {
                wikiUrl.setText(Html.fromHtml(getString(R.string.pad_wiki, pad.getWikiURL())));
                wikiUrl.setVisibility(View.VISIBLE);
            } else {
                wikiUrl.setVisibility(View.GONE);
            }

            TextView mapUrl = view.findViewById(R.id.pad_map_url);
            if (isValidLink(pad.getMapURL())) {
                mapUrl.setText(Html.fromHtml(getString(R.string.pad_map, pad.getMapURL())));
                mapUrl.setVisibility(View.VISIBLE);
            } else {
                mapUrl.setVisibility(View.GONE);
            }

            ((TextView) view.findViewById(R.id.pad_latitude)).setText(getString(R.string.pad_lat, String.valueOf(pad.getLatitude())));
            ((TextView) view.findViewById(R.id.pad_longitude)).setText(getString(R.string.pad_long, String.valueOf(pad.getLongitude())));

        }

        hideLoading();

    }

    @Override
    public LaunchDetailsContract.Presenter getPresenter() {
        return presenter;
    }

}
