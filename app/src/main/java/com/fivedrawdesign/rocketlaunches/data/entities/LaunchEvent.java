package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchEvent implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("relativeTime")
    @Expose
    private Integer relativeTime;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("parentid")
    @Expose
    private Integer parentid;
    public final static Creator<LaunchEvent> CREATOR = new Creator<LaunchEvent>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LaunchEvent createFromParcel(Parcel in) {
            return new LaunchEvent(in);
        }

        public LaunchEvent[] newArray(int size) {
            return (new LaunchEvent[size]);
        }

    }
            ;

    protected LaunchEvent(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.relativeTime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.duration = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
        this.parentid = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public LaunchEvent() {
    }

    /**
     *
     * @param id
     * @param duration
     * @param description
     * @param name
     * @param parentid
     * @param relativeTime
     * @param type
     * @param changed
     */
    public LaunchEvent(Integer id, String name, String description, Integer relativeTime, Integer type, Integer duration, String changed, Integer parentid) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.relativeTime = relativeTime;
        this.type = type;
        this.duration = duration;
        this.changed = changed;
        this.parentid = parentid;
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

    public Integer getRelativeTime() {
        return relativeTime;
    }

    public void setRelativeTime(Integer relativeTime) {
        this.relativeTime = relativeTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(relativeTime);
        dest.writeValue(type);
        dest.writeValue(duration);
        dest.writeValue(changed);
        dest.writeValue(parentid);
    }

    public int describeContents() {
        return 0;
    }

}

