package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RocketFamily implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = new ArrayList<>();
    @SerializedName("changed")
    @Expose
    private String changed;
    public final static Creator<RocketFamily> CREATOR = new Creator<RocketFamily>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RocketFamily createFromParcel(Parcel in) {
            return new RocketFamily(in);
        }

        public RocketFamily[] newArray(int size) {
            return (new RocketFamily[size]);
        }

    }
            ;

    protected RocketFamily(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.agencies, (Agency.class.getClassLoader()));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public RocketFamily() {
    }

    /**
     *
     * @param id
     * @param name
     * @param agencies
     * @param changed
     */
    public RocketFamily(Integer id, String name, List<Agency> agencies, String changed) {
        super();
        this.id = id;
        this.name = name;
        this.agencies = agencies;
        this.changed = changed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeList(agencies);
        dest.writeValue(changed);
    }

    public int describeContents() {
        return 0;
    }

}
