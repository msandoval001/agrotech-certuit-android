package com.certuit.agroapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("unidad")
    private int unit;
    @SerializedName("cantidad")
    private int quantity;
    @SerializedName("descripcion")
    private String description;
    @SerializedName("fecha_siembra")
    private String sowingDate;
    @SerializedName("fecha_cosecha")
    private String harvestDate;
    @SerializedName("cultivo")
    private Crop crop;
    @SerializedName("productor")
    private User producer;

    protected Product(Parcel in) {
        id = in.readInt();
        unit = in.readInt();
        quantity = in.readInt();
        description = in.readString();
        sowingDate = in.readString();
        harvestDate = in.readString();
        crop = in.readParcelable(Crop.class.getClassLoader());
        producer = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getSowingDate() {
        return sowingDate;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public Crop getCrop() {
        return crop;
    }

    public User getProducer() {
        return producer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(unit);
        dest.writeInt(quantity);
        dest.writeString(description);
        dest.writeString(sowingDate);
        dest.writeString(harvestDate);
        dest.writeParcelable(crop, flags);
        dest.writeParcelable(producer, flags);
    }
}
