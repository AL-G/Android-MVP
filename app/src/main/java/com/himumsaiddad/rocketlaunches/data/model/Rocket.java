
package com.himumsaiddad.rocketlaunches.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rocket implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("configuration")
    @Expose
    private String configuration;
    @SerializedName("familyname")
    @Expose
    private String familyname;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = null;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("infoURLs")
    @Expose
    private List<Object> infoURLs = null;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("imageSizes")
    @Expose
    private List<Integer> imageSizes = null;
    private final static long serialVersionUID = 7072142423750805896L;

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

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<Integer> getImageSizes() {
        return imageSizes;
    }

    public void setImageSizes(List<Integer> imageSizes) {
        this.imageSizes = imageSizes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.configuration);
        dest.writeString(this.familyname);
        dest.writeTypedList(this.agencies);
        dest.writeString(this.wikiURL);
        dest.writeList(this.infoURLs);
        dest.writeString(this.imageURL);
        dest.writeList(this.imageSizes);
    }

    public Rocket() {
    }

    protected Rocket(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.configuration = in.readString();
        this.familyname = in.readString();
        this.agencies = in.createTypedArrayList(Agency.CREATOR);
        this.wikiURL = in.readString();
        this.infoURLs = new ArrayList<Object>();
        in.readList(this.infoURLs, Object.class.getClassLoader());
        this.imageURL = in.readString();
        this.imageSizes = new ArrayList<Integer>();
        in.readList(this.imageSizes, Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Rocket> CREATOR = new Parcelable.Creator<Rocket>() {
        @Override
        public Rocket createFromParcel(Parcel source) {
            return new Rocket(source);
        }

        @Override
        public Rocket[] newArray(int size) {
            return new Rocket[size];
        }
    };

}
