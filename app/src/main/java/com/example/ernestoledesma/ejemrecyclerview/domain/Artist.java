package com.example.ernestoledesma.ejemrecyclerview.domain;


import android.support.annotation.Nullable;

import com.example.ernestoledesma.ejemrecyclerview.io.model.JsonKeys;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ernestoledesma on 11/10/16.
 */

public class Artist {

@SerializedName(JsonKeys.ARTISTS_NAME)
    String name;

    @Nullable
    private String urlMediumImage;

    @Nullable
    private String urlLargeImage;

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    @Nullable
    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(@Nullable String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    @Nullable
    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(@Nullable String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


