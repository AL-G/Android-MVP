package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Payload implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("countryCodes")
    @Expose
    private String countryCodes;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("missionId")
    @Expose
    private String missionId;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = new ArrayList<>();

    public final static Creator<Payload> CREATOR = new Creator<Payload>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Payload createFromParcel(Parcel in) {
            return new Payload(in);
        }

        public Payload[] newArray(int size) {
            return (new Payload[size]);
        }

    }
            ;

    protected Payload(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCodes = ((String) in.readValue((String.class.getClassLoader())));
        this.weight = ((String) in.readValue((String.class.getClassLoader())));
        this.dimensions = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.missionId = ((String) in.readValue((String.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.agencies, (Agency.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Payload() {
    }

    /**
     *
     * @param total
     * @param id
     * @param weight
     * @param countryCodes
     * @param description
     * @param name
     * @param agencies
     * @param dimensions
     * @param type
     * @param missionId
     * @param changed
     */
    public Payload(Integer id, String name, String countryCodes, String weight, String dimensions, String description, Integer total, Integer type, String missionId, String changed, List<Agency> agencies) {
        super();
        this.id = id;
        this.name = name;
        this.countryCodes = countryCodes;
        this.weight = weight;
        this.dimensions = dimensions;
        this.description = description;
        this.total = total;
        this.type = type;
        this.missionId = missionId;
        this.changed = changed;
        this.agencies = agencies;
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

    public String getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(String countryCodes) {
        this.countryCodes = countryCodes;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(countryCodes);
        dest.writeValue(weight);
        dest.writeValue(dimensions);
        dest.writeValue(description);
        dest.writeValue(total);
        dest.writeValue(type);
        dest.writeValue(missionId);
        dest.writeValue(changed);
        dest.writeList(agencies);
    }

    public int describeContents() {
        return 0;
    }

}
