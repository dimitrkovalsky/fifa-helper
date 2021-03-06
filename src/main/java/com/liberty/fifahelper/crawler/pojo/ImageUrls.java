package com.liberty.fifahelper.crawler.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class ImageUrls implements Serializable {

    @JsonProperty("dark")
    public Dark dark;

    @JsonProperty("normal")
    public Normal normal;

    @JsonProperty("medium")
    public Object medium;

    @JsonProperty("small")
    public Object small;

    @JsonProperty("large")
    public Object large;


}