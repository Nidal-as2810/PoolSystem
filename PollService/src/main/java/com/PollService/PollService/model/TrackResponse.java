package com.PollService.PollService.model;

public class TrackResponse {
    private String name;
    private String url;
    private String listeners;

    public TrackResponse(String name, String url, String listeners) {
        this.name = name;
        this.url = url;
        this.listeners = listeners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }
}
