
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Launches implements Serializable, Parcelable {

    @SerializedName("launches")
    @Expose
    private List<Launch> launches = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("count")
    @Expose
    private Integer count;
    private final static long serialVersionUID = 4330453745354054745L;

    public List<Launch> getLaunches() {
        return launches;
    }

    public void setLaunches(List<Launch> launches) {
        this.launches = launches;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.launches);
        dest.writeValue(this.total);
        dest.writeValue(this.offset);
        dest.writeValue(this.count);
    }

    public Launches() {
    }

    protected Launches(Parcel in) {
        this.launches = in.createTypedArrayList(Launch.CREATOR);
        this.total = (Integer) in.readValue(Integer.class.getClassLoader());
        this.offset = (Integer) in.readValue(Integer.class.getClassLoader());
        this.count = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Launches> CREATOR = new Parcelable.Creator<Launches>() {
        @Override
        public Launches createFromParcel(Parcel source) {
            return new Launches(source);
        }

        @Override
        public Launches[] newArray(int size) {
            return new Launches[size];
        }
    };

}
