package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RocketFamilies implements Parcelable
{

    @SerializedName("RocketFamilies")
    @Expose
    private List<RocketFamily> rocketFamilies = new ArrayList<>();
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    public final static Creator<RocketFamilies> CREATOR = new Creator<RocketFamilies>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RocketFamilies createFromParcel(Parcel in) {
            return new RocketFamilies(in);
        }

        public RocketFamilies[] newArray(int size) {
            return (new RocketFamilies[size]);
        }

    }
            ;

    protected RocketFamilies(Parcel in) {
        in.readList(this.rocketFamilies, (RocketFamily.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.offset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public RocketFamilies() {
    }

    /**
     *
     * @param total
     * @param count
     * @param rocketFamilies
     * @param offset
     */
    public RocketFamilies(List<RocketFamily> rocketFamilies, Integer total, Integer count, Integer offset) {
        super();
        this.rocketFamilies = rocketFamilies;
        this.total = total;
        this.count = count;
        this.offset = offset;
    }

    public List<RocketFamily> getRocketFamilies() {
        return rocketFamilies;
    }

    public void setRocketFamilies(List<RocketFamily> rocketFamilies) {
        this.rocketFamilies = rocketFamilies;
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
        dest.writeList(rocketFamilies);
        dest.writeValue(total);
        dest.writeValue(count);
        dest.writeValue(offset);
    }

    public int describeContents() {
        return 0;
    }

}
