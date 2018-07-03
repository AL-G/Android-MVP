
package com.fivedrawdesign.rocketlaunches.data.entities;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pad implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("padType")
    @Expose
    private Integer padType;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("mapURL")
    @Expose
    private String mapURL;
    @SerializedName("retired")
    @Expose
    private Integer retired;
    @SerializedName("locationid")
    @Expose
    private Integer locationid;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = new ArrayList();
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("infoURLs")
    @Expose
    private List<Object> infoURLs = new ArrayList();
    @SerializedName("changed")
    @Expose
    private String changed;
    public final static Creator<Pad> CREATOR = new Creator<Pad>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Pad createFromParcel(Parcel in) {
            return new Pad(in);
        }

        public Pad[] newArray(int size) {
            return (new Pad[size]);
        }

    }
            ;

    protected Pad(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.padType = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.latitude = ((String) in.readValue((String.class.getClassLoader())));
        this.longitude = ((String) in.readValue((String.class.getClassLoader())));
        this.mapURL = ((String) in.readValue((String.class.getClassLoader())));
        this.retired = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.locationid = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.agencies, (Agency.class.getClassLoader()));
        this.wikiURL = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.infoURLs, (Object.class.getClassLoader()));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Pad() {
    }

    /**
     *
     * @param padType
     * @param id
     * @param wikiURL
     * @param locationid
     * @param mapURL
     * @param name
     * @param retired
     * @param agencies
     * @param longitude
     * @param latitude
     * @param infoURLs
     * @param changed
     */
    public Pad(Integer id, String name, Integer padType, String latitude, String longitude, String mapURL, Integer retired, Integer locationid, List<Agency> agencies, String wikiURL, List<Object> infoURLs, String changed) {
        super();
        this.id = id;
        this.name = name;
        this.padType = padType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mapURL = mapURL;
        this.retired = retired;
        this.locationid = locationid;
        this.agencies = agencies;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
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

    public Integer getPadType() {
        return padType;
    }

    public void setPadType(Integer padType) {
        this.padType = padType;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMapURL() {
        return mapURL;
    }

    public void setMapURL(String mapURL) {
        this.mapURL = mapURL;
    }

    public Integer getRetired() {
        return retired;
    }

    public void setRetired(Integer retired) {
        this.retired = retired;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public List<Object> getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(List<Object> infoURLs) {
        this.infoURLs = infoURLs;
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
        dest.writeValue(padType);
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(mapURL);
        dest.writeValue(retired);
        dest.writeValue(locationid);
        dest.writeList(agencies);
        dest.writeValue(wikiURL);
        dest.writeList(infoURLs);
        dest.writeValue(changed);
    }

    public int describeContents() {
        return 0;
    }

}