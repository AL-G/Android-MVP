package com.fivedrawdesign.rocketlaunches.list_screen;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fivedrawdesign.rocketlaunches.R;
import com.fivedrawdesign.rocketlaunches.data.entities.Launch;
import com.fivedrawdesign.rocketlaunches.data.source.LaunchesDataSource;
import com.fivedrawdesign.rocketlaunches.list_screen.adapters.LaunchesAdapter;
import com.fivedrawdesign.rocketlaunches.utils.BaseLoadingFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Launch list view
 */
public class LaunchListViewFragment extends BaseLoadingFragment implements LaunchListContract.View, LaunchesDataSource.LoadLaunchesCallback {

    private LaunchListContract.Presenter presenter;

    @BindView(R.id.launch_list_recyclerview)
    RecyclerView recyclerView;

    LaunchesAdapter mLaunchesAdapter;

    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(savedInstanceState == null){
            root = inflater.inflate(R.layout.launch_list_fragment, container, false);
        }

        ButterKnife.bind(this, root);

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        setHasOptionsMenu(true);

        super.coordinatorLayout = root.findViewById(R.id.launchListCoordinatorLayout);
        super.loadingView = root.findViewById(R.id.launch_list_loading_layout);
        super.emptyView = root.findViewById(R.id.launch_list_empty_layout);
        super.contentView = recyclerView;

        return root;
    }

    @Override
    public void displayLaunches(List<Launch> results) {
        if (results.size() > 0) {
            mLaunchesAdapter = new LaunchesAdapter(getContext());
            recyclerView.setAdapter(mLaunchesAdapter);
            mLaunchesAdapter.setData(getPresenter().getCachedLaunches());
            mLaunchesAdapter.setData(results);
            mLaunchesAdapter.notifyDataSetChanged();
            hideLoading();
        } else {
            displayEmpty();
        }
    }

    @Override
    public void updateDisplay() {

        mLaunchesAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(LaunchListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public LaunchListContract.Presenter getPresenter(){
        return presenter;
    }


    @Override
    public void onLaunchesLoaded(List<Launch> launches) {
        mLaunchesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDataNotAvailable() {

    }
}
