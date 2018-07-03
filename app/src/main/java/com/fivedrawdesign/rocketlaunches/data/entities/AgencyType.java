package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgencyType implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("changed")
    @Expose
    private String changed;
    public final static Creator<AgencyType> CREATOR = new Creator<AgencyType>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AgencyType createFromParcel(Parcel in) {
            return new AgencyType(in);
        }

        public AgencyType[] newArray(int size) {
            return (new AgencyType[size]);
        }

    };

    protected AgencyType(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public AgencyType() {
    }

    /**
     * @param id
     * @param description
     * @param name
     * @param changed
     */
    public AgencyType(Integer id, String name, String description, String changed) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        dest.writeValue(description);
        dest.writeValue(changed);
    }

    public int describeContents() {
        return 0;
    }

}
