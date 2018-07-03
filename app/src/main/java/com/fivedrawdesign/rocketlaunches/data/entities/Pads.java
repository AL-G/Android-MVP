package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pads implements Parcelable
{

    @SerializedName("pads")
    @Expose
    private List<Pad> pads = new ArrayList<>();
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    public final static Creator<Pads> CREATOR = new Creator<Pads>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Pads createFromParcel(Parcel in) {
            return new Pads(in);
        }

        public Pads[] newArray(int size) {
            return (new Pads[size]);
        }

    }
            ;

    protected Pads(Parcel in) {
        in.readList(this.pads, (Pad.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.offset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Pads() {
    }

    /**
     *
     * @param total
     * @param count
     * @param pads
     * @param offset
     */
    public Pads(List<Pad> pads, Integer total, Integer count, Integer offset) {
        super();
        this.pads = pads;
        this.total = total;
        this.count = count;
        this.offset = offset;
    }

    public List<Pad> getPads() {
        return pads;
    }

    public void setPads(List<Pad> pads) {
        this.pads = pads;
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
        dest.writeList(pads);
        dest.writeValue(total);
        dest.writeValue(count);
        dest.writeValue(offset);
    }

    public int describeContents() {
        return 0;
    }

}
