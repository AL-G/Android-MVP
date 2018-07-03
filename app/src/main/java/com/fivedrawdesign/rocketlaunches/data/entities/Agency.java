
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Agency implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("abbrev")
    @Expose
    private String abbrev;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("infoURLs")
    @Expose
    private List<String> infoURLs = new ArrayList();
    @SerializedName("islsp")
    @Expose
    private Integer islsp;
    @SerializedName("changed")
    @Expose
    private String changed;
    public final static Creator<Agency> CREATOR = new Creator<Agency>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Agency createFromParcel(Parcel in) {
            return new Agency(in);
        }

        public Agency[] newArray(int size) {
            return (new Agency[size]);
        }

    };

    protected Agency(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCode = ((String) in.readValue((String.class.getClassLoader())));
        this.abbrev = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.wikiURL = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.infoURLs, (String.class.getClassLoader()));
        this.islsp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(countryCode);
        dest.writeValue(abbrev);
        dest.writeValue(type);
        dest.writeValue(wikiURL);
        dest.writeList(infoURLs);
        dest.writeValue(islsp);
        dest.writeValue(changed);
    }

    /**
     * No args constructor for use in serialization
     */
    public Agency() {
    }

    /**
     * @param id
     * @param wikiURL
     * @param islsp
     * @param name
     * @param countryCode
     * @param abbrev
     * @param type
     * @param infoURLs
     * @param changed
     */
    public Agency(Integer id, String name, String countryCode, String abbrev, Integer type, String wikiURL, List<String> infoURLs, Integer islsp, String changed) {
        super();
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.abbrev = abbrev;
        this.type = type;
        this.wikiURL = wikiURL;
        this.infoURLs = infoURLs;
        this.islsp = islsp;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getIslsp() {
        return islsp;
    }

    public void setIslsp(Integer islsp) {
        this.islsp = islsp;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }


    public int describeContents() {
        return 0;
    }

}