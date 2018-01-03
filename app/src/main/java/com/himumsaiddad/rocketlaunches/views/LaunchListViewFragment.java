package com.himumsaiddad.rocketlaunches.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.himumsaiddad.rocketlaunches.R;
import com.himumsaiddad.rocketlaunches.contracts.LaunchListContract;
import com.himumsaiddad.rocketlaunches.data.model.Launches;
import com.himumsaiddad.rocketlaunches.adapters.LaunchesAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Launch list view
 */
public class LaunchListViewFragment extends BaseLoadingFragment implements LaunchListContract.View {

    private LaunchListContract.Presenter presenter;

    @BindView(R.id.launch_list_recyclerview)
    RecyclerView recyclerView;

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
    public void displayLaunches(Launches result) {
        if (result.getLaunches().size() > 0) {
            LaunchesAdapter mLaunchesAdapter = new LaunchesAdapter(getContext());
            recyclerView.setAdapter(mLaunchesAdapter);
            mLaunchesAdapter.setData(result.getLaunches());
            mLaunchesAdapter.notifyDataSetChanged();
            hideLoading();
        } else {
            displayEmpty();
        }
    }

    @Override
    public void setPresenter(LaunchListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public LaunchListContract.Presenter getPresenter(){
        return presenter;
    }
}
