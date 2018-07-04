package com.fivedrawdesign.rocketlaunches.list_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fivedrawdesign.rocketlaunches.R;
import com.fivedrawdesign.rocketlaunches.data.model.Launch;
import com.fivedrawdesign.rocketlaunches.details_screen.LaunchDetailsPresenter;
import com.fivedrawdesign.rocketlaunches.details_screen.LaunchDetailsViewFragment;
import com.fivedrawdesign.rocketlaunches.utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fivedrawdesign.rocketlaunches.data.repository.Config.LAUNCH_DETAILS_FRAGMENT_TAG;

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

        @BindView(R.id.launch_list_item_cardview)
        LinearLayout launchListCardView;
        @BindView(R.id.launch_list_name)
        TextView name;
        @BindView(R.id.launch_list_date_and_time)
        TextView launchDate;

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

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.launch_recyclerview_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.launchListCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LaunchDetailsViewFragment viewFragment = new LaunchDetailsViewFragment();

                HelperUtils.addFragmentToBackstack(
                        ((AppCompatActivity) context).getSupportFragmentManager(), viewFragment,
                        R.id.launches_frame, LAUNCH_DETAILS_FRAGMENT_TAG);

                ((AppCompatActivity) context).getSupportFragmentManager().executePendingTransactions();

                new LaunchDetailsPresenter(viewFragment);

                viewFragment.displayLaunchDetails(launches.get(holder.getAdapterPosition()));

            }
        });

        Launch launch = launches.get(holder.getAdapterPosition());

        // set the launch name
        holder.name.setText(launch.getName());

        // set the launch date
        holder.launchDate.setText(context.getString(R.string.launch_date, launch.getNet()));

    }

    @Override
    public int getItemCount() {
        return launches.size();
    }

}