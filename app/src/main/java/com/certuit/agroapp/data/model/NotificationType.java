package com.certuit.agroapp.data.model;

public enum NotificationType {
    BUYER(1, "Comprador nuevo"),
    CROP_READY(2, "Cosecha lista"),
    SALE_MADE(3, "Venta realizada");


    private int id;
    private String name;

    NotificationType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static NotificationType valueOf(int id) {
        switch (id) {
            case 1:
                return BUYER;
            case 2:
                return CROP_READY;
            default:
                return null;
        }
    }
}
