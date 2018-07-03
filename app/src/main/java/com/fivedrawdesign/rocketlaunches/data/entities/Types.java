package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

// Types used for MissionTypes and AgencyTypes
public class Types implements Parcelable
{

    @SerializedName("types")
    @Expose
    private List<MissionType> types = new ArrayList<>();
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    public final static Creator<Types> CREATOR = new Creator<Types>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Types createFromParcel(Parcel in) {
            return new Types(in);
        }

        public Types[] newArray(int size) {
            return (new Types[size]);
        }

    }
            ;

    protected Types(Parcel in) {
        in.readList(this.types, (MissionType.class.getClassLoader()));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.offset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Types() {
    }

    /**
     *
     * @param total
     * @param count
     * @param offset
     * @param types
     */
    public Types(List<MissionType> types, Integer total, Integer count, Integer offset) {
        super();
        this.types = types;
        this.total = total;
        this.count = count;
        this.offset = offset;
    }

    public List<MissionType> getTypes() {
        return types;
    }

    public void setTypes(List<MissionType> types) {
        this.types = types;
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
        dest.writeList(types);
        dest.writeValue(total);
        dest.writeValue(count);
        dest.writeValue(offset);
    }

    public int describeContents() {
        return 0;
    }

}