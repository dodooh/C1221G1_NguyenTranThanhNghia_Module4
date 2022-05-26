package com.codegym.model;

public class Setting {
    private String language;
    private Integer size;
    private Boolean spamFilters;
    private String signature;

    public Setting(String language, Integer size, Boolean spamFilters, String signature) {
        this.language = language;
        this.size = size;
        this.spamFilters = spamFilters;
        this.signature = signature;
    }

    public Setting() {
    }

    public Setting(Setting otherSetting) {
        this.language = otherSetting.getLanguage();
        this.size = otherSetting.getSize();
        this.spamFilters = otherSetting.getSpamFilters();
        this.signature = otherSetting.getSignature();
    }

    @Override
    public String toString() {
        return "Setting{" +
            "language='" + language + '\'' +
            ", size=" + size +
            ", spamFilters=" + spamFilters +
            ", signature='" + signature + '\'' +
            '}';
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getSpamFilters() {
        return spamFilters;
    }

    public void setSpamFilters(Boolean spamFilters) {
        this.spamFilters = spamFilters;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
