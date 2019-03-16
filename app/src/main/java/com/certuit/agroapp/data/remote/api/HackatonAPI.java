package com.certuit.agroapp.data.remote.api;

import com.certuit.agroapp.data.model.Crop;
import com.certuit.agroapp.data.model.GenericResponse;
import com.certuit.agroapp.data.model.Product;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface HackatonAPI {

    @GET("cultivos")
    Observable<List<Crop>> getCrops();

    @POST("productos")
    Observable<GenericResponse> createProduct(@Query("id_cultivo") int cropId, @Query("cantidad") int quantity,
                                              @Query("fecha_siembra") String sowingDate,
                                              @Query("fecha_cosecha") String harvestDate,
                                              @Query("estatus") String status, @Query("id_productor") int producerId,
                                              @Query("unidad") int unit, @Query("descripcion") String description);

    @GET("productos")
    Observable<List<Product>> getProducts();


}
