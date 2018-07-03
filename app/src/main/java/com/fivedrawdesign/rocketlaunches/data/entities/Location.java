
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Location implements Parcelable
{

    @SerializedName("pads")
    @Expose
    private List<Pad> pads = new ArrayList<Pad>();
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    public final static Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
    ;

    protected Location(Parcel in) {
        in.readList(this.pads, (Pad.class.getClassLoader()));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.wikiURL = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param id
     * @param wikiURL
     * @param name
     * @param pads
     * @param countryCode
     */
    public Location(List<Pad> pads, Integer id, String name, String wikiURL, String countryCode) {
        super();
        this.pads = pads;
        this.id = id;
        this.name = name;
        this.wikiURL = wikiURL;
        this.countryCode = countryCode;
    }

    public List<Pad> getPads() {
        return pads;
    }

    public void setPads(List<Pad> pads) {
        this.pads = pads;
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

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(pads);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(wikiURL);
        dest.writeValue(countryCode);
    }

    public int describeContents() {
        return  0;
    }

}
