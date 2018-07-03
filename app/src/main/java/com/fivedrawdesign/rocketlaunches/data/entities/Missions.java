package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Missions implements Parcelable
{

    @SerializedName("missions")
    @Expose
    private List<Mission> missions = new ArrayList<>();
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    public final static Creator<Missions> CREATOR = new Creator<Missions>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Missions createFromParcel(Parcel in) {
            return new Missions(in);
        }

        public Missions[] newArray(int size) {
            return (new Missions[size]);
        }

    }
            ;

    protected Missions(Parcel in) {
        in.readList(this.missions, (Mission.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.offset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Missions() {
    }

    /**
     *
     * @param total
     * @param count
     * @param missions
     * @param offset
     */
    public Missions(List<Mission> missions, Integer total, Integer count, Integer offset) {
        super();
        this.missions = missions;
        this.total = total;
        this.count = count;
        this.offset = offset;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(missions);
        dest.writeValue(total);
        dest.writeValue(count);
        dest.writeValue(offset);
    }

    public int describeContents() {
        return 0;
    }

}
