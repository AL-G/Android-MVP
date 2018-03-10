
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "launches")
public class Launch implements Serializable, Parcelable
{
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("windowstart")
    @Expose
    private String windowstart;
    @SerializedName("windowend")
    @Expose
    private String windowend;
    @SerializedName("net")
    @Expose
    private String net;
    @SerializedName("wsstamp")
    @Expose
    private Integer wsstamp;
    @SerializedName("westamp")
    @Expose
    private Integer westamp;
    @SerializedName("netstamp")
    @Expose
    private Integer netstamp;
    @SerializedName("isostart")
    @Expose
    private String isostart;
    @SerializedName("isoend")
    @Expose
    private String isoend;
    @SerializedName("isonet")
    @Expose
    private String isonet;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("inhold")
    @Expose
    private Integer inhold;
    @SerializedName("tbdtime")
    @Expose
    private Integer tbdtime;
    @Ignore
    @SerializedName("vidURLs")
    @Expose
    private List<String> vidURLs = null;
    @SerializedName("vidURL")
    @Expose
    private String vidURL;
    @Ignore
    @SerializedName("infoURLs")
    @Expose
    private List<String> infoURLs = null;
    @SerializedName("infoURL")
    @Expose
    private String infoURL;
    @SerializedName("holdreason")
    @Expose
    private String holdreason;
    @SerializedName("failreason")
    @Expose
    private String failreason;
    @SerializedName("tbddate")
    @Expose
    private Integer tbddate;
    @SerializedName("probability")
    @Expose
    private Integer probability;
    @SerializedName("hashtag")
    @Expose
    private String hashtag;
    @Ignore
    @SerializedName("location")
    @Expose
    private Location location;
    @Ignore
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @Ignore
    @SerializedName("missions")
    @Expose
    private List<Object> missions = null;
    @Ignore
    @SerializedName("lsp")
    @Expose
    private Lsp lsp;
    private final static long serialVersionUID = -3426712483807731001L;

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

    public String getWindowstart() {
        return windowstart;
    }

    public void setWindowstart(String windowstart) {
        this.windowstart = windowstart;
    }

    public String getWindowend() {
        return windowend;
    }

    public void setWindowend(String windowend) {
        this.windowend = windowend;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public Integer getWsstamp() {
        return wsstamp;
    }

    public void setWsstamp(Integer wsstamp) {
        this.wsstamp = wsstamp;
    }

    public Integer getWestamp() {
        return westamp;
    }

    public void setWestamp(Integer westamp) {
        this.westamp = westamp;
    }

    public Integer getNetstamp() {
        return netstamp;
    }

    public void setNetstamp(Integer netstamp) {
        this.netstamp = netstamp;
    }

    public String getIsostart() {
        return isostart;
    }

    public void setIsostart(String isostart) {
        this.isostart = isostart;
    }

    public String getIsoend() {
        return isoend;
    }

    public void setIsoend(String isoend) {
        this.isoend = isoend;
    }

    public String getIsonet() {
        return isonet;
    }

    public void setIsonet(String isonet) {
        this.isonet = isonet;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getInhold() {
        return inhold;
    }

    public void setInhold(Integer inhold) {
        this.inhold = inhold;
    }

    public Integer getTbdtime() {
        return tbdtime;
    }

    public void setTbdtime(Integer tbdtime) {
        this.tbdtime = tbdtime;
    }

    public List<String> getVidURLs() {
        return vidURLs;
    }

    public void setVidURLs(List<String> vidURLs) {
        this.vidURLs = vidURLs;
    }

    public String getVidURL() {
        return vidURL;
    }

    public void setVidURL(String vidURL) {
        this.vidURL = vidURL;
    }

    public List<String> getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(List<String> infoURLs) {
        this.infoURLs = infoURLs;
    }

    public String getInfoURL() {
        return infoURL;
    }

    public void setInfoURL(String infoURL) {
        this.infoURL = infoURL;
    }

    public String getHoldreason() {
        return holdreason;
    }

    public void setHoldreason(String holdreason) {
        this.holdreason = holdreason;
    }

    public String getFailreason() {
        return failreason;
    }

    public void setFailreason(String failreason) {
        this.failreason = failreason;
    }

    public Integer getTbddate() {
        return tbddate;
    }

    public void setTbddate(Integer tbddate) {
        this.tbddate = tbddate;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public List<Object> getMissions() {
        return missions;
    }

    public void setMissions(List<Object> missions) {
        this.missions = missions;
    }

    public Lsp getLsp() {
        return lsp;
    }

    public void setLsp(Lsp lsp) {
        this.lsp = lsp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.windowstart);
        dest.writeString(this.windowend);
        dest.writeString(this.net);
        dest.writeValue(this.wsstamp);
        dest.writeValue(this.westamp);
        dest.writeValue(this.netstamp);
        dest.writeString(this.isostart);
        dest.writeString(this.isoend);
        dest.writeString(this.isonet);
        dest.writeValue(this.status);
        dest.writeValue(this.inhold);
        dest.writeValue(this.tbdtime);
        dest.writeStringList(this.vidURLs);
        dest.writeString(this.vidURL);
        dest.writeStringList(this.infoURLs);
        dest.writeString(this.infoURL);
        dest.writeString(this.holdreason);
        dest.writeString(this.failreason);
        dest.writeValue(this.tbddate);
        dest.writeValue(this.probability);
        dest.writeString(this.hashtag);
        dest.writeSerializable(this.location);
        dest.writeSerializable(this.rocket);
        dest.writeList(this.missions);
        dest.writeSerializable(this.lsp);
    }

    public Launch() {
    }

    protected Launch(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.windowstart = in.readString();
        this.windowend = in.readString();
        this.net = in.readString();
        this.wsstamp = (Integer) in.readValue(Integer.class.getClassLoader());
        this.westamp = (Integer) in.readValue(Integer.class.getClassLoader());
        this.netstamp = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isostart = in.readString();
        this.isoend = in.readString();
        this.isonet = in.readString();
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.inhold = (Integer) in.readValue(Integer.class.getClassLoader());
        this.tbdtime = (Integer) in.readValue(Integer.class.getClassLoader());
        this.vidURLs = in.createStringArrayList();
        this.vidURL = in.readString();
        this.infoURLs = in.createStringArrayList();
        this.infoURL = in.readString();
        this.holdreason = in.readString();
        this.failreason = in.readString();
        this.tbddate = (Integer) in.readValue(Integer.class.getClassLoader());
        this.probability = (Integer) in.readValue(Integer.class.getClassLoader());
        this.hashtag = in.readString();
        this.location = (Location) in.readSerializable();
        this.rocket = (Rocket) in.readSerializable();
        this.missions = new ArrayList<Object>();
        in.readList(this.missions, Object.class.getClassLoader());
        this.lsp = (Lsp) in.readSerializable();
    }

    public static final Creator<Launch> CREATOR = new Creator<Launch>() {
        @Override
        public Launch createFromParcel(Parcel source) {
            return new Launch(source);
        }

        @Override
        public Launch[] newArray(int size) {
            return new Launch[size];
        }
    };

}
