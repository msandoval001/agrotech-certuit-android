package com.certuit.agroapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Demand implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("id_comprador")
    private User buyer;
    @SerializedName("id_cultivo")
    private Crop crop;
    @SerializedName("cantidad")
    private int quantity;

    protected Demand(Parcel in) {
        id = in.readInt();
        buyer = in.readParcelable(User.class.getClassLoader());
        crop = in.readParcelable(Crop.class.getClassLoader());
        quantity = in.readInt();
    }

    public static final Creator<Demand> CREATOR = new Creator<Demand>() {
        @Override
        public Demand createFromParcel(Parcel in) {
            return new Demand(in);
        }

        @Override
        public Demand[] newArray(int size) {
            return new Demand[size];
        }
    };

    public int getId() {
        return id;
    }

    public User getBuyer() {
        return buyer;
    }

    public Crop getCrop() {
        return crop;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeParcelable(buyer, flags);
        dest.writeParcelable(crop, flags);
        dest.writeInt(quantity);
    }
}
