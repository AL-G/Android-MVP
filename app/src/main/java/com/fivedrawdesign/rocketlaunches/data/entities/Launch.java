
package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Launch implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    // String (formatted as Month, dd, yyyy hh24:mi:ss UTC)
    @SerializedName("windowstart")
    @Expose
    private String windowstart;

    // String (formatted as Month, dd, yyyy hh24:mi:ss UTC)
    @SerializedName("windowend")
    @Expose
    private String windowend;

    // String (formatted as Month, dd, yyyy hh24:mi:ss UTC)
    @SerializedName("net")
    @Expose
    private String net;

    // Integer (Unix timestamp)
    @SerializedName("wsstamp")
    @Expose
    private Integer wsstamp;

    // Integer (Unix timestamp)
    @SerializedName("westamp")
    @Expose
    private Integer westamp;

    // Integer (Unix timestamp)
    @SerializedName("netstamp")
    @Expose
    private Integer netstamp;

    // String (formatted as yyyymmddThh24missZ)
    @SerializedName("isostart")
    @Expose
    private String isostart;

    // String (formatted as yyyymmddThh24missZ)
    @SerializedName("isoend")
    @Expose
    private String isoend;

    // String (formatted as yyyymmddThh24missZ)
    @SerializedName("isonet")
    @Expose
    private String isonet;

    // (1 Green, 2 Red, 3 Success, 4 Failed)
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("tbdtime")
    @Expose
    private Integer tbdtime;
    @SerializedName("vidURLs")
    @Expose
    private List<String> vidURLs = new ArrayList<String>();
    @SerializedName("infoURLs")
    @Expose
    private List<String> infoURLs = new ArrayList<String>();
    @SerializedName("holdreason")
    @Expose
    private String holdreason;
    @SerializedName("failreason")
    @Expose
    private String failreason;
    @SerializedName("tbddate")
    @Expose
    private Integer tbddate;

    // (will be -1 if unkown to us)
    @SerializedName("probability")
    @Expose
    private String probability;
    @SerializedName("hashtag")
    @Expose
    private String hashtag;
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("missions")
    @Expose
    private List<Mission> missions = new ArrayList<>();

    @SerializedName("lsp")
    @Expose
    private Agency lsp;

    public final static Creator<Launch> CREATOR = new Creator<Launch>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Launch createFromParcel(Parcel in) {
            return new Launch(in);
        }

        public Launch[] newArray(int size) {
            return (new Launch[size]);
        }

    };

    protected Launch(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.windowstart = ((String) in.readValue((String.class.getClassLoader())));
        this.windowend = ((String) in.readValue((String.class.getClassLoader())));
        this.net = ((String) in.readValue((String.class.getClassLoader())));
        this.wsstamp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.westamp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.netstamp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isostart = ((String) in.readValue((String.class.getClassLoader())));
        this.isoend = ((String) in.readValue((String.class.getClassLoader())));
        this.isonet = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tbdtime = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.vidURLs, (String.class.getClassLoader()));
        in.readList(this.infoURLs, (String.class.getClassLoader()));
        this.holdreason = ((String) in.readValue((String.class.getClassLoader())));
        this.failreason = ((String) in.readValue((String.class.getClassLoader())));
        this.tbddate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.probability = ((String) in.readValue((String.class.getClassLoader())));
        this.hashtag = ((String) in.readValue((String.class.getClassLoader())));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.rocket = ((Rocket) in.readValue((Rocket.class.getClassLoader())));
        this.lsp = ((Agency) in.readValue((Agency.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public Launch() {
    }

    /**
     *

     */
    public Launch(Integer id, String name, String windowstart, String windowend, String net, Integer wsstamp, Integer westamp, Integer netstamp, String isostart, String isoend, String isonet, Integer status, Integer inhold, Integer tbdtime, List<String> vidURLs, List<String> infoURLs, String holdreason, String failreason, Integer tbddate, String probability, String hashtag, String changed, Location location, Rocket rocket, List<Mission> missions, Agency lsp) {
        super();
        this.id = id;
        this.name = name;
        this.windowstart = windowstart;
        this.windowend = windowend;
        this.net = net;
        this.wsstamp = wsstamp;
        this.westamp = westamp;
        this.netstamp = netstamp;
        this.isostart = isostart;
        this.isoend = isoend;
        this.isonet = isonet;
        this.status = status;
        this.tbdtime = tbdtime;
        this.vidURLs = vidURLs;
        this.infoURLs = infoURLs;
        this.holdreason = holdreason;
        this.failreason = failreason;
        this.tbddate = tbddate;
        this.probability = probability;
        this.hashtag = hashtag;
        this.changed = changed;
        this.location = location;
        this.rocket = rocket;
        this.missions = missions;
        this.lsp = lsp;
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

    public Integer getTbdtime() {
        return tbdtime;
    }

    public void setTbdtime(Integer tbdtime) {
        this.tbdtime = tbdtime;
    }

    //
    public List<String> getVidURLs() {
        return vidURLs;
    }

    public void setVidURLs(List<String> vidURLs) {
        this.vidURLs = vidURLs;
    }

    public List<String> getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(List<String> infoURLs) {
        this.infoURLs = infoURLs;
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

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
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

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public Agency getLsp() {
        return lsp;
    }

    public void setLsp(Agency lsp) {
        this.lsp = lsp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(windowstart);
        dest.writeValue(windowend);
        dest.writeValue(net);
        dest.writeValue(wsstamp);
        dest.writeValue(westamp);
        dest.writeValue(netstamp);
        dest.writeValue(isostart);
        dest.writeValue(isoend);
        dest.writeValue(isonet);
        dest.writeValue(status);
        dest.writeValue(tbdtime);
        dest.writeList(vidURLs);
        dest.writeList(infoURLs);
        dest.writeValue(holdreason);
        dest.writeValue(failreason);
        dest.writeValue(tbddate);
        dest.writeValue(probability);
        dest.writeValue(hashtag);
        dest.writeValue(changed);
        dest.writeValue(location);
        dest.writeValue(rocket);
        dest.writeList(missions);
        dest.writeValue(lsp);
    }

    public int describeContents() {
        return 0;
    }

}
