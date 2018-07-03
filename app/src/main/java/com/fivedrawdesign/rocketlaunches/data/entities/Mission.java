package com.fivedrawdesign.rocketlaunches.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Mission implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = new ArrayList<>();
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("typeName")
    @Expose
    private String typeName;
    @SerializedName("launch")
    @Expose
    private Launch launch;
    @SerializedName("wikiURL")
    @Expose
    private String wikiURL;
    @SerializedName("events")
    @Expose
    private Event events;
    @SerializedName("infoURLs")
    @Expose
    private List<String> infoURLs = new ArrayList<>();
    @SerializedName("changed")
    @Expose
    private String changed;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = new ArrayList<>();
    public final static Creator<Mission> CREATOR = new Creator<Mission>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Mission createFromParcel(Parcel in) {
            return new Mission(in);
        }

        public Mission[] newArray(int size) {
            return (new Mission[size]);
        }

    }
            ;



    /**
     * No args constructor for use in serialization
     *
     */
    public Mission() {
    }

    /**
     *
     * @param events
     * @param launch
     * @param agencies
     * @param type
     * @param changed
     * @param id
     * @param typeName
     * @param wikiURL
     * @param description
     * @param name
     * @param payloads
     * @param infoURLs
     */
    public Mission(Integer id, String name, String description, List<Agency> agencies, Integer type, String typeName, Launch launch, String wikiURL, Event events, List<String> infoURLs, String changed, List<Payload> payloads) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.agencies = agencies;
        this.type = type;
        this.typeName = typeName;
        this.launch = launch;
        this.wikiURL = wikiURL;
        this.events = events;
        this.infoURLs = infoURLs;
        this.changed = changed;
        this.payloads = payloads;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Launch getLaunch() {
        return launch;
    }

    public void setLaunch(Launch launch) {
        this.launch = launch;
    }

    public String getWikiURL() {
        return wikiURL;
    }

    public void setWikiURL(String wikiURL) {
        this.wikiURL = wikiURL;
    }

    public Event getEvents() {
        return events;
    }

    public void setEvents(Event events) {
        this.events = events;
    }

    public List<String> getInfoURLs() {
        return infoURLs;
    }

    public void setInfoURLs(List<String> infoURLs) {
        this.infoURLs = infoURLs;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

    protected Mission(Parcel in) {
            this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.agencies, (Agency.class.getClassLoader()));
        this.type = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.typeName = ((String) in.readValue((String.class.getClassLoader())));
        this.launch = ((Launch) in.readValue((Launch.class.getClassLoader())));
        this.wikiURL = ((String) in.readValue((String.class.getClassLoader())));
        this.events = ((Event) in.readValue((Event.class.getClassLoader())));
        in.readList(this.infoURLs, (String.class.getClassLoader()));
        this.changed = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.payloads, (Payload.class.getClassLoader()));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
       dest.writeValue(name);
        dest.writeValue(description);
        dest.writeList(agencies);
        dest.writeValue(type);
        dest.writeValue(typeName);
        dest.writeValue(launch);
        dest.writeValue(wikiURL);
        dest.writeValue(events);
        dest.writeList(infoURLs);
        dest.writeValue(changed);
        dest.writeList(payloads);
    }

    public int describeContents() {
        return 0;
    }

}
