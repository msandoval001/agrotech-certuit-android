package com.certuit.agroapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("id")
    private int id;
    @SerializedName("content")
    private String content;
    @SerializedName("date")
    private String date;
    private int type;
    private NotificationType notificationType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
