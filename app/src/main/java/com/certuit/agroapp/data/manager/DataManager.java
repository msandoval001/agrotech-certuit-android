package com.certuit.agroapp.data.manager;

import com.certuit.agroapp.data.model.Crop;
import com.certuit.agroapp.data.model.GenericResponse;
import com.certuit.agroapp.data.model.Product;
import com.certuit.agroapp.data.remote.api.HackatonAPI;
import com.certuit.agroapp.data.remote.client.ServiceGenerator;

import java.util.List;

import rx.Observable;

public class DataManager {


    public Observable<List<Crop>> getCrops() {
        Observable<List<Crop>> observable;
        observable = ServiceGenerator.createService(HackatonAPI.class).getCrops();
        return observable;
    }

    public Observable<GenericResponse> createProduct(int cropId, int quantity, String sowingDate,
                                                     String harvestDate, String status,
                                                     int unit, String description) {
        Observable<GenericResponse> observable;
        observable = ServiceGenerator.createService(HackatonAPI.class).createProduct(cropId, quantity,
                sowingDate, harvestDate, status, 1, unit, description);
        return observable;
    }

    public Observable<List<Product>> getProducts() {
        Observable<List<Product>> observable;
        observable = ServiceGenerator.createService(HackatonAPI.class).getProducts();
        return observable;
    }
}
