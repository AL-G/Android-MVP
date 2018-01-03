
package com.himumsaiddad.rocketlaunches.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agency implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("abbrev")
    @Expose
    private String abbrev;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("infoURL")
    @Expose
    private String infoURL;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("infoURLs")
    @Expose
    private List<String> infoURLs = null;
    private final static long serialVersionUID = -9085194871075769757L;

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

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public List<String> getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(List<String> infoURLs) {
        this.infoURLs = infoURLs;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.abbrev);
        dest.writeString(this.countryCode);
        dest.writeValue(this.type);
        dest.writeString(this.infoURL);
        dest.writeString(this.wikiURL);
        dest.writeStringList(this.infoURLs);
    }

    public Agency() {
    }

    protected Agency(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.abbrev = in.readString();
        this.countryCode = in.readString();
        this.type = (Integer) in.readValue(Integer.class.getClassLoader());
        this.infoURL = in.readString();
        this.wikiURL = in.readString();
        this.infoURLs = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Agency> CREATOR = new Parcelable.Creator<Agency>() {
        @Override
        public Agency createFromParcel(Parcel source) {
            return new Agency(source);
        }

        @Override
        public Agency[] newArray(int size) {
            return new Agency[size];
        }
    };

}
