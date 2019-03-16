package com.certuit.agroapp.data.model;

import com.google.gson.annotations.SerializedName;

public class GenericResponse {

    @SerializedName("message")
    private String message;
    @SerializedName("link")
    private String link;
}
