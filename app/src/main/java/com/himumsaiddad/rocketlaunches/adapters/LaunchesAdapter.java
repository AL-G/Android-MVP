package com.himumsaiddad.rocketlaunches.adapters;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.himumsaiddad.rocketlaunches.HelperUtils;
import com.himumsaiddad.rocketlaunches.R;
import com.himumsaiddad.rocketlaunches.data.model.Launch;
import com.himumsaiddad.rocketlaunches.presenters.LaunchDetailsPresenter;
import com.himumsaiddad.rocketlaunches.views.LaunchDetailsViewFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.himumsaiddad.rocketlaunches.Constants.LAUNCH_DETAILS_FRAGMENT_TAG;

/**
 * Adapter for launches RecyclerView
 */
public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.MyViewHolder> {

    private Context context;
    private List<Launch> launches;

    /**
     * Launch item ViewHolder
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.launch_container)
        LinearLayout launchContainer;
        @BindView(R.id.launch_name)
        TextView name;
        @BindView(R.id.launch_status)
        TextView status;
        @BindView(R.id.launch_window_start)
        TextView launchWindow;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * LaunchesAdapter constructor
     */
    public LaunchesAdapter(Context context) {

        this.context = context;
        launches = new ArrayList<>();

    }

    public void setData(List<Launch> launches) {
        this.launches = launches;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.launch_recyclerview_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.launchContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LaunchDetailsViewFragment viewFragment = new LaunchDetailsViewFragment();

                HelperUtils.addFragmentToBackstack(
                        ((AppCompatActivity)context).getSupportFragmentManager(), viewFragment,
                        R.id.launches_frame, LAUNCH_DETAILS_FRAGMENT_TAG);

                ((AppCompatActivity)context).getSupportFragmentManager().executePendingTransactions();

                new LaunchDetailsPresenter(viewFragment);

                viewFragment.displayLaunchDetails(launches.get(holder.getAdapterPosition()));

            }
        });

        Launch launch = launches.get(holder.getAdapterPosition());

        holder.name.setText(launch.getName());

        // set the launch status 1 Green, 2 Red, 3 Success, 4 Failed
        switch (launch.getStatus()) {
            case 1:
                holder.status.setText(context.getString(R.string.launch_status, context.getString(R.string.launch_status_green)));
                break;
            case 2:
                holder.status.setText(context.getString(R.string.launch_status, context.getString(R.string.launch_status_red)));
                break;
            case 3:
                holder.status.setText(context.getString(R.string.launch_status, context.getString(R.string.launch_status_success)));
                break;
            case 4:
                holder.status.setText(context.getString(R.string.launch_status, context.getString(R.string.launch_status_failed)));
                break;
        }

        // set the launch window
        holder.launchWindow.setText(context.getString(R.string.launch_window, launch.getWindowstart(), launch.getWindowend()));

    }

    @Override
    public int getItemCount() {
        return launches.size();
    }

}

