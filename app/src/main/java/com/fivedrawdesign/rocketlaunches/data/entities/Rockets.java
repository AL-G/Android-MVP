package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Rockets implements Parcelable
{

    @SerializedName("rockets")
    @Expose
    private List<Rocket> rockets = new ArrayList<>();
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    public final static Creator<Rockets> CREATOR = new Creator<Rockets>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Rockets createFromParcel(Parcel in) {
            return new Rockets(in);
        }

        public Rockets[] newArray(int size) {
            return (new Rockets[size]);
        }

    }
            ;

    protected Rockets(Parcel in) {
        in.readList(this.rockets, (Rocket.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.offset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Rockets() {
    }

    /**
     *
     * @param total
     * @param count
     * @param rockets
     * @param offset
     */
    public Rockets(List<Rocket> rockets, Integer total, Integer count, Integer offset) {
        super();
        this.rockets = rockets;
        this.total = total;
        this.count = count;
        this.offset = offset;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public void setRockets(List<Rocket> rockets) {
        this.rockets = rockets;
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
        dest.writeList(rockets);
        dest.writeValue(total);
        dest.writeValue(count);
        dest.writeValue(offset);
    }

    public int describeContents() {
        return 0;
    }

}
