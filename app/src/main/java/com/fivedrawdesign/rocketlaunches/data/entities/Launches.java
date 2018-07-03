
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Launches implements Parcelable
{

    @SerializedName("launches")
    @Expose
    private List<Launch> launches = new ArrayList<>();
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("count")
    @Expose
    private Integer count;
    public final static Creator<Launches> CREATOR = new Creator<Launches>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Launches createFromParcel(Parcel in) {
            return new Launches(in);
        }

        public Launches[] newArray(int size) {
            return (new Launches[size]);
        }

    }
            ;

    protected Launches(Parcel in) {
        in.readList(this.launches, (Launch.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.offset = ((String) in.readValue((String.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Launches() {
    }

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

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(launches);
        dest.writeValue(total);
        dest.writeValue(offset);
        dest.writeValue(count);
    }

    public int describeContents() {
        return 0;
    }

}