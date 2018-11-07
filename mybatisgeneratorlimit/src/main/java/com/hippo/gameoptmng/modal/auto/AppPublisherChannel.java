package com.hippo.gameoptmng.modal.auto;

public class AppPublisherChannel {
    private Long id;

    private Long appId;

    private Long publishChannelId;

    private String scriptParam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getPublishChannelId() {
        return publishChannelId;
    }

    public void setPublishChannelId(Long publishChannelId) {
        this.publishChannelId = publishChannelId;
    }

    public String getScriptParam() {
        return scriptParam;
    }

    public void setScriptParam(String scriptParam) {
        this.scriptParam = scriptParam == null ? null : scriptParam.trim();
    }
}