
package com.himumsaiddad.rocketlaunches.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location implements Serializable, Parcelable {

    @SerializedName("pads")
    @Expose
    private List<Pad> pads = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("infoURL")
    @Expose
    private String infoURL;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    private final static long serialVersionUID = -1462675987008903635L;

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

    public String getInfoURL() {
        return infoURL;
    }

    public void setInfoURL(String infoURL) {
        this.infoURL = infoURL;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.pads);
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.infoURL);
        dest.writeString(this.wikiURL);
        dest.writeString(this.countryCode);
    }

    public Location() {
    }

    protected Location(Parcel in) {
        this.pads = new ArrayList<Pad>();
        in.readList(this.pads, Pad.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.infoURL = in.readString();
        this.wikiURL = in.readString();
        this.countryCode = in.readString();
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

}
