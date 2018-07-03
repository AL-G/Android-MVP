
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Rocket implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("configuration")
    @Expose
    private String configuration;
    @SerializedName("defaultPads")
    @Expose
    private String defaultPads;
    @SerializedName("family")
    @Expose
    private RocketFamily family;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("infoURLs")
    @Expose
    private List<String> infoURLs = new ArrayList<>();
    @SerializedName("imageSizes")
    @Expose
    private List<Integer> imageSizes = new ArrayList<>();
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = new ArrayList<>();

    public final static Creator<Rocket> CREATOR = new Creator<Rocket>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Rocket createFromParcel(Parcel in) {
            return new Rocket(in);
        }

        public Rocket[] newArray(int size) {
            return (new Rocket[size]);
        }

    };

    protected Rocket(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.configuration = ((String) in.readValue((String.class.getClassLoader())));
        this.defaultPads = ((String) in.readValue((String.class.getClassLoader())));
        this.family = ((RocketFamily) in.readValue((RocketFamily.class.getClassLoader())));
        this.wikiURL = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.infoURLs, (String.class.getClassLoader()));
        in.readList(this.imageSizes, (Integer.class.getClassLoader()));
        this.imageURL = ((String) in.readValue((String.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.agencies, (Agency.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     */
    public Rocket() {
    }

    /**
     * @param id
     * @param wikiURL
     * @param imageSizes
     * @param family
     * @param name
     * @param defaultPads
     * @param configuration
     * @param infoURLs
     * @param imageURL
     * @param changed
     */
    public Rocket(Integer id, String name, String configuration, String defaultPads, RocketFamily family, String wikiURL, List<String> infoURLs, List<Integer> imageSizes, String imageURL, String changed, List<Agency> agencies) {
        super();
        this.id = id;
        this.name = name;
        this.configuration = configuration;
        this.defaultPads = defaultPads;
        this.family = family;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
        this.imageSizes = imageSizes;
        this.imageURL = imageURL;
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

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getDefaultPads() {
        return defaultPads;
    }

    public void setDefaultPads(String defaultPads) {
        this.defaultPads = defaultPads;
    }

    public RocketFamily getFamily() {
        return family;
    }

    public void setFamily(RocketFamily family) {
        this.family = family;
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

    public List<Integer> getImageSizes() {
        return imageSizes;
    }

    public void setImageSizes(List<Integer> imageSizes) {
        this.imageSizes = imageSizes;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
        dest.writeValue(configuration);
        dest.writeValue(defaultPads);
        dest.writeValue(family);
        dest.writeValue(wikiURL);
        dest.writeList(infoURLs);
        dest.writeList(imageSizes);
        dest.writeValue(imageURL);
        dest.writeValue(changed);
    }

    public int describeContents() {
        return 0;
    }

}